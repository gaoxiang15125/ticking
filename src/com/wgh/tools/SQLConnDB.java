package com.wgh.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;


public class SQLConnDB {
	public static final String packageUrl ="org.gjt.mm.mysql.Driver";
	public static final String interfaceUrl ="jdbc:mysql://localhost:3306/ticking?characterEncoding=utf8&useSSL=true";
	public static final String name ="root";
	public static final String password ="18805156570";
	public PreparedStatement preparedStatement;
	public Connection connection;
	public static DecimalFormat  df = new DecimalFormat("#0.00");
	//实例化对象
	private static SQLConnDB baseCreater;
	//实例化方法
	public static SQLConnDB getInstance(){
		if(baseCreater==null){
			baseCreater= new SQLConnDB();
			return baseCreater;
		}
		else{
			return baseCreater;
		}
	}
	
	private SQLConnDB() {
		// TODO Auto-generated constructor stub
		initTools();
		//creatTable();
	}
	//创建数据库连接
	private void initTools(){
		// TODO Auto-generated method stub
		try {
			Class.forName(packageUrl);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(interfaceUrl, name, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//创建数据库
	private void creatTable() {
		String table = "CREATE TABLE IF NOT EXISTS user(\r\n" + 
				"userID DOUBLE NOT NULL PRIMARY KEY,\r\n" + 
				"userName VARCHAR(10) NOT NULL,\r\n" + 
				"email VARCHAR(20) NOT NULL,\r\n" + 
				"vip INTEGER NOT NULL,\r\n" + 
				"vipVaule DOUBLE NOT NULL,\r\n" + 
				"sex VARCHAR(2),\r\n" + 
				"telphone VARCHAR(20),\r\n" + 
				"job VARCHAR(20),\r\n" + 
				"birthday DATE,\r\n" + 
				"vipTime DATETIME\r\n" + 
				");";
		creatSingleTable(table, "创建用户表失败");
		
		table = "CREATE TABLE IF NOT EXISTS orderTable(\r\n" + 
				"orderID DOUBLE NOT NULL PRIMARY KEY,\r\n" + 
				"userID DOUBLE NOT NULL,\r\n" + 
				"money DOUBLE NOT NULL,\r\n" + 
				"orderTime DATETIME,\r\n" + 
				"orderType VARCHAR(10),\r\n" + 
				"orderStatus VARCHAR(10)\r\n" + 
				");";
		creatSingleTable(table, "创建订单表失败");
		
		table = "CREATE TABLE IF NOT EXISTS seatTable(\r\n" + 
				"seatID DOUBLE UNIQUE NOT NULL ,\r\n" + 
				"seatLeave INTEGER,\r\n" + 
				"status INTEGER NOT NULL,\r\n" + 
				"PRIMARY KEY(seatID,strategyID)\r\n" + 
				");";
		creatSingleTable(table, "创建座位表失败");
		
		table = "CREATE TABLE IF NOT EXISTS venueTable(\r\n" + 
				"venueID DOUBLE UNIQUE NOT NULL ,\r\n" + 
				"passID VARCHAR(20) NOT NULL,\r\n" + 
				"venueName VARCHAR(20),\r\n" + 
				"venueSeatNum INTEGER,\r\n" + 
				"availSeat INTEGER,\r\n" + 
				"venueIntroduce TEXT,\r\n" + 
				"cheaper DOUBLE,\r\n" + 
				"PRIMARY KEY(venueID)\r\n" + 
				");";
		creatSingleTable(table, "创建场馆表失败");
		
		table = "CREATE TABLE IF NOT EXISTS strategyTable(\r\n" + 
				"venueID DOUBLE NOT NULL ,\r\n" + 
				"beginTime DATETIME,\r\n" + 
				"endTime DATETIME,\r\n" + 
				"superHigh DOUBLE,\r\n" + 
				"High DOUBLE,\r\n" + 
				"middle DOUBLE,\r\n" + 
				"usually DOUBLE,\r\n" + 
				"low DOUBLE,\r\n" + 
				"type VARCHAR(20),\r\n" + 
				"introduce TEXT,\r\n" + 
				"FULL DOUBLE,\r\n" + 
				"ful  double,\r\n" + 
				"give VARCHAR(50),\r\n" + 
				"cherper DOUBLE,\r\n" + 
				"strategyID DOUBLE NOT NULL ,\r\n" + 
				"PRIMARY KEY(strategy)\r\n" + 
				");";
		creatSingleTable(table, "创建计划表失败");
		
	}
	
	private void creatSingleTable(String table,String warning) {
		try {
			System.out.print(connection);
			preparedStatement = connection.prepareStatement(table);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(warning);
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args){
		SQLConnDB baseCreater = SQLConnDB.getInstance();
		System.out.print(baseCreater.connection);
	}
	
	/*
	 * 功能:关闭数据库的连接
	 */
	public void close() {
		try { // 捕捉异常
			if (connection != null) { // 当Connection对象的实例conn不为空时
				connection.close(); // 关闭Connection对象
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // 输出异常信息
		}
	}
}

