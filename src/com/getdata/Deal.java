package com.getdata;

public class Deal {
	//���ݽ��ף��ж�˾���Ƿ���·
    String CPHM;
    int YYSJ;//Ӫ��ʱ��
    double YYLC;//Ӫ�����
    double YYJE;//Ӫ�˽��
    double[] startLngLat=new double[2];
    double[] endLngLat=new double[2];
	public String getCPHM() {
		return CPHM;
	}
	public void setCPHM(String cPHM) {
		CPHM = cPHM;
	}
	public int getYYSJ() {
		return YYSJ;
	}
	public void setYYSJ(int yYSJ) {
		YYSJ = yYSJ;
	}
	public double getYYLC() {
		return YYLC;
	}
	public void setYYLC(double yYLC) {
		YYLC = yYLC;
	}
	public double getYYJE() {
		return YYJE;
	}
	public void setYYJE(double yYJE) {
		YYJE = yYJE;
	}
	public double[] getStartLngLat() {
		return startLngLat;
	}
	public void setStartLngLat(double[] startLngLat) {
		this.startLngLat = startLngLat;
	}
	public double[] getEndLngLat() {
		return endLngLat;
	}
	public void setEndLngLat(double[] endLngLat) {
		this.endLngLat = endLngLat;
	}
    
}
