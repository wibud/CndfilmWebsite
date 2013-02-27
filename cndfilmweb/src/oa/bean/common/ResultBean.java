package oa.bean.common;

public class ResultBean {

	private int recode;		//状态号，0表示成功，小于0表示失败，可以自定义负数的含义
	private String errormsg;//失败时需要填写的错误信息

	//constructer
	public ResultBean(){
		this.recode = -999;
		this.errormsg = "";
	}

//	public ResultBean(int recode){
//		this.recode = recode;
//		this.errormsg = "";
//	}
//
//	public ResultBean(int recode, String errormsg){
//		this.recode = recode;
//		this.errormsg = errormsg;
//	}

	public ResultBean setValues(int recode, String errmsg){
		setRecode(recode);
		setErrormsg(errmsg);
		return this;
	}


	//getter and setter
	public int getRecode() {
		return recode;
	}

	public void setRecode(int recode) {
		this.recode = recode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}
