package com.wgh.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InfoGetter {
	
	//使用单列模式
	private SQLConnDB baseCreater;
	private static InfoGetter infoGetter;
	public PreparedStatement preparedStatement;
	public Statement statement;
	public Connection connection; 
	
	public static InfoGetter getInstance() {
		if(infoGetter==null) {
			infoGetter = new InfoGetter();
		}
		else {
			
		}
		return infoGetter;
	}
	//初始化方法
	public InfoGetter() {
		baseCreater = SQLConnDB.getInstance();
		connection = baseCreater.connection;
		preparedStatement = baseCreater.preparedStatement;
		try {
			statement= connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//读取目标表中的所有元素
	String classified = "select * from ";
	public ResultSet getAllTable(String tableName) {
			ResultSet resultSet = null;
			classified+=tableName;
			try {
				preparedStatement = connection.prepareStatement(classified);
				resultSet = preparedStatement.executeQuery();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("获取表中信息失败");
				e.printStackTrace();
			}
			return resultSet;
	}	
	//获取一行数据库信息
	String oneInfo = "select * from ";
	public ResultSet getOneLine(String tableName,String vaule,String geter) {
			ResultSet resultSet = null;
			oneInfo+=tableName+" where "+vaule+" = "+geter;
			try {
				preparedStatement = connection.prepareStatement(oneInfo);
				resultSet = preparedStatement.executeQuery();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("获取表中信息失败");
				e.printStackTrace();
			}
			return resultSet;
	}	

	//删除目标表中的数据
	public int deleteData(String tableName,String id,double id_vaule){  
	        String sql = "delete from "+tableName+" where "+id+" =?";  
	        PreparedStatement pstmt;
			int result = 0;
	        try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setDouble(1, id_vaule);  
		        result = pstmt.executeUpdate();  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        return result;
	         
	          
	    }  

	/**
	 * 下面是对数据 增删改查的操作，其中sql 表示待执行的sql语言
	 * @param sql
	 */
	/*
	 * 功能：执行查询语句
	 */
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try { // 捕捉异常
			 rs = statement.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
		}
		return rs; // 返回结果集对象
	}

	/*
	 * 功能:执行更新操作
	 */
	public int executeUpdate(String sql) {
		int result = 0; // 定义保存返回值的变量
		try { // 捕捉异常
			result = statement.executeUpdate(sql); // 执行更新操作
		} catch (SQLException ex) {
			result = 0; // 将保存返回值的变量赋值为0
		}
		return result; // 返回保存返回值的变量
	}

	public static void main(String[]args) {
		InfoGetter infoGetter = InfoGetter.getInstance();
	}
}
