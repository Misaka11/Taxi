package com.getdata;

public class CarPath {
     String name;//³µÅÆºÅ
     String [][] path;
    
    public CarPath()
    {
    	int ArraySize=200;
    	path=new String[ArraySize][2];
    }
    public CarPath(int ArraySize)
    {
    	path=new String[ArraySize][2];
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[][] getPath() {
		return path;
	}
	public void setPath(String[][] path) {
		this.path = path;
	}

     
}
