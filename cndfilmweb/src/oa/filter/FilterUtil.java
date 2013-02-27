package oa.filter;

public final class FilterUtil {

	private FilterUtil(){}
	
	public static boolean isAction(String uri){
		int pointIndex = uri.indexOf(".");
		boolean result = (!uri.equals("") && pointIndex < 0) || (pointIndex > 0 && pointIndex == uri.lastIndexOf(".") && uri.substring(pointIndex).equals(".action"));
		
		return result;
	}
}
