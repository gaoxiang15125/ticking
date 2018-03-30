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

public class TimeDao {
	private InfoGetter conn = null;// 创建数据库连接对象

	public TimeDao() {
		conn = new InfoGetter();// 实例化数据库连接对象,并且不和其他服务器的链接供用偶
	}

	/**
	 * 查询所有订单，并把其中等待付款的订单改为超时订单
	 * @return 结果啦，反正无所谓啦
	 */
	public int changeNoPay() {
		int  num = conn.executeUpdate("update ordertable set orderStatus='已撤销' where orderStatus ='待支付'");// 执行查询语句
		return num;
	}

	/**
	 * 功能：给现场购票用户分票
	 * 
	 * @param 
	 * @return
	 */
	public int giveSeat() {
		String sql = "update seattable set seatID = seatBuff where seatID = -1";
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
