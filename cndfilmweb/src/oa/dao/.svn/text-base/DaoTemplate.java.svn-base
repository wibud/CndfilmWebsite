package oa.dao;

import java.io.Serializable;
import java.util.List;

import oa.util.ResultList;

@SuppressWarnings("rawtypes")
public interface DaoTemplate {
	
	void save(Object obj);
	
	void saveList(List<Object> objList);
	
	void delete(Object obj);
	
	void update(Object obj);
	
	Object get(String clsname, Serializable id);
	
	ResultList find(Integer page, String clsname);
	
	ResultList find(Integer page, String clsname, Object condition);
	
	ResultList find(Integer page, String clsname, String propertyName, String value);
	
	ResultList find(Integer page, String clsname, String propertyName1, String propertyName2, String value);
	
	ResultList likefind(Integer page, String clsname, String propertyName1, String propertyName2, String value);
	
	List find(String clsname, String propertyName, String value);
	
	void deleteAll(List<Object> list);
}
