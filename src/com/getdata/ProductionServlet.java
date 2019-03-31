package com.getdata;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List; 
import net.sf.json.JSON; 
import net.sf.json.JSONArray; 
import net.sf.json.JSONObject; 
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter; 

/**
 * Servlet implementation class ProductionServlet
 */
@WebServlet("/ProductionServlet")
public class ProductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
        String jsonstr="Œ¥’“µΩ";
    	OracleJdbc test = new OracleJdbc();
    	try
    	{
    		for(int i=0;i<12;i++)
            {
            	sql="select distinct VEHICLEID from T_BUSI_DRISIGN where SIGNIN_TIME between to_date('2018"+date[i*2]+" 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date( '2018"+date[2*i+1]+" 23:59:59','yyyy-mm-dd hh24:mi:ss')";
            	ans.carsNum[i]=test.queryNum(sql);   
            	sql="select distinct EMPLOYEECODE from T_BUSI_DRISIGN where SIGNIN_TIME between to_date('2018"+date[i*2]+" 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date( '2018"+date[2*i+1]+" 23:59:59','yyyy-mm-dd hh24:mi:ss')";
                ans.driversNum[i]=test.queryNum(sql);
            }
    	}catch(Exception e)
    	{
    	}           
    	System.out.println(ans);
        JSONObject json=JSONObject.fromObject(ans);
        jsonstr = json.toString();
        response.getWriter().print(jsonstr);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
