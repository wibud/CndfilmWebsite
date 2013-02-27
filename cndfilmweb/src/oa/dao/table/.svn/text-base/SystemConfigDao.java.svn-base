package oa.dao.table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oa.dao.BaseDao;
import oa.model.table.System_config;
import oa.util.ResultList;

@SuppressWarnings("unchecked")
public class SystemConfigDao extends BaseDao {

	private static final Logger log = LoggerFactory.getLogger(SystemConfigDao.class);
	// property constants
	public static final String CFG_NAME = "cfg_name";	//配置名称
	public static final String CFG_VALUE = "cfg_value";	//配置值
	public static final String CFG_DESC = "cfg_desc";	//配置描述
	public static final String REMARK = "remark";		//备注

	protected void initDao() {
		// do nothing
	}

	public void save(System_config transientInstance) {
		log.debug("saving System_config instance");
		try {
			super.save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}

	public void delete(System_config persistentInstance) {
		log.debug("deleting System_config instance");
		try {
			super.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.debug("delete failed", re);
			throw re;
		}
	}

	public void update(System_config instance) {
		log.debug("update System_config instance");
		try {
			super.update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.debug("update failed", re);
			throw re;
		}
	}

	public System_config findById(String id) {
		log.debug("getting System_config instance with id: " + id);
		try {
			System_config instance = (System_config) super.get("oa.model.table.System_config", id);
			return instance;
		} catch (RuntimeException re) {
			log.debug("get failed", re);
			throw re;
		}
	}

	public ResultList<System_config> findByExample(Integer pageNo, System_config instance) {
		log.debug("find System_config instances with example");
		try {
			return super.find(pageNo, "oa.model.table.System_config", instance);
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}


	public ResultList<System_config> findByProperty(Integer pageNo, String propertyName, String value) {
		log.debug("finding System_config instance with property: " + propertyName
				+ ", value: " + value);
		try {
			return super.find(pageNo, "oa.model.table.System_config", propertyName, value);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}

	public ResultList<System_config> findAll(Integer pageNo) {
		log.debug("finding all System_config instances");
		try {
			return super.find(pageNo, "oa.model.table.System_config");
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
}
