package oa.dao.table;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oa.dao.BaseDao;
import oa.model.table.User;
import oa.util.ResultList;

public class UserDao extends BaseDao{
	
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(User instance) {
		log.debug("saving User instance");
		try {
			super.save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}
	
	public void saveUserList(List<User> instance) {
		log.debug("saving UserList instance");
		try {
			super.saveList(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}

	public void delete(User instance) {
		log.debug("deleting User instance");
		try {
			super.delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.debug("delete failed", re);
			throw re;
		}
	}

	public void update(User instance) {
		log.debug("update User instance");
		try {
			super.update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.debug("update failed", re);
			throw re;
		}
	}


	public User findById(String id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) super.get("oa.model.table.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.debug("get failed", re);
			throw re;
		}
	}
	


	public ResultList<User> findByExample(Integer pageNo, User user) {
		log.debug("find User instances with example");
		try {
			return super.find(pageNo, "oa.model.table.User", user);
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}

	public ResultList<User> findAll(Integer pageNo) {
		log.debug("finding all User instances");
		try {
			return super.find(pageNo, "oa.model.table.User");
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
	
	public ResultList<User> findByCondition(Integer pageNo, String conditions){
		log.debug("finding User instance with conditions: " + conditions);
		try {
			return super.find(pageNo, "oa.model.table.User", conditions);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}

	public ResultList<User> findByProperty(Integer pageNo, String propertyName, String value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			return super.find(pageNo, "oa.model.table.User", propertyName, value);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByHQL(Integer pageNo, String hql){
		log.debug("finding User instance with hql: " + hql
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
