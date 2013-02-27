package oa.dao.table;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oa.dao.BaseDao;
import oa.model.table.New_trends;
import oa.util.ResultList;

public class NewTrendsDao extends BaseDao{
	
	private static final Logger log = LoggerFactory.getLogger(NewTrendsDao.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(New_trends instance) {
		log.debug("saving New_trends instance");
		try {
			super.save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}
	
	public void saveNewsList(List<New_trends> instance) {
		log.debug("saving NewsList instance");
		try {
			super.saveList(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}
	
	public void delete(New_trends instance) {
		log.debug("deleting New_trends instance");
		try {
			super.delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.debug("delete failed", re);
			throw re;
		}
	}
	
	public void update(New_trends instance) {
		log.debug("update New_trends instance");
		try {
			super.update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.debug("update failed", re);
			throw re;
		}
	}
	
	public New_trends findById(String id) {
		log.debug("getting New_trends instance with id: " + id);
		try {
			New_trends instance = (New_trends) super.get("oa.model.table.New_trends", id);
			return instance;
		} catch (RuntimeException re) {
			log.debug("get failed", re);
			throw re;
		}
	}
	
	public ResultList<New_trends> findByExample(Integer pageNo, New_trends new_trends) {
		log.debug("find New_trends instances with example");
		try {
			return super.find(pageNo, "oa.model.table.New_trends", new_trends);
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
	
	public ResultList<New_trends> findAll(Integer pageNo) {
		log.debug("finding all New_trends instances");
		try {
			return super.find(pageNo, "oa.model.table.New_trends");
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
	
	public ResultList<New_trends> findByCondition(Integer pageNo, String conditions){
		log.debug("finding New_trends instance with conditions: " + conditions);
		try {
			return super.find(pageNo, "oa.model.table.New_trends", conditions);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}
	
	public ResultList<New_trends> findByProperty(Integer pageNo, String propertyName, String value) {
		log.debug("finding New_trends instance with property: " + propertyName
				+ ", value: " + value);
		try {
			return super.find(pageNo, "oa.model.table.New_trends", propertyName, value);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByHQL(Integer pageNo, String hql){
		log.debug("finding New_trends instance with hql: " + hql
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
