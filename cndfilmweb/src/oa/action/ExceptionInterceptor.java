package oa.action;

import oa.bean.common.ResultBean;
import oa.exception.UapBaseException;
import oa.util.ExceptionUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class ExceptionInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String ret = "ERROR";
		BaseAction action = (BaseAction)invocation.getAction();
		action.setResult(new ResultBean());
		try {
			ret = invocation.invoke();
		} catch (UapBaseException e) {
			action.setResult(action.getResult().setValues(-1, e.getMessage()));
			throw e;
		} catch (NullPointerException e) {
			action.setResult(action.getResult().setValues(-1, "发生空指针异常"));
			ExceptionUtil.throwException(new UapBaseException("发生空指针异常: " + e.getMessage(), e));
		} catch (RuntimeException e) {
			//这里是针对没有捕获的运行时异常
			action.setResult(action.getResult().setValues(-1, "发生未知错误"));
			ExceptionUtil.throwException(new UapBaseException("发生未知错误: " + e.getMessage(), e));
		}

		return ret;
	}

}
