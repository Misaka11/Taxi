package com.getdata;

import net.sf.json.JSONObject;

public class tryjava {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
  /*      String month="09";
        int m=Integer.parseInt(month);
        System.out.println(m);
        String []date=new String[]{"31","28","31","30","31","30","31","31","30","31","30","31"};//每个月的天数
        String ans="exception",sql="";
    	OracleJdbc test = new OracleJdbc();
    	try
    	{
            sql="select distinct VEHICLEID,sum(DBZJE) over(partition by VEHICLEID) SUMJE from T_BUSI_DRISIGN where DBZJE is not null and SIGNIN_TIME between to_date('2018"+month+"01 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date('2018"+month+""+date[m-1]+" 23:59:59','yyyy-mm-dd hh24:mi:ss') order by SUMJE desc";
            System.out.println(sql);
            ans=test.queryRevenue(sql);
    	}catch(Exception e)
    	{
    	}           
    	System.out.println(ans);*/
	      System.out.println("into productionServlet");
	        String date[]=new String[24];
	        String sql;
	        date[0]="0101";date[1]="0131";
	        date[2]="0201";date[3]="0228";
	        date[4]="0301";date[5]="0331";
	        date[6]="0401";date[7]="0430";
	        date[8]="0501";date[9]="0531";
	        date[10]="0601";date[11]="0630";
	        date[12]="0701";date[13]="0731";
	        date[14]="0801";date[15]="0831";
	        date[16]="0901";date[17]="0930";
	        date[18]="1001";date[19]="1031";
	        date[20]="1101";date[21]="1130";
	        date[22]="1201";date[23]="1231";
	        Production ans=new Production();
	        String jsonstr="未找到";
	    	OracleJdbc test = new OracleJdbc();
	    	try
	    	{
	    		for(int i=0;i<12;i++)
	            {
	            	sql="select distinct VEHICLEID from T_BUSI_DRISIGN where SIGNIN_TIME between to_date('2018"+date[i*2]+" 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date( '2018"+date[2*i+1]+" 23:59:59','yyyy-mm-dd hh24:mi:ss')";
	            	ans.carsNum[i]=test.queryNum(sql);   
	            	System.out.println(ans.carsNum[i]);
	            	sql="select distinct EMPLOYEECODE from T_BUSI_DRISIGN where SIGNIN_TIME between to_date('2018"+date[i*2]+" 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date( '2018"+date[2*i+1]+" 23:59:59','yyyy-mm-dd hh24:mi:ss')";
	                ans.driversNum[i]=test.queryNum(sql);
	            }
	    	}catch(Exception e)
	    	{
	    	}           
	    	System.out.println(ans);
	        JSONObject json=JSONObject.fromObject(ans);
	        jsonstr = json.toString();
	        System.out.println(jsonstr);
	}
}
