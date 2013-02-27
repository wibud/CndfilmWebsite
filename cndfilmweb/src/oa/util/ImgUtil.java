package oa.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;

public class ImgUtil {

	/**
	 * 生成图像(不强制按目标宽高生成图片)
	 * 
	 * @param fileSrc
	 *            源文件
	 * @param pathDest
	 *            生成图片的路径
	 * @param widthDest
	 *            目标图片宽(如果为-1，表示可以任意宽度)
	 * @param heightDest
	 *            目标图片高(如果为-1，表示可以任意高度)
	 * @return
	 */
	public static boolean createImage(File fileSrc, String pathDest,int widthDest, int heightDest) {
		return createImage(false, fileSrc, pathDest, widthDest, heightDest);

	}

	/**
	 * 生成图像
	 * 
	 * @param isForceWidthHeightToDest
	 *            是否按设定目标的宽高强制生成图片
	 * @param fileSrc
	 *            源文件
	 * @param pathDest
	 *            生成图片的路径
	 * @param widthDest
	 *            目标图片宽(如果为-1，表示按原图比率设定宽度)
	 * @param heightDest
	 *            目标图片高(如果为-1，表示按原图比率设定高度)
	 * @return
	 */
	public static boolean createImage(boolean isForceWidthHeightToDest,
			File fileSrc, String pathDest, int widthDest, int heightDest) {
		
		boolean flag = false;
		File out = null;
		
		try {
			
			if (widthDest <= 0 && heightDest <= 0)// 如果目标宽高均<=0，则无法生成图片
				return false;
			else if (widthDest <= 0 || heightDest <= 0)
				isForceWidthHeightToDest = false;
			
			int w = 1;
			int h = 1;
			Image imgSrc = javax.imageio.ImageIO.read(fileSrc);// 源图片
			
			if (isForceWidthHeightToDest) {// 如果强制，则将图片宽高设定为目标宽高
				w = widthDest;
				h = heightDest;
				
			} else {
				int width = imgSrc.getWidth(null);
				int height = imgSrc.getHeight(null);
				double imgRatio = width * 1.0 / height;
				if (widthDest > 0 && heightDest > 0) {
					w = widthDest;
					h = (int) (widthDest / imgRatio);
					if (h > heightDest) {
						w = (int) (heightDest * imgRatio);
						h = heightDest;
					}
				} else if (widthDest <= 0) {// 宽无限制
					w = (int) (heightDest * imgRatio);
					h = heightDest;
				} else {// 高无限制
					w = widthDest;
					h = (int) (widthDest / imgRatio);
				}
			}
			
			BufferedImage tag = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(imgSrc, 0, 0, w, h, null);
			out = new File(pathDest);
			
			if(!out.exists()){
				out.createNewFile();
			}
			
			flag = writeImageFile(out, tag, 80);
			
		} catch (IOException ex) {
			flag = false;
			ex.printStackTrace();
		} finally {
			try {
				if (out != null)
					out = null;
			} catch (Exception e1) {

			}
		}
		return flag;
	}

	/**
	 * 将 BufferedImage 编码输出成硬盘上的图像文件
	 * 
	 * @param file
	 *            编码输出的目标图像文件，文件名的后缀确定编码格式。
	 * @param image
	 *            待编码的图像对象
	 * @param quality
	 *            编码压缩的百分比
	 * @return 返回编码输出成功与否
	 */
	private static boolean writeImageFile(File fileDest,
			BufferedImage imageSrc, int quality) {
		try {
			
			Iterator<ImageWriter> it = ImageIO.getImageWritersBySuffix("jpg");
			if (it.hasNext()) {
				
				FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(fileDest);
				ImageWriter iw = (ImageWriter) it.next();
				ImageWriteParam iwp = iw.getDefaultWriteParam();
				iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				iwp.setCompressionQuality(quality / 100.0f);
				iw.setOutput(fileImageOutputStream);
				iw.write(null,new javax.imageio.IIOImage(imageSrc, null, null), iwp);
				iw.dispose();
				fileImageOutputStream.flush();
				fileImageOutputStream.close();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		InputStream in=null;
		OutputStream out=null;
		try {
			in = new BufferedInputStream(new FileInputStream(new File("F:\\图片\\11.jpg")));
			out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\ldm\\Desktop\\test\\12.jpg"));
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
		} catch (IOException e) {
			e.printStackTrace();
		}
//		createImage(true,new File("C:\\Users\\ldm\\Desktop\\test\\12.jpg"), "C:\\Users\\ldm\\Desktop\\test\\12.jpg", 100, 50);
	}

}
