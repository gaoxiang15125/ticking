package tools;

import java.util.Random;

/**
* @author 作者 gaoxiang
* @version 创建时间：2018年3月30日 下午8:06:41
* 类说明 z
*/
public class ShareNum {
	
	public static String getRand(int length) {
		long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
		StringBuilder stringBuilder =new StringBuilder();
        for(int i=0; i<length; i++) {
        	int k = rd.nextInt()%10;
        	stringBuilder.append(k);
		}
        return stringBuilder.toString();
	}
}
