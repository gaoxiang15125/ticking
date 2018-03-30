package com.wgh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.wgh.model.User;
import com.wgh.tools.InfoGetter;

import po.UserPo;

public class UserDao {
	private InfoGetter infoGetter;
	private UserPo userPo;
	
	public UserDao() {
		infoGetter = InfoGetter.getInstance();
	}

	// 验证用户的方法，返回值为1表示登录成功，否则表示登录失败
	//如果是字符串必须加引号
	public int login(User user) {
		int flag = 0;
		String sql = "SELECT * FROM user where userName='"
				+ user.getUsername() + "'";
		ResultSet rs = infoGetter.executeQuery(sql);// 执行SQL语句
		userPo = setUserPoRight(rs);
		try {
			if (rs.next()) {
				String pwd = user.getPwd();// 获取密码
				if (pwd.equals(rs.getString("password"))) {
					flag = 1;
					rs.last(); // 定位到最后一条记录
					int rowSum = rs.getRow();// 获取记录总数
					rs.first();// 定位到第一条记录
					if (rowSum != 1) {
						flag = 0;
					}
				} else {
					flag = 0;
				}
			} else {
				flag = 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 输出异常信息
			flag = 0;
		} finally {
			//conn.close();// 关闭数据库连接
		}
		return flag;
	}

	/**
	 * 功能：检测用户名是否为空
	 * 
	 * @param sql
	 * @return
	 */
	public String checkUser(String sql) {
		ResultSet rs = infoGetter.executeQuery(sql); // 执行查询语句
		String result = "";
		try {
			if (rs.next()) {
				result = "很抱歉，[" + rs.getString("userName") + "]已经被注册！";
			} else {
				result = "1"; // 表示用户没有被注册
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 输出异常信息
		} finally {
//			conn.close(); // 关闭数据库连接
		}
		return result; // 返回判断结果
	}

	/**
	 * 功能：保存用户注册信息
	 * 
	 * @param sql
	 * @return
	 */
	public String save(String sql) {
		int rtn = infoGetter.executeUpdate(sql); // 执行更新语句
		String result = "";
		if (rtn > 0) {
			result = "用户注册成功！";
		} else {
			result = "用户注册失败！";
		}
		//conn.close(); // 关闭数据库的连接
		return result; // 返回执行结果
	}

	/**
	 * 找回密码第一步
	 * 
	 * @param username
	 * @return
	 */
	public String forgetPwd1(String username) {
		String sql = "SELECT question FROM tb_user WHERE username='" + username
				+ "'";
		ResultSet rs = infoGetter.executeQuery(sql);// 执行SQL语句
		String result = "";
		try {
			if (rs.next()) {
				result = rs.getString(1);// 获取第一列的数据
			} else {
				result = "您输入的用户名不存在！"; // 表示输入的用户名不存在
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 输出异常信息
			result = "您输入的用户名不存在！"; // 表示输入的用户名不存在
		} finally {
			//conn.close(); // 关闭数据库连接
		}
		return result;
	}

	/**
	 * 找回密码第二步
	 * 
	 * @param username
	 * @return
	 */
	public String forgetPwd2(String username, String question, String answer) {
		String sql = "SELECT pwd FROM tb_user WHERE username='" + username
				+ "' AND question='" + question + "' AND answer='" + answer
				+ "'";
		ResultSet rs = infoGetter.executeQuery(sql);// 执行SQL语句
		String result = "";
		try {
			if (rs.next()) {
				result = rs.getString(1);// 获取第一列的数据
			} else {
				result = "您输入的密码提示问题答案错误！"; // 表示输入的密码提示问题答案错误
			}
		} catch (SQLException e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			//conn.close(); // 关闭数据库连接
		}
		return result;
	}
	/**
	 * 实例化用户对象，使其可被使用
	 * @param resultSet
	 * @return
	 */
	public UserPo setUserPoRight(ResultSet resultSet) {
		UserPo userPo = new UserPo();
		try {
			userPo.setUserName(resultSet.getString(1));
			userPo.setEmail(resultSet.getString(2));
			userPo.setVip(resultSet.getInt(3));
			userPo.setVip_vaule(resultSet.getDouble(4));
			userPo.setSex(resultSet.getString(5));
			userPo.setTelphone(resultSet.getString(6));
			userPo.setJob(resultSet.getString(7));
			userPo.setBirthday(resultSet.getDate(8));
			userPo.setVipTime(resultSet.getDate(9));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("实例化userpo对象出错");
			e.printStackTrace();
		}
		return userPo;
	}
	/**
	 * 向用户中增加积分值 
	 * @param userName 用户姓名
	 * @param vaule 所增加的数据值
	 * @return 访问变量
	 */
	public int addVaule(String userName,double vaule) {
		String sql = "UPDATE user set vipVaule=vipVaule+"+vaule+" where userName ='"+userName+"'";
		return infoGetter.executeUpdate(sql);
	}
	/**
	 * 计算用户会员等级
	 */
	public int getVIP(double vip_vaule) {
		int vaule = 0;
		return (int)vip_vaule/100;
	}
	
	/**
	 * 存储用户信息到数据库
	 * @param userPo
	 * @param password
	 */
	public void setUserPo(UserPo userPo,String password) {
		InfoGetter infoGetter = InfoGetter.getInstance();
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
	
	/**
	 * 更新用户信息到数据库
	 * @param userPo 保存待更新的用户信息的实例化对象
	 * 
	 */
	public void refushUserPo(UserPo userPo,String userName) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		try {
			ps = infoGetter.connection.prepareStatement("update user set userName=?,email=?,vip=?,vipVaule=?,sex=?,telphone=?,job=?,birthday=?,vipTime=? where userName=?");
			ps.setString(1, userPo.getUserName());
	        ps.setString(2, userPo.getEmail());
	        ps.setInt(3,userPo.getVip());
	        ps.setDouble(4, userPo.getVip_vaule());
	        ps.setString(5,userPo.getSex());
	        ps.setString(6,userPo.getTelphone());
	        ps.setString(7,userPo.getJob());
	        java.sql.Date sqlDate = new java.sql.Date(userPo.getBirthday().getTime());
	        ps.setDate(8,sqlDate );
	        Timestamp t = new Timestamp(userPo.getVipTime().getTime());
	        ps.setTimestamp(9,t);
	        ps.setString(10,userName);
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 取消会员
	 * @param email 目标用户邮箱
	 */
	public void killVIP(String email) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		try {
			ps = infoGetter.connection.prepareStatement("update user set vip= -1 where email=?");
			ps.setString(1, email);
	        
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	} 
}
