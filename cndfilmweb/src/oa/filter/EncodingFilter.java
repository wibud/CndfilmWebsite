package oa.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import oa.util.OaConfig;

public class EncodingFilter implements Filter {

	protected String encoding = null;
	
	protected FilterConfig filterConfig = null;
	
	protected boolean ignore = true;
	
	public void destroy(){
		
		this.encoding = null;
		this.filterConfig = null;
	}
	
	//选择 设置使用的字符编码
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException,ServletException{
		
		if(ignore || (request.getCharacterEncoding() == null)){
			
			String encoding = selectEncoding(request);
			if(encoding != null){
				
				request.setCharacterEncoding(encoding);
//				response.setCharacterEncoding(encoding);
			}
		}
		
		//将控制权交给下一个Filter
		chain.doFilter(request, response);
	}
	
	//将这个Filter放在服务中
	public void init(FilterConfig filterConfig) throws ServletException{
		
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if(value == null){
			
			this.ignore = true;
		}else if(value.equalsIgnoreCase("true")){
			
			this.ignore = true;
		}else if(value.equalsIgnoreCase("yes")){
			
			this.ignore = true;
		}else{
			
			this.ignore = false;
		}
	}
	
	protected String selectEncoding(ServletRequest request){
		
		return (this.encoding);
	}
}
