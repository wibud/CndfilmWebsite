package oa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import oa.dao.table.FilmTypeDao;
import oa.model.table.Film_type;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;



//所有的工具都可以放到这里，只能写静态方法
//也可以新建新的xxxUtil类，用来将Util分类，但必须参考这种模式
public final class CommonUtil {

	private static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private CommonUtil() {}//使其他类不能实例化此类


	public static String getMD5(String string){
		return DigestUtils.md5Hex(string).toUpperCase();
	}


	//返回当前时间 date型yyyy-MM-dd HH:mm:ss
	public static String getCurrentTime(){

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = format.format(cal.getTime());

		return now;
	}
	
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(cal.getTime());

		return now;
	}

	public static String getPrettyXML(Document doc) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();

		StringWriter out = new StringWriter();
		XMLWriter xmlWriter = new XMLWriter(out, format);

		xmlWriter.write(doc);
		xmlWriter.close();

		return out.toString();
	}

	public static String getPrettyXML(String doc) throws IOException, DocumentException{
		Document docuemnt = DocumentHelper.parseText(doc);
		docuemnt.setXMLEncoding("utf-8");

		OutputFormat format = OutputFormat.createPrettyPrint();

		StringWriter out = new StringWriter();
		XMLWriter xmlWriter = new XMLWriter(out, format);

		xmlWriter.write(docuemnt);
		xmlWriter.close();

		return out.toString();
	}

	/**
	 * 生成一串随机字符串
	 * 参数表示字符串长度
	 * @return 随机字符串
	 */
	public static String getRandomString(int stringLength){
		int length = chars.length();
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int j=0; j<stringLength; j++){
			sb.append(chars.charAt(random.nextInt(length)));
		}

		return sb.toString();
	}
	
	
//	public static String getLocalIP() throws SocketException, UnknownHostException{
//		String ip = null;
//		
//		//linux
//		if(File.separator.equals("/")){
//			Enumeration<?> e1 = (Enumeration<?>)NetworkInterface.getNetworkInterfaces();
//			
//			while(e1.hasMoreElements()){
//				NetworkInterface ni = (NetworkInterface)e1.nextElement();
//				if(!ni.getName().equals("eth0")){
//					continue;
//				}else{
//					Enumeration<?> e2 = ni.getInetAddresses();
//					while(e1.hasMoreElements()){
//						InetAddress ia = (InetAddress)e2.nextElement();
//						if(ia instanceof Inet6Address){
//							continue;
//						}
//						ip = ia.getHostAddress();
//						break;
//					}
//					break;
//				}
//			}
//		}
//		//windows
//		else{
//			InetAddress inet = InetAddress.getLocalHost();
//			ip = inet.getHostAddress();
//		}
//		
//		
//		return ip;
//	}
	
	public static String getRandomID(){
		return UUID.randomUUID().toString().toUpperCase();
	}
	
	public static String getPageCount(String count){
		Integer pageSize = SystemConfig.getPageSize();
		Integer intCount = Integer.parseInt(count);
		
		Integer pageCount = intCount / pageSize;
		if(intCount % pageSize != 0){
			pageCount += 1;
		}
		
		return String.valueOf(pageCount);
	}
	
	public static String getStartWith(Integer pageNo){
		return pageNo == null ? "0" : String.valueOf((pageNo-1)*SystemConfig.getPageSize());
	}
	
	public static Date getDateWithDelayFromNow(int field, int amount){
		Calendar cal = Calendar.getInstance();
		cal.add(field, amount);
		return cal.getTime();
	}
	
	public static int exeCommand(String command) throws IOException, InterruptedException {
		String buffer;
		String log = "";
		String error = "";
		System.out.println("executing command:" + command);
		
		Process process = new ProcessBuilder(command.split(" ")).start();
		int ret = process.waitFor();
		if(ret == 0){
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((buffer = results.readLine()) != null) {
				log += buffer + "\n";
			}
			System.out.println("executing result:\n" + log);
		}else{
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while ((buffer = errors.readLine()) != null) {
				error += buffer + "\n";
			}
			System.out.println("executing error:\n" + error);
		}
		
		return ret;
	}
	
	public static void main(String... args){
		SystemConfig.setPageSize(20);
		System.out.println(getPageCount("100"));
	}
	
	/*
	 * 若传入的字符串为null, 则返回空字符串,否则返回原字符串
	 */
	public static String noNullString(String src) {
		if (src == null) {
			return "";
		} 
		return src;
	}
	
	public static String decode(String src) {
		try {
			return new String(src.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return src;
	}
	
	/*
	 * 递归删除目录
	 */
	public static boolean deleteFile(String delPath)
			throws FileNotFoundException, IOException {
		try {
			File file = new File(delPath);
			if (!file.isDirectory()) {
				file.delete();
			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delPath + "/" + filelist[i]);
					if (!delfile.isDirectory())
						delfile.delete();
					else if (delfile.isDirectory())
						deleteFile(delPath + "/" + filelist[i]);
				}
				file.delete();
			}
		} catch (FileNotFoundException e) {
		}
		return true;
	}
	
	/*
	 * 获取文件大小的字符串
	 */
	public static String getFileSizeString(File file){
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		String byteUnit = null;
		if (file.length() < 1024) {
			// 上传文件小于1K
			byteUnit = file.length() + "BYTE";
		} else if (file.length() >= 1024 && file.length() < 1048576) {
			// 上传文件大于等于1K小于1M
			byteUnit = df.format(file.length() / 1024.0) + "KB";
		} else if (file.length() >= 1048576) {
			// 上传文件大于1M小于1GB
			byteUnit = df.format(file.length() / 1024.0 / 1024.0) + "MB";
		} else {
			byteUnit = df.format(file.length() / 1024.0 / 1024.0 / 1024.0)
					+ "GB";
		}
		return byteUnit;
	}
	
	/*
	 * 判断字符串是否为空或null
	 */
	public static boolean isNullOrNoValue(String rev){
		
		if(rev!=null && !rev.equals("")){
			
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 将date转换成string
	 */
	public static String DTtoString(java.util.Date dtToString){
		
		if(dtToString==null){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = df.format(dtToString);
		
		return dateTime;
	}
	
	public static String DTtoStringNohour(java.util.Date dtToString){
		
		if(dtToString==null){
			return "";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime = df.format(dtToString);
		
		return dateTime;
	}
	
	/**
	 * 将String转成Clob ,静态方法
	 * 
	 * @param str
	 *            字段
	 * @return clob对象，如果出现错误，返回 null
	 */
	public static Clob stringToClob(String str) {
		if (null == str)
			return null;
		else {
			try {
				java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(str
						.toCharArray());
				return c;
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 将Clob转成String ,静态方法
	 * 
	 * @param clob
	 *            字段
	 * @return 内容字串，如果出现错误，返回 null
	 * @throws SQLException 
	 */
	public static String clobToString(Clob clob) throws SQLException {
		
		 return (clob != null ? clob.getSubString(1, (int) clob.length()) : null); 
	}

}
