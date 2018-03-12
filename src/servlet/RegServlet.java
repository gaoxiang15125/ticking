package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wgh.tools.InfoGetter;

import po.UserPo;
import tools.DateUtil;
/**
 * 用户注册Servlet
 * @author Li YongQiang
 *
 */
public class RegServlet extends HttpServlet {
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
		userPo.setUserName(request.getParameter("userName"));
		// 获取密码
		String password = request.getParameter("password");
		// 获取邮箱
		userPo.setEmail(request.getParameter("email"));
		// 获取会员许可
		if(request.getParameter("vip").equals("0")) {
			userPo.setVip(0);
		}
		else {
			userPo.setVip(1);
		}
		
		// 初始化会员积分
		userPo.setVip_vaule(0.0);
		//获取性别
		userPo.setSex(request.getParameter("sex"));
		//获取电话号码
		userPo.setTelphone(request.getParameter("telphone"));
		//获取用户工作
		userPo.setJob("购票用户");
		//获取生日
		userPo.setBirthday(DateUtil.changeToDate(request.getParameter("birthday")));
		//获取注册时间
		userPo.setVipTime(DateUtil.getTimeNow());
		
		/**
		 * 写入注册信息到数据库
		 */
		setUserPo(password);
		out.println("密码:" + password + "<br>");
		
		out.flush();
		out.close();
	}
	
	public void setUserPo(String password) {
		infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		try {
			ps = infoGetter.connection.prepareStatement("insert into user(userName,email,vip,vipVaule,sex,telphone,job,birthday,vipTime,password) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, userPo.getUserName());
	        ps.setString(2, userPo.getEmail());
	        ps.setInt(3,userPo.getVip());
	        ps.setDouble(4, 0.0);
	        ps.setString(5,userPo.getSex());
	        ps.setString(6,userPo.getTelphone());
	        ps.setString(7,userPo.getJob());
	        java.sql.Date sqlDate = new java.sql.Date(userPo.getBirthday().getTime());
	        ps.setDate(8,sqlDate );
	        Timestamp t = new Timestamp(userPo.getVipTime().getTime());
	        ps.setTimestamp(9,t);
	        ps.setString(10,password);
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
}
