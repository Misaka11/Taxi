package com.getdata;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class RevenueServlet
 */
@WebServlet("/RevenueServlet")
public class RevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("into revenueServlet");
        String month=request.getParameter("month");
        int m=Integer.parseInt(month);
        String []date=new String[]{"31","28","31","30","31","30","31","31","30","31","30","31"};//每个月的天数
        String ans="exception",sql="";
    	OracleJdbc test = new OracleJdbc();
    	try
    	{
            sql="select distinct VEHICLEID,sum(DBZJE) over(partition by VEHICLEID) SUMJE from T_BUSI_DRISIGN where DBZJE is not null and SIGNIN_TIME between to_date('2018"+month+"01 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date('2018"+month+""+date[m-1]+" 23:59:59','yyyy-mm-dd hh24:mi:ss') order by SUMJE desc";
            ans=test.queryRevenue(sql);
    	}catch(Exception e)
    	{
    	}           
    	//System.out.println(ans);
        response.getWriter().print(ans);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
