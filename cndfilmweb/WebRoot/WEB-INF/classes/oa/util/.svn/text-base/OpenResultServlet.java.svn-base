package oa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filepath = request.getParameter("filepath");
		try {
			filepath = new String(filepath.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (filepath == null || filepath.equals("")) {
			try {
				response.sendRedirect("noExist.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		if (filepath != null && filepath.equals("") == false) {
			String file_absloute_path = filepath;
			System.out.println("路径是：" + file_absloute_path);

			File file = new File(file_absloute_path);
			String userSaveFileName = file.getName();

			if (file.exists() == false) {
				System.out.println("文件不存在");
				try {
					response.sendRedirect("noExist.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			try {
				FileInputStream hFile = new FileInputStream(file_absloute_path); // 以byte流的方式打开文件
																					// d:\1.gif
				int i = hFile.available(); // 得到文件大小
				byte data[] = new byte[i];
				hFile.read(data); // 读数据
				hFile.close();
				response.setContentType("application/octet-stream");
				response.setHeader("Content-disposition",
						"attachment; filename="
								+ toUtf8String(userSaveFileName));
				response.setHeader("Expires", "0");
				response.setHeader("Pragma", "public");
				response.setHeader("Cache-Control",
						"must-revalidate, post-check=0, pre-check=0");
				response.setHeader("Cache-Control", "public");
				// response.setContentType("image/jpg"); //设置返回的文件类型
				OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
				toClient.write(data); // 输出数据
				toClient.close();
			} catch (IOException e) // 错误处理
			{
				PrintWriter toClient = response.getWriter(); // 得到向客户端输出文本的对象
				response.setContentType("text/html;charset=gb2312");
				toClient.write("无法打开图片!");
				toClient.close();
			}

		}
	}

	private String toUtf8String(String s) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

}
