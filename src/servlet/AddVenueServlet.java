package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加场馆的Servlet
 * @author 高翔
 *
 */
public class AddVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决中文乱码问题
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		// 实例化网页输出流
		PrintWriter out = response.getWriter();
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		// 获取表格中的对应元素
		String name = request.getParameter("name");
		// ��ȡ�۸�
		String price = request.getParameter("price");
		// ��ȡ����
		String count = request.getParameter("count");
		// ��ȡ��λ
		String unit = request.getParameter("unit");
		// ��ȡ����
		String add = request.getParameter("add");
		// �����Ʒ��Ϣ
		out.print("���ƣ�" + name + "<br>");
		out.print("�۸�" + price + "<br>");
		out.print("������" + count + "<br>");
		out.print("��λ��" + unit + "<br>");
		out.print("���أ�" + add + "<br>");
		
		out.flush();
		out.close();
	}

}
