package com.wgh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wgh.model.SeatPo;
import com.wgh.model.Strategy;
import com.wgh.model.Venue;
import com.wgh.tools.InfoGetter;

public class SeatDao {
	private InfoGetter conn = null;// 创建数据库连接对象

	public SeatDao() {
		conn = InfoGetter.getInstance();// 实例化数据库连接对象
	}

	/**
	 * 查询所有座位信息/查询某特定座位
	 * 
	 * @param sql 需要执行的获取表中全部数据的sql语句
	 * @return
	 */
	//该查询语言要同时链接两个表偶
	public List<SeatPo> querySeat(String sql) {
		ResultSet rs = conn.executeQuery(sql);// 执行查询语句
		List<SeatPo> list = new ArrayList<SeatPo>();
		try {// 捕获异常
			while (rs.next()) {
				
				/**
				 private String SeatID;
					private int seatGrade;
				private String strategyID;
				private String status;
				private String orderID;
				 */
				SeatPo venue = new SeatPo();
				venue.setSeatID(rs.getString("seatID"));
				venue.setSeatGrade(rs.getInt("seatLeave"));
				venue.setStrategyID(rs.getString("strategyID"));
				venue.setStatus(rs.getString("status"));
				venue.setOrderID(rs.getString("orderID"));
				//venue.setVaule_ratio(rs.getDouble(7));
				list.add(venue);// 将日记信息保存到list集合中

			}
		} catch (SQLException e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			//conn.close();// 关闭数据库连接
		}
		return list;
	}

	/**
	 * 功能：保存座位信息到数据库（分配座位喽）
	 * 
	 * @param diary
	 * @return
	 */
	public int saveSeat(String strategyID,String seatID,String orderID,int seatLeave,String status) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		int ret = 0;
		try {
			ps = infoGetter.connection.prepareStatement("insert into seattable(seatID,seatLeave,strategyID,status,orderID) values (?,?,?,?,?)");
			ps.setString(1, seatID);
	        ps.setInt(2, seatLeave);;
	        ps.setString(3,strategyID);
	        ps.setString(4, status);
	        ps.setString(5,orderID);
	        
	        ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return ret;
	}
	
	/**
	 * 更改座位的状态
	 * 
	 * @param ostatus 可选状态：入座、未入座 
	 * @return
	 */
	public int changeStatus(String strategyID,String seatID,String status) {
		String sql = "update seattable set status =" +"'"+ status+"'"+"where strategyID="+strategyID+" and seatID ="+"'"+seatID+"'";
		
		int ret = 0;
		try {
			ret = conn.executeUpdate(sql);// 执行更新语句
		} catch (Exception e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			//conn.close();// 关闭数据连接
		}
		return ret;
	}

}
