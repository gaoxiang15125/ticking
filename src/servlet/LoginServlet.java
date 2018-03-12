package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InfoGetter;
import po.UserPo;
import tools.DateUtil;

/**
* @author 作者 gaoxiang
* @version 创建时间：2018年3月12日 下午4:11:38
* 类说明
*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPo userPo;
	InfoGetter infoGetter;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userPo = new UserPo();
		// 设置response的编码
		response.setCharacterEncoding("utf-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		// 获取PrintWriter
		PrintWriter out = response.getWriter();
		// 设置request的编码
		request.setCharacterEncoding("utf-8");
		// 获取用户名
		String userID = request.getParameter("userID");
		// 获取密码
		String password = request.getParameter("password");
		//判断密码是否正确，并作出相应操作
		String sqlPassword = null;
		try {
			sqlPassword = getUserInfo(userID).getString("password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password.equals(sqlPassword)) {
			
		}
		else {
			
		}
		out.println("密码:" + password + "<br>");
		out.flush();
		out.close();
	}
	
	public ResultSet getUserInfo(String vaule) {
		infoGetter = InfoGetter.getInstance();
		return infoGetter.getOneLine("user", "userID", vaule);
	}
}