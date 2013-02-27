package oa.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import oa.util.ResultList;
import oa.util.SystemConfig;
import oa.util.OaConfig;

public class HibernateTemplate extends HibernateDaoSupport implements
		DaoTemplate {

	/**
	 * 添加
	 * 
	 * @param obj
	 */
	public void save(Object obj) {
		getHibernateTemplate().save(obj);
	}

	/**
	 * 在同一个事务中同时添加多条数据
	 * 
	 * @param obj
	 */
	public void saveList(List<Object> list) {
		getHibernateTemplate().saveOrUpdateAll(list);
	}

	/**
	 * 删除
	 * 
	 * @param obj
	 */
	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	public void deleteAll(List<Object> list) {
		getHibernateTemplate().deleteAll(list);
	}

	/**
	 * 更新
	 * 
	 * @param obj
	 */
	public void update(Object obj) {
		getHibernateTemplate().update(obj);
	}

	/**
	 * 按ID查询
	 * 
	 * @param clsname
	 * @param id
	 * @return 有可能为null
	 */
	public Object get(String clsname, Serializable id) {
		if (OaConfig.devMode) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx: get " + clsname
					+ "  id= " + id);
		}

		return getHibernateTemplate().get(clsname, id);
	}

	/**
	 * 分页列出一个表中的所有数据
	 * 
	 * @param pageNo
	 * @param clsname
	 * @return 不可能为null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResultList find(Integer pageNo, String clsname) {
		Integer pageSize = SystemConfig.getPageSize();
		String queryString = "from " + clsname;

		if (OaConfig.devMode) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx: " + queryString);
		}

		// 查出数目
		String count = ((Long) (getHibernateTemplate().find(
				"select count(*) " + queryString).get(0))).toString();

		// 分页查出数据
		List list = null;
		if (pageNo != null && pageSize != null) {
			list = getListForPage(queryString, (pageNo - 1) * pageSize,
					pageSize);
		} else {
			list = getHibernateTemplate().find(queryString);
		}

		// 封装
		ResultList result = new ResultList(list.size());
		result.setCount(count);
		for (Object obj : list) {
			result.add(obj);
		}
		return result;
	}

	/**
	 * 分页查询，以一个字段为条件
	 * 
	 * @param pageNo
	 * @param clsname
	 * @param propertyName
	 * @param value
	 * @return 不可能为null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResultList find(Integer pageNo, String clsname, String propertyName,
			String value) {
		Integer pageSize = SystemConfig.getPageSize();
		String queryString = "from " + clsname + " where " + propertyName
				+ "= '" + value + "'";

		if (OaConfig.devMode) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx: " + queryString);
		}

		// 查出数目
		String count = ((Long) (getHibernateTemplate().find(
				"select count(*) " + queryString).get(0))).toString();

		// 分页查出数据
		List list = null;
		if (pageNo != null && pageSize != null) {
			list = getListForPage(queryString, (pageNo - 1) * pageSize,
					pageSize);
		} else {
			list = getHibernateTemplate().find(queryString);
		}

		// 封装
		ResultList result = new ResultList(list.size());
		result.setCount(count);
		for (Object obj : list) {
			result.add(obj);
		}
		return result;

	}

	/**
	 * 分页查询，以一个字段或另一个字段为条件
	 * 
	 * @param pageNo
	 * @param clsname
	 * @param propertyName
	 * @param value
	 * @return 不可能为null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResultList find(Integer pageNo, String clsname,
			String propertyName1, String propertyName2, String value) {
		Integer pageSize = SystemConfig.getPageSize();
		String queryString = "from " + clsname + " where " + propertyName1
				+ "= '" + value + "' or " + propertyName2 + "='" + value + "'";

		if (OaConfig.devMode) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx: " + queryString);
		}

		// 查出数目
		String count = ((Long) (getHibernateTemplate().find(
				"select count(*) " + queryString).get(0))).toString();

		// 分页查出数据
		List list = null;
		if (pageNo != null && pageSize != null) {
			list = getListForPage(queryString, (pageNo - 1) * pageSize,
					pageSize);
		} else {
			list = getHibernateTemplate().find(queryString);
		}

		// 封装
		ResultList result = new ResultList(list.size());
		result.setCount(count);
		for (Object obj : list) {
			result.add(obj);
		}
		return result;

	}

	/**
	 * 分页查询，以一个字段或另一个字段为条件模糊查询
	 * 
	 * @param pageNo
	 * @param clsname
	 * @param propertyName
	 * @param value
	 * @return 不可能为null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResultList likefind(Integer pageNo, String clsname,
			String propertyName1, String propertyName2, String value) {
		Integer pageSize = SystemConfig.getPageSize();
		String queryString = null;
		if (propertyName1 != null) {
			queryString = "from " + clsname + " t where t." + propertyName1
					+ "= '" + value + "' or t." + propertyName2 + " like '%"
					+ value + "%'";
		} else {
			queryString = "from " + clsname + " t where t." + propertyName2
					+ " like '%" + value + "%'";
		}
		if (OaConfig.devMode) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx: " + queryString);
		}

		// 查出数目
		String count = ((Long) (getHibernateTemplate().find(
				"select count(*) " + queryString).get(0))).toString();

		// 分页查出数据
		List list = null;
		if (pageNo != null && pageSize != null) {
			list = getListForPage(queryString, (pageNo - 1) * pageSize,
					pageSize);
		} else {
			list = getHibernateTemplate().find(queryString);
		}

		// 封装
		ResultList result = new ResultList(list.size());
		result.setCount(count);
		for (Object obj : list) {
			result.add(obj);
		}
		return result;

	}

	/**
	 * 按属性查询，不分页
	 */
	@SuppressWarnings({ "rawtypes" })
	public List find(String clsname, String propertyName, String value) {
		String queryString = "from " + clsname + " where " + propertyName
				+ "= '" + value + "'";
		List list = getHibernateTemplate().find(queryString);
		return list;
	}

	/**
	 * 分页查询，以一个对象为条件，这个对象可以是String或者Model
	 * 
	 * @param pageNo
	 * @param clsname
	 * @param obj
	 * @return 不可能为null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResultList find(Integer pageNo, String clsname, Object obj) {
		Integer pageSize = SystemConfig.getPageSize();

		String queryString = "from " + clsname + " where 1=1 ";
		if (obj instanceof String) {
			queryString += (String) obj;
		} else {
			queryString += DaoUtil.getStringConditions(obj);
		}

		if (OaConfig.devMode) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx: " + queryString);
		}

		// 查出数目
		String count = ((Long) (getHibernateTemplate().find(
				"select count(*) " + queryString).get(0))).toString();

		// 分页查出数据
		List list = null;
		if (pageNo != null && pageSize != null) {
			list = getListForPage(queryString, (pageNo - 1) * pageSize,
					pageSize);
		} else {
			list = getHibernateTemplate().find(queryString);
		}

		// 封装
		ResultList result = new ResultList(list.size());
		result.setCount(count);
		for (Object object : list) {
			result.add(object);
		}
		return result;
	}

	/**
	 * 分页通用方法
	 * 
	 * @param hql
	 *            HQL查询语句
	 * @param offset
	 *            起始记录下标
	 * @param lengh
	 *            读取记录数
	 * @return List 结果集
	 */
	@SuppressWarnings("rawtypes")
	private List getListForPage(final String hql, final int offset,
			final int lengh) {
		List list = getHibernateTemplate().executeFind(
				new HibernateCallback<List>() {

					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						List list2 = session.createQuery(hql)
								.setFirstResult(offset).setMaxResults(lengh)
								.list();
						return list2;
					}
				});
		return list;
	}

}
