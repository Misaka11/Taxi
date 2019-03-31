package com.getdata;

public class Production {
    int []driversNum=new int[12];
    int []carsNum=new int[12];
    Production() {
    	for(int i=0;i<12;i++) driversNum[i]=carsNum[i]=0;
    }
	public int[] getDriversNum() {
		return driversNum;
	}
	public void setDriversNum(int[] driversNum) {
		this.driversNum = driversNum;
	}
	public int[] getCarsNum() {
		return carsNum;
	}
	public void setCarsNum(int[] carsNum) {
		this.carsNum = carsNum;
	}
    
}
