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

import com.wgh.model.Strategy;
import com.wgh.model.Venue;
import com.wgh.tools.InfoGetter;

public class StrategyDao {
	private InfoGetter conn = null;// 创建数据库连接对象

	public StrategyDao() {
		conn = InfoGetter.getInstance();// 实例化数据库连接对象
	}

	/**
	 * 查询所有策略/查询特定策略
	 * 
	 * @param sql 需要执行的获取表中全部数据的sql语句
	 * @return
	 */
	//该查询语言要同时链接两个表偶
	public List<Strategy> queryDiary(String sql) {
		ResultSet rs = conn.executeQuery(sql);// 执行查询语句
		List<Strategy> list = new ArrayList<Strategy>();
		try {// 捕获异常
			while (rs.next()) {
				
				/**
				 * 按照顺序依次是 strategy_Description;time_begin;time_end;
				 *活动类别type;double[] seatPrice;full = new double[2];fullgiven;cheaper;superPrice = new double[2];
				 *venueName;venueID;strategyID;
				 */
				Strategy venue = new Strategy();
				venue.setStrategy_Description(rs.getString("introduce"));
				venue.setTime_begin(rs.getDate("beginTime"));
				venue.setTime_end(rs.getDate("endTime"));
				venue.setType(rs.getString("type"));
				double[] buff = new double[3];
				buff[0]=rs.getDouble("High");
				buff[1] = rs.getDouble("middle");
				buff[2] = rs.getDouble("usually");
				venue.setSeatPrice(buff);
				buff = new double[2];
				buff[0]= rs.getDouble("superHigh");
				buff[1] = rs.getDouble("low");
				venue.setSuperPrice(buff);
				buff[0] = rs.getDouble("FULL");
				buff[1] = rs.getDouble("ful");
				venue.setFull(buff);
				venue.setFullgiven(rs.getString("give"));
				venue.setCheaper(rs.getDouble("cheaper"));
				venue.setVenueName(rs.getString("venueName"));
				venue.setVenueID(rs.getString("venueID"));
				venue.setStrategyID(rs.getString("strategyID"));
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
	 * 功能：保存场馆信息到数据库
	 * 
	 * @param diary
	 * @return
	 */
	public int saveStrategy(Strategy strategy) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		int ret = 0;
		try {
			ps = infoGetter.connection.prepareStatement("insert into strategytable(venueID,beginTime,endTime,superHigh,High,middle,usually,low,type,introduce,FULL,ful,give,cheaper,strategyID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, strategy.getVenueID());
	        ps.setDate(2, strategy.getTime_begin());;
	        ps.setDate(3,strategy.getTime_end());
	        ps.setDouble(4, strategy.getSuperPrice()[0]);
	        ps.setDouble(5,strategy.getSeatPrice()[0]);
	        ps.setDouble(6,strategy.getSeatPrice()[1]);
	        ps.setDouble(7,strategy.getSeatPrice()[2]);
	        ps.setDouble(8,strategy.getSuperPrice()[1]);
	        ps.setString(9,strategy.getType());
	        ps.setString(10,strategy.getStrategy_Description());
	        ps.setDouble(11,strategy.getFull()[0]);
	        ps.setDouble(12,strategy.getFull()[1]);
	        ps.setString(13,strategy.getFullgiven());
	        ps.setDouble(14,strategy.getCheaper());
	        ps.setString(15,strategy.getStrategyID());
	        ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return ret;
	}
	/**
	 * 删除指定活动
	 * 
	 * @param id
	 * @return
	 */
	public int delStrategy(String id) {
		String sql = "DELETE FROM strategytable WHERE strategyID=" + id;
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
