package oa.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import oa.exception.LogicException;
import oa.util.ExceptionUtil;
import oa.util.SystemConfig;

@SuppressWarnings("unchecked")
public final class DaoUtil {
	private static SessionFactory sessionFactory;
	
	private DaoUtil(){}

	public static enum DaoAction{INSERT, DELETE, UPDATE, SELECT}
	
	@SuppressWarnings("rawtypes")
	public static List findByHQL(Integer page, String hql){
		if(sessionFactory == null){
			WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
			sessionFactory = (SessionFactory)webContext.getBean("sessionFactory");
		}
		
		if(page != null && page < 1){
			ExceptionUtil.throwException(new LogicException("页码必须大于零"));
		}
		
		Session session = sessionFactory.openSession();
		List result = null;
		try {
			Integer pageSize = SystemConfig.getPageSize();
			
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz: " + hql);
			//分页查出数据
			Query query = session.createQuery(hql);
			if(page != null && pageSize != null){
				query.setFirstResult((page - 1) * pageSize);
				query.setMaxResults(pageSize);
			}
			result = query.list();
		} catch (HibernateException e) {
			ExceptionUtil.throwException(new DaoLocalException("查询出错"));
		} finally {
			session.close();
		}
		return result;
	}
	
	public static String findCount(String hql){
		if(sessionFactory == null){
			WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
			sessionFactory = (SessionFactory)webContext.getBean("sessionFactory");
		}
		Session session = sessionFactory.openSession();
		String count = null;
		try {
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz: " + hql);
			count = ((Long)session.createQuery(hql).iterate().next()).toString();
		} catch (HibernateException e) {
			ExceptionUtil.throwException(new DaoLocalException("查询出错", e));
		} finally {
			session.close();
		}
		return count;
	}
	
	
	


	/**
	 * 获取ID字段名称
	 * @param clsname
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getIdFromClsName(String clsname){
		try {
			Class cls = Class.forName(clsname);
			DatabaseAnno anno = (DatabaseAnno) cls.getAnnotation(DatabaseAnno.class);
			return anno.id();//得到该表的id字段
		} catch (ClassNotFoundException e) {
			ExceptionUtil.throwException(new DaoLocalException("数据模型未找到", e));
		}
		return null;
	}

	/**
	 * 获取ID字段名称
	 * @param obj
	 * @return
	 */
	public static String getIdFromObj(Object obj){
		String clsname = obj.getClass().getName();
		return getIdFromClsName(clsname);
	}

	/**
	 * 从对象中提取出值
	 * @param obj
	 * @return
	 */
	public static Map<String, String> getValues(Object obj){
		return getValues(obj, true);
	}

	/**
	 * 从对象中提取出值，不提取ID值
	 * @param obj
	 * @return
	 */
	public static Map<String, String> getValuesWithoutId(Object obj){
		return getValues(obj, false);
	}
	
	private static Map<String, String> getValues(Object obj, boolean needIdValue){
		String idName = getIdFromObj(obj);
		Map<String, String> map = new HashMap<String, String>();
		Method[] methods = obj.getClass().getDeclaredMethods();
		for(Method method : methods){
			String name = method.getName();
			String getIdName = "get" + idName;
			if(name.substring(0, 3).equals("get") && (needIdValue || !name.toLowerCase().equals(getIdName))){
				String value = null;
				try {
					Object objVal = method.invoke(obj, (Object[])null);
					if(objVal instanceof String){
						value = (String)objVal;
					}
				} catch (IllegalArgumentException e) {
					ExceptionUtil.throwException(new DaoLocalException("解析数据模型出错", e));
				} catch (IllegalAccessException e) {
					ExceptionUtil.throwException(new DaoLocalException("解析数据模型出错", e));
				} catch (InvocationTargetException e) {
					ExceptionUtil.throwException(new DaoLocalException("解析数据模型出错", e));
				}
				if(value != null && !value.trim().equals("")){
					map.put(name.substring(3), value);
				}
			}
		}

		return map;
	}

	
	/**
	 * 从对象中提取出条件
	 * @param obj
	 * @return
	 */
	public static String getStringConditions(Object obj){
		return getStringConditions("", obj);
	}
	
	private static String getStringConditions(String prefix, Object obj){
		String conditions = " ";
		if(obj == null){
			return conditions;
		}
		
		Method[] methods = obj.getClass().getDeclaredMethods();
		for(Method method : methods){
			String name = method.getName();
			if(name.substring(0, 3).equals("get")){
				Object value = null;
				try {
					value = method.invoke(obj, (Object[])null);
				} catch (IllegalArgumentException e) {
					ExceptionUtil.throwException(new DaoLocalException("解析数据模型出错", e));
				} catch (IllegalAccessException e) {
					ExceptionUtil.throwException(new DaoLocalException("解析数据模型出错", e));
				} catch (InvocationTargetException e) {
					ExceptionUtil.throwException(new DaoLocalException("解析数据模型出错", e));
				}
				if(value != null){
					String field = name.substring(3).toLowerCase();
					if(value instanceof String){
						if(!((String)value).trim().equals("")){
							field = prefix + field;
							conditions += " and " + field + "='" + value + "'";
						}
					}else if(value instanceof Number){
						field = prefix + field;
						conditions += " and " + field + "='" + value + "'";
					}else{
						conditions += getStringConditions(field + ".", value);
					}
				}
			}
		}

		return conditions;
	}



	public static String getAllFields(Class<Object> clazz){
		Field[] fields = clazz.getDeclaredFields();

		if(fields == null){
			ExceptionUtil.throwException(new DaoLocalException("未找到任何字段名"));
		}

		StringBuffer buffer = new StringBuffer("");
		for(Field field : fields){
			buffer.append(field.getName());
			buffer.append(",");
		}
		String ret = buffer.toString();

		if(ret == null || ret.equals("")){
			ExceptionUtil.throwException(new DaoLocalException("未找到任何字段名"));
		}
		return ret.substring(0, ret.length()-1);
	}
}
