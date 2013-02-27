package oa.dao.table;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oa.dao.BaseDao;
import oa.model.table.Film_info;
import oa.util.ResultList;

public class FilmDao extends BaseDao{
	
	private static final Logger log = LoggerFactory.getLogger(FilmDao.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(Film_info instance) {
		log.debug("saving Film_info instance");
		try {
			super.save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}
	
	public void saveFilmList(List<Film_info> instance) {
		log.debug("saving FilmList instance");
		try {
			super.saveList(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.debug("save failed", re);
			throw re;
		}
	}

	public void delete(Film_info instance) {
		log.debug("deleting Film_info instance");
		try {
			super.delete(instance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.debug("delete failed", re);
			throw re;
		}
	}

	public void update(Film_info instance) {
		log.debug("update Film_info instance");
		try {
			super.update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.debug("update failed", re);
			throw re;
		}
	}


	public Film_info findById(String id) {
		log.debug("getting Film_info instance with id: " + id);
		try {
			Film_info instance = (Film_info) super.get("oa.model.table.Film_info", id);
			return instance;
		} catch (RuntimeException re) {
			log.debug("get failed", re);
			throw re;
		}
	}
	


	public ResultList<Film_info> findByExample(Integer pageNo, Film_info film_info) {
		log.debug("find Film_info instances with example");
		try {
			return super.find(pageNo, "oa.model.table.Film_info", film_info);
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}

	public ResultList<Film_info> findAll(Integer pageNo) {
		log.debug("finding all Film_info instances");
		try {
			return super.find(pageNo, "oa.model.table.Film_info");
		} catch (RuntimeException re) {
			log.debug("find all failed", re);
			throw re;
		}
	}
	
	public ResultList<Film_info> findByCondition(Integer pageNo, String conditions){
		log.debug("finding Film_info instance with conditions: " + conditions);
		try {
			return super.find(pageNo, "oa.model.table.Film_info", conditions);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}

	public ResultList<Film_info> findByProperty(Integer pageNo, String propertyName, String value) {
		log.debug("finding Film_info instance with property: " + propertyName
				+ ", value: " + value);
		try {
			return super.find(pageNo, "oa.model.table.Film_info", propertyName, value);
		} catch (RuntimeException re) {
			log.debug("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByHQL(Integer pageNo, String hql){
		log.debug("finding Film_info instance with hql: " + hql
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
