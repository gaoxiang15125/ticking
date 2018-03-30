package tools; 

import java.sql.Timestamp;
import java.text.NumberFormat;
/** 
* @author 高翔 E-mail: 630268696@qq.com
* @version 创建时间：2017年4月16日 下午4:13:26 
* 类说明 
*/
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;

  
  
public class DateUtil {  
      
	/**
	 * 将date类型转化为String类型
	 * @param date
	 * @return
	 */
     public static String  dateToString(Date date){
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
         String specifiedDay = '"'+sdf.format(date)+'"';  
         return specifiedDay;
     }
     
     /**
      * 获取当前时间
      */
     public static Timestamp getTimeNow() {
    	 Date date = new Date(System.currentTimeMillis()); 
    	 return new Timestamp(date.getTime());
     }
    /** 
     * 获得指定日期的前一天 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
    public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - 1);  
  
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c  
                .getTime());  
        return dayBefore;  
    }  
  
    /** 
     * 获得指定日期的后一天 
     *  
     * @param specifiedDay 
     * @return 
     */  
    public static String getSpecifiedDayAfter(String specifiedDay) {  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + 1);  
  
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")  
                .format(c.getTime());  
        return dayAfter;  
    }  
    
    public static Date changeToDate(String date){
    	Date date2 = null ;
    	  try {  
              date2 = new SimpleDateFormat("yy-MM-dd").parse(date); 
          } catch (ParseException e) {  
        	  System.out.println(date);
              e.printStackTrace();  
          }  
    	  return date2;
    }
    /**
     * 将double类型数据转换为百分比格式，并保留小数点前IntegerDigits位和小数点后FractionDigits位
     * @param d
     * @param IntegerDigits
     * @param FractionDigits
     * @return
     */
    public static String getPercentFormat(double d,int IntegerDigits,int FractionDigits){
     NumberFormat nf = java.text.NumberFormat.getPercentInstance(); 
     nf.setMaximumIntegerDigits(IntegerDigits);//小数点前保留几位
     nf.setMinimumFractionDigits(FractionDigits);// 小数点后保留几位
     String str = nf.format(d);
     return str;
    }
    public static void main(String[]args){
    	Date date = new Date();
    	String sd =DateUtil.dateToString(date);
    	date = DateUtil.changeToDate(sd);
    	System.out.println(dateToString(date));
    }
    
}  
 