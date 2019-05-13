package web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyLog;
import web.core.Action;
import web.core.ActionForm;
import web.core.ActionForward;
import web.form.ImageForm;

public class ImageAction extends Action{
	private static final int WIDTH = 140;
	private static final int HEIGHT = 30;
	private String[] str = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
			"S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
	private Random r = new Random();
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm af) {
		ServletOutputStream sos=null;
		PrintWriter pw=null;
		//�����������֤��
				StringBuffer sb = new StringBuffer();
				StringBuffer content = new StringBuffer();
				ImageForm im=(ImageForm)af;
				String data=im.getData();
				MyLog.log.debug("data=="+data);
				for (int i = 0; i < 6; i++) {
					String s = str[r.nextInt(str.length)];
					sb.append(s+" ");
					content.append(s);
				}
				try {
					sos = response.getOutputStream();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				//�ڴ��е�һ��ͼƬ
				BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
				//�������ͼƬ�Ļ���
				Graphics g = bi.getGraphics();
				//��ɫ�����
				g.setColor(Color.BLACK);
				g.drawRect(0, 0, WIDTH, HEIGHT);
				//������
				g.setColor(Color.YELLOW);
				g.fillRect(0, 0, WIDTH, HEIGHT);
				//д����
				g.setColor(Color.BLUE);
				g.setFont(new Font("����",Font.BOLD,20));
				g.drawString(sb.toString(), 10, 22);
				
				//��������
				g.drawLine(10, 10, 130, 10);
				g.drawLine(10, 15, 130, 20);
				g.drawLine(10, 30, 130, 0);
				
				//�����ŵ�
				for (int i = 0; i < 600; i++) {
					int x = r.nextInt(WIDTH)+1;
					int y = r.nextInt(HEIGHT)+1;
					g.drawLine(x, y, x, y);
				}
				g.dispose();
				try {
					ImageIO.write(bi, "jpg", sos);
					//�����ɵ���֤�����session�У�Ϊ�˺���ͻ��ύʱ���бȶ���֤
					request.getSession().setAttribute("code", content.toString());
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
				
		return null;
	}

}
