package oa.util;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class ResultList<T> extends ArrayList<T> {

	private String count;		//查询结果的结果总数
	private String retcode;		//该事务的返回值，标识正确和错误
	private String errmsg;		//错误信息

	public ResultList(){
		super();
		count = "0";
	}

	public ResultList(int initialCapacity){
		super(initialCapacity);
		count = "0";
	}

	public ResultList(Collection<T> values) {
		super(values);
		count = "0";
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	

}
