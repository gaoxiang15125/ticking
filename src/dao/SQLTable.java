package dao;
/**
* @author 作者
* @version 创建时间：2018年3月11日 上午10:25:55
* 类说明
*/
public enum SQLTable {
	
	ordertable("ordertable","orderID,userID,money,orderTime,orderType,orderStatus"),
	seattable("seattable"),
	strategytable("strategytable"),
	user("user"),
	venuetable("venuetable");
	private String vaule;
	private String tableName;
	
	private SQLTable(String vaule,String tableName) {
		this.tableName =tableName;
		this.vaule=vaule;
	}
	private SQLTable(String tableName) {
		this.tableName =tableName;
	}
	public String getVaule() {
		return vaule;
	}
	public void setVaule(String vaule) {
		this.vaule = vaule;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
