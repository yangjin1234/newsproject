package web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;
import util.MyLog;
import web.form.ImageForm;

public class ImageActionServlet extends HttpServlet {

	private static final int WIDTH = 180;
	private static final int HEIGHT = 35;
	private String[] str = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
			"S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
	private Random r = new Random();
	/**
	 * Constructor of the object.
	 */
	public ImageActionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {this.doPost(request, response);}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream sos=response.getOutputStream();
				try {
					ValidateCode vdc=new ValidateCode(120, 30, 4, 1);
					MyLog.log.debug("生成vdc");
					vdc.write(sos);
					MyLog.log.debug("写入vdc");
//					ImageIO.write(bi, "jpg", sos);
					//将生成的验证码存入session中，为了后面客户提交时进行比对验证
					request.getSession().setAttribute("code", vdc.getCode());
//					request.getSession().setAttribute("code", content.toString());
					String s=(String) request.getSession().getAttribute("code");
					MyLog.log.debug("s="+s);
					sos.flush();
					
//					pw=response.getWriter();
//					pw.write(content.toString());
//					MyLog.log.debug("content=="+content.toString());
//					pw.flush();
//					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
