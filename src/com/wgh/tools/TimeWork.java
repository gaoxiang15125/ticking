package com.wgh.tools;
/**
* @author 作者 gaoxiang
* @version 创建时间：2018年3月30日 下午8:25:26
* 类说明
*/
public class TimeWork extends Thread{
	
	private InfoGetter infoGetter;
	
	public TimeWork() {
		infoGetter =new InfoGetter();
	}
	
	public void run() {
		while(true) {
			try {
				sleep(2*60*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
