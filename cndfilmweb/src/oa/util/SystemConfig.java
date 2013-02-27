package oa.util;

public final class SystemConfig {

	private static Integer pageSize;			//每页显示的页数
	
	private static String uploadPathWindows;	//windows上传路径
	
	private static String uploadPathLinux;		//linux上传路径
	
	private static Integer checkInterval;		//检查用户是否更改密码的时间间隔
	
	private SystemConfig() {
		//do nothing
	}
	
	public static Integer getPageSize() {
		return pageSize;
	}

	public static void setPageSize(Integer pageSize) {
		SystemConfig.pageSize = pageSize;
	}

	public static String getUploadPathWindows() {
		return uploadPathWindows;
	}

	public static void setUploadPathWindows(String uploadPathWindows) {
		SystemConfig.uploadPathWindows = uploadPathWindows;
	}

	public static String getUploadPathLinux() {
		return uploadPathLinux;
	}

	public static void setUploadPathLinux(String uploadPathLinux) {
		SystemConfig.uploadPathLinux = uploadPathLinux;
	}

	public static Integer getCheckInterval() {
		return checkInterval;
	}

	public static void setCheckInterval(Integer checkInterval) {
		SystemConfig.checkInterval = checkInterval;
	}
	
}
