package oa.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import oa.exception.LocalException;

public class FileUtil {
	
	/**
	 * 上传文件
	 * @param destDirPath 目的路径
	 * @param files	上传的文件
	 * @param filesFileName 上传文件名
	 * @return
	 */
	public static String upload(String destDirPath, List<File> files, List<String> filesFileName){
		
		String errorInfo = "";
		//如果目录不存在，生成目录
		File destDir = new File(destDirPath);
		if(!destDir.exists()){
			if(!destDir.mkdirs()){
				
				errorInfo = "上传失败，原因是：文件路径无法生成";
				return errorInfo;
			}
		}
		
		String destFilePath="";
		if(files!=null){
			
			for(int i=0; i<filesFileName.size(); i++){
				destFilePath = destDirPath+filesFileName.get(i);
				InputStream in=null;
				OutputStream out=null;
				try {
					in = new BufferedInputStream(new FileInputStream(files.get(i)));
					out = new BufferedOutputStream(new FileOutputStream(destFilePath));
					byte[] buffer = new byte[1024];
					int length=0;
					while((length = in.read(buffer))!=-1){
						out.write(buffer,0,length);
					}
					
					if(in!=null){
						in.close();
					}
					if(out!=null){
						out.close();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					errorInfo = "上传失败，原因是：文件不存在";
				} catch (IOException e) {
					e.printStackTrace();
					errorInfo = "上传失败，原因是：发生IO错误";
				}finally{
				}
			}
		}
		
		return errorInfo;
	}
	
	/**
	 * 获取路径下所有非文件夹的文件的绝对路径
	 * @param filePath 路径
	 * @return
	 */
	public static ResultList<String> getFileAbsolutePath(String filePath){
		
		File path = new File(filePath);
		//---如果文件不存在就创建
		if(!path.exists()){
			
			path.mkdirs();
		}
		File[] list = path.listFiles();
		ResultList<String> pathList = new ResultList<String>();
		int i = 0;
		
		for(File f: list){
			if(!f.isDirectory()){
				
				pathList.add(f.getName());
				i++;
			}
		}
		
		pathList.setCount(Integer.toString(i));
		return pathList;
	}
	
    /** 
     *  根据路径删除指定的目录或文件，无论存在与否 
     *@param sPath  要删除的目录或文件 
     *@return 删除成功返回 true，否则返回 false。 
     */  
    public static boolean DeleteFolder(String sPath) {  
        boolean flag = false;  
        File file = new File(sPath);  
        // 判断目录或文件是否存在  
        if (!file.exists()) {  // 不存在返回 false  
            return flag;  
        } else {  
            // 判断是否为文件  
            if (file.isFile()) {  // 为文件时调用删除文件方法  
                return deleteFile(sPath);  
            } else {  // 为目录时调用删除目录方法  
                return deleteDirectory(sPath);  
            }  
        }  
    }  
    
    /** 
     * 删除单个文件 
     * @param   sPath    被删除文件的文件名 
     * @return 单个文件删除成功返回true，否则返回false 
     */  
    public static boolean deleteFile(String sPath) {  
    	boolean flag = false;  
    	File file = new File(sPath);  
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) {  
            file.delete();  
            flag = true;  
        }  
        return flag;  
    }  
    
    /** 
     * 删除目录（文件夹）以及目录下的文件 
     * @param   sPath 被删除目录的文件路径 
     * @return  目录删除成功返回true，否则返回false 
     */  
    public static boolean deleteDirectory(String sPath) {  
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
        if (!sPath.endsWith(File.separator)) {  
            sPath = sPath + File.separator;  
        }  
        File dirFile = new File(sPath);  
        //如果dir对应的文件不存在，或者不是一个目录，则退出  
        if (!dirFile.exists() || !dirFile.isDirectory()) {  
            return false;  
        }  
        boolean flag = true;  
        //删除文件夹下的所有文件(包括子目录)  
        File[] files = dirFile.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            //删除子文件  
            if (files[i].isFile()) {  
                flag = deleteFile(files[i].getAbsolutePath());  
                if (!flag) break;  
            } //删除子目录  
            else {  
                flag = deleteDirectory(files[i].getAbsolutePath());  
                if (!flag) break;  
            }  
        }  
        if (!flag) return false;  
        //删除当前目录  
        if (dirFile.delete()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
}
