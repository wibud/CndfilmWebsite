package oa.dao.table;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oa.dao.BaseDao;
import oa.model.table.Film_type;
import oa.util.ResultList;

public class FilmTypeDao extends BaseDao{
	
	private static final Logger log = LoggerFactory.getLogger(FilmTypeDao.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(Film_type instance) {
		log.debug("saving Film_type instance");
		try {
			super.save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}
	
	public void saveFilmList(List<Film_type> instance) {
		log.debug("saving FilmList instance");
		try {
			super.saveList(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}

	public void delete(Film_type instance) {
		log.debug("deleting Film_type instance");
		try {
			super.delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.debug("delete failed", re);
			throw re;
		}
	}

	public void update(Film_type instance) {
		log.debug("update Film_type instance");
		try {
			super.update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.debug("update failed", re);
			throw re;
		}
	}


	public Film_type findById(String id) {
		log.debug("getting Film_type instance with id: " + id);
		try {
			Film_type instance = (Film_type) super.get("oa.model.table.Film_type", id);
			return instance;
		} catch (RuntimeException re) {
			log.debug("get failed", re);
			throw re;
		}
	}
	


	public ResultList<Film_type> findByExample(Integer pageNo, Film_type film_type) {
		log.debug("find Film_type instances with example");
		try {
			return super.find(pageNo, "oa.model.table.Film_type", film_type);
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}

	public ResultList<Film_type> findAll(Integer pageNo) {
		log.debug("finding all Film_type instances");
		try {
			return super.find(pageNo, "oa.model.table.Film_type");
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
	
	public ResultList<Film_type> findByCondition(Integer pageNo, String conditions){
		log.debug("finding Film_type instance with conditions: " + conditions);
		try {
			return super.find(pageNo, "oa.model.table.Film_type", conditions);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}

	public ResultList<Film_type> findByProperty(Integer pageNo, String propertyName, String value) {
		log.debug("finding Film_type instance with property: " + propertyName
				+ ", value: " + value);
		try {
			return super.find(pageNo, "oa.model.table.Film_type", propertyName, value);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByHQL(Integer pageNo, String hql){
		log.debug("finding Film_type instance with hql: " + hql
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
