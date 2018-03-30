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

import com.wgh.model.Venue;
import com.wgh.tools.InfoGetter;

public class VenueDao {
	private InfoGetter conn = null;// 创建数据库连接对象

	public VenueDao() {
		conn = InfoGetter.getInstance();// 实例化数据库连接对象
	}

	/**
	 * 查询所有场馆
	 * 
	 * @param sql 需要执行的获取表中全部数据的sql语句
	 * @return
	 */
	public List<Venue> queryDiary(String sql) {
		ResultSet rs = conn.executeQuery(sql);// 执行查询语句
		List<Venue> list = new ArrayList<Venue>();
		try {// 捕获异常
			while (rs.next()) {
				Venue venue = new Venue();
				venue.setVenueID(rs.getString(1));
				venue.setVenueName(rs.getString(3));
				venue.setSeatNum(rs.getInt(4));
				venue.setAvailSeatNum(rs.getInt(5));
				venue.setVenue_Introduce(rs.getString(6));
				venue.setVaule_ratio(rs.getDouble(7));
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
	public int saveVenue(Venue venue,String password) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		int ret = 0;
		try {
			ps = infoGetter.connection.prepareStatement("insert into venuetable(passID,venueName,venueSeatNum,availSeat,venueIntroduce,cheaper,venueID) values (?,?,?,?,?,?,?)");
			ps.setString(1, password);
	        ps.setString(2, venue.getVenueName());
	        ps.setInt(3,venue.getSeatNum());
	        ps.setInt(4, venue.getAvailSeatNum());
	        ps.setString(5,venue.getVenue_Introduce());
	        ps.setDouble(6,venue.getVaule_ratio());
	        ps.setString(7, venue.getVenueID());
	        ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return ret;
	}
	/**
	 * 删除指定场馆
	 * 
	 * @param id
	 * @return
	 */
	public int delVenue(String id) {
		//直接赋值看来是可以的
		String sql = "DELETE FROM venuetable WHERE id=" + id;
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
	 * 随机生成场馆密码代码
	 * @return
	 */
	public String getPassword() {
		java.util.Random r=new java.util.Random(System.currentTimeMillis());
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<8;i++){
		    int k=0;
		    stringBuilder.append(r.nextInt(10));
		}
		return stringBuilder.toString();
	}

	/**
	 * 功能：更新场馆信息到数据库
	 * 
	 * @param diary
	 * @return
	 */
	public int refushVenue(Venue venue) {
		InfoGetter infoGetter = InfoGetter.getInstance();
		PreparedStatement ps;
		int ret = 0;
		try {
			ps = infoGetter.connection.prepareStatement("update venuetable set venueName=?, venueSeatNum=?,availSeat=?,venueIntroduce=?,cheaper=? where venueID=?");
			//ps.setString(1, password);
	        ps.setString(1, venue.getVenueName());
	        ps.setInt(2,venue.getSeatNum());
	        ps.setInt(3, venue.getAvailSeatNum());
	        ps.setString(4,venue.getVenue_Introduce());
	        ps.setDouble(5,venue.getVaule_ratio());
	        ps.setString(6, venue.getVenueID());
	        ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		return ret;
	}
}
