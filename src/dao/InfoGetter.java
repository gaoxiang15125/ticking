package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wgh.tools.SQLConnDB;

public class InfoGetter {
	
	//使用单列模式
	private SQLConnDB baseCreater;
	private static InfoGetter infoGetter;
	public PreparedStatement preparedStatement;
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
	private InfoGetter() {
		baseCreater = SQLConnDB.getInstance();
		connection = baseCreater.connection;
		preparedStatement = baseCreater.preparedStatement;
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
	public void deleteData(String tableName,double id){  
	        String sql = "delete from "+tableName+" where id= ?";  
	        PreparedStatement pstmt;
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setDouble(1, id);  
		        int result = pstmt.executeUpdate();  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
	         
	          
	    }  

	public static void main(String[]args) {
		InfoGetter infoGetter = InfoGetter.getInstance();
	}
}
