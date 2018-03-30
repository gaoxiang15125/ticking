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
import java.util.Vector;

import com.wgh.model.OrderVo;
import com.wgh.model.SeatPo;
import com.wgh.model.Strategy;
import com.wgh.model.Venue;
import com.wgh.tools.InfoGetter;

import po.OrderStatus;

public class OrderDao {
	private InfoGetter conn = null;// 创建数据库连接对象

	public OrderDao() {
		conn = InfoGetter.getInstance();// 实例化数据库连接对象
	}

	/**
	 * 查询所有订单/查询特定订单
	 * 
	 * @param sql 需要执行的获取表中全部数据的sql语句
	 * @return
	 */
	//该查询语言要同时链接两个表偶
	public List<OrderVo> queryOrder(String sql) {
		ResultSet rs = conn.executeQuery(sql);// 执行查询语句
		List<OrderVo> list = new ArrayList<OrderVo>();
		try {// 捕获异常
			while (rs.next()) {
				
				/**
				 * 按照顺序依次是 private String orderID;
					private double money_coust;
					private Date order_time;
					private String  purchase_path;
					private Vector<SeatPo> seatPos;
					private OrderStatus orderStatus;
				 */
				OrderVo venue = new OrderVo();
				venue.setMoney_coust(rs.getDouble("money"));;
				venue.setOrder_time(rs.getDate("orderTime"));
				venue.setOrderID(rs.getString("orderID"));
				venue.setPurchase_path(rs.getString("orderType"));
				venue.setOrderStatus(rs.getString("orderStatus"));
				list.add(venue);// 将订单信息保存到list集合中

			}
		} catch (SQLException e) {
			e.printStackTrace();// 输出异常信息
		} finally {
			//conn.close();// 关闭数据库连接
		}
		return list;
	}

	/**
	 * 功能：保存订单信息到数据库
	 * 
	 * @param diary
	 * @return
	 */
	public int saveOrder(OrderVo orderVo,String email) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		int ret = 0;
		try {
			ps = infoGetter.connection.prepareStatement("insert into ordertable(orderID,userID,money,orderTime,orderType,orderStatue) values (?,?,?,?,?,?)");
			ps.setString(1, orderVo.getOrderID());
	        ps.setString(2, email);;
	        ps.setDouble(3,orderVo.getMoney_coust());
	        ps.setDate(4, orderVo.getOrder_time());
	        ps.setString(5,orderVo.getPurchase_path());
	        ps.setString(6,orderVo.getOrderStatus());
	        ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return ret;
	}
	
	
	/**
	 * 更改订单状态
	 * 
	 * @param id
	 * @return
	 */
	public int changeStatus(String orderID,String status) {
		String sql = "update ordertable set status =" +"'"+ status+"'"+"where orderID="+orderID;
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
