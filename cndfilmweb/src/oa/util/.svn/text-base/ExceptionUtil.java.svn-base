package oa.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExceptionUtil {

	private ExceptionUtil(){}

	private static final Logger log = LoggerFactory.getLogger(ExceptionUtil.class);

	public static void handleException(RuntimeException re){

		//do something like logging in future
		if(re.getCause() == null){
			log.error(re.getMessage(), re);
		}else{
			log.error(re.getMessage(), re.getCause());
		}

	}

	public static void throwException(RuntimeException re){
		//do something like logging in future
		handleException(re);

		throw re;
	}

//	public static void main(String... args){
//		throwException(new RuntimeException("test msg"));
//	}
}
