package oa.dao.table;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oa.dao.BaseDao;
import oa.model.table.Base_info;
import oa.util.ResultList;

public class BaseInfoDao extends BaseDao{
	
private static final Logger log = LoggerFactory.getLogger(BaseInfoDao.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(Base_info instance) {
		log.debug("saving Base_info instance");
		try {
			super.save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}
	
	public void saveFilmList(List<Base_info> instance) {
		log.debug("saving Base_infoList instance");
		try {
			super.saveList(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}

	public void delete(Base_info instance) {
		log.debug("deleting Base_info instance");
		try {
			super.delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.debug("delete failed", re);
			throw re;
		}
	}

	public void update(Base_info instance) {
		log.debug("update Base_info instance");
		try {
			super.update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.debug("update failed", re);
			throw re;
		}
	}


	public Base_info findById(String id) {
		log.debug("getting Base_info instance with id: " + id);
		try {
			Base_info instance = (Base_info) super.get("oa.model.table.Base_info", id);
			return instance;
		} catch (RuntimeException re) {
			log.debug("get failed", re);
			throw re;
		}
	}
	


	public ResultList<Base_info> findByExample(Integer pageNo, Base_info base_info) {
		log.debug("find Base_info instances with example");
		try {
			return super.find(pageNo, "oa.model.table.Base_info", base_info);
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}

	public ResultList<Base_info> findAll(Integer pageNo) {
		log.debug("finding all Base_info instances");
		try {
			return super.find(pageNo, "oa.model.table.Base_info");
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
	
	public ResultList<Base_info> findByCondition(Integer pageNo, String conditions){
		log.debug("finding Base_info instance with conditions: " + conditions);
		try {
			return super.find(pageNo, "oa.model.table.Base_info", conditions);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}

	public ResultList<Base_info> findByProperty(Integer pageNo, String propertyName, String value) {
		log.debug("finding Base_info instance with property: " + propertyName
				+ ", value: " + value);
		try {
			return super.find(pageNo, "oa.model.table.Base_info", propertyName, value);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByHQL(Integer pageNo, String hql){
		log.debug("finding Base_info instance with hql: " + hql
				);
		try {
			return super.findByHQl(pageNo, hql);
		} catch (RuntimeException re) {
			log.debug("find failed", re);
			throw re;
		}
	}
	
	public String findCount(String hql){
		log.debug("finding count instance with hql: " + hql
		);
		try {
			return super.findCount(hql);
		} catch (RuntimeException re) {
			log.debug("find failed", re);
			throw re;
		}
	}
}
