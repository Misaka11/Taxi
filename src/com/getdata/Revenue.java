package com.getdata;

public class Revenue {
     int sum;//某个月总营收
     String []cph=new String[10];//营收最高的十辆车的车牌号
     int []money=new int[10];//对应的钱数
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String[] getCph() {
		return cph;
	}
	public void setCph(String[] cph) {
		this.cph = cph;
	}
	public int[] getMoney() {
		return money;
	}
	public void setMoney(int[] money) {
		this.money = money;
	}
     
}
