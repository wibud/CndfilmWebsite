package oa.filter;

import java.util.Map;

import oa.bean.UserBean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	// 拦截Action处理的拦截方法
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		// 取出名为user的Session属性
		UserBean user = (UserBean) session.get("admin");
		// 如果没有登陆，或者登陆所用的用户名不是scott，都返回重新登陆
		if (user != null) {
			return invocation.invoke();
		}
		// 直接返回login的逻辑视图
		return Action.LOGIN;
	}

}
