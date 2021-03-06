package oa.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Required;
import oa.util.ExceptionUtil;
import oa.util.ResultList;

public abstract class BaseDao {

	private DaoTemplate daoTemplate;
	
	
	//hql查询
	@SuppressWarnings("rawtypes")
	protected List findByHQl(Integer pageNo, String hql){
	
		return DaoUtil.findByHQL(pageNo, hql);
	}
	protected String findCount(String hql){
		return DaoUtil.findCount(hql);
	}
	
	/**
	 * 添加
	 * @param obj
	 */
	protected void save(Object obj){
		daoTemplate.save(obj);
	}
	
	/**
	 * 在同一个事务中同时添加多条数据
	 * @param obj
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void saveList(List objList){
		daoTemplate.saveList(objList);
	}

	/**
	 * 删除
	 * @param obj
	 */
	protected void delete(Object obj){
		daoTemplate.delete(obj);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void deleteList(List objList){
		daoTemplate.deleteAll(objList);
	}
	
	/**
	 * 更新
	 * @param obj
	 */
	protected void update(Object obj){
		daoTemplate.update(obj);
	}
	
	/**
	 * 按ID查询
	 * @param clsname
	 * @param id
	 * @return 有可能为null
	 */
	protected Object get(String clsname, Serializable id){
		return daoTemplate.get(clsname, id);
	}
	


	
	
	/**
	 * 分页列出一个表中的所有数据
	 * @param pageNo
	 * @param clsname
	 * @return 不可能为null
	 */
	@SuppressWarnings("rawtypes")
	protected ResultList find(Integer pageNo, String clsname){
		return daoTemplate.find(pageNo, clsname);
	}
	

	/**
	 * 分页查询，以一个字段为条件
	 * @param pageNo
	 * @param clsname
	 * @param propertyName
	 * @param value
	 * @return 不可能为null
	 */
	@SuppressWarnings("rawtypes")
	protected ResultList find(Integer pageNo, String clsname, String propertyName, String value){
		return daoTemplate.find(pageNo, clsname, propertyName, value);
	}
	
	
	/**
	 * 分页查询，以一个model对象为条件
	 * @param pageNo
	 * @param clsname
	 * @param obj
	 * @return 不可能为null
	 */
	@SuppressWarnings("rawtypes")
	protected ResultList find(Integer pageNo, String clsname, Object condition){
		return daoTemplate.find(pageNo, clsname, condition);
	}
	
	/**
	 * 分页查询，以一个字符串为条件，只在SQL查询中被支持，XML查询不支持
	 * @param pageNo
	 * @param clsname
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected ResultList find(Integer pageNo, String clsname, String condition){
		if(daoTemplate instanceof HibernateTemplate){
			return daoTemplate.find(pageNo, clsname, condition);
		}else{
			ExceptionUtil.throwException(new DaoLocalException("当前配置下不支持按条件字符串查询"));
			return null;
		}
	}

	
	// =========== getter and setter ============
	public DaoTemplate getDaoTemplate() {
		return daoTemplate;
	}

	@Required
	public void setDaoTemplate(DaoTemplate daoTemplate) {
		this.daoTemplate = daoTemplate;
	}
	

	
}
