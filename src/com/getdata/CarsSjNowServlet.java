package com.getdata;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarsSjNowServlet
 */
@WebServlet("/CarsSjNowServlet")
public class CarsSjNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarsSjNowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	String sj=request.getParameter("sj");
    	String day=sj.substring(0,9);
    	sj=sj.substring(0,14);
    	System.out.println(sj);
    	String ans="Œ¥’“µΩ";    	
    	OracleJdbc test = new OracleJdbc();
        String sql="select cph,JD,WD from gpsv4_his.t_gps_"+day+" where SJ between to_date('"+sj+":00','yyyy-mm-dd hh24:mi:ss') and to_date( '"+sj+":59','yyyy-mm-dd hh24:mi:ss') order by CPH";
    	try
    	{
    		ans=test.queryCars(sql);
    	}catch(Exception e)
    	{

    	}    	
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
