package com.getdata;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPathServlet
 */
@WebServlet("/GetPathServlet")
public class GetPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPathServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");             
        //连接数据库，根据车牌号，取得 车牌号+JD+WD
    	String cph=request.getParameter("car");
    	String sj=request.getParameter("sj");
    	OracleJdbc test = new OracleJdbc();
    	//select JD,WD from taxi where CPH='cph';
    	String sql="select JD,WD from gpsv4_his.t_gps_"+sj+" where CPH='"+cph+"' order by SJ asc";
    	String ans="未找到";
    	try
    	{
    		ans=test.querypath(sql,cph);
    	}catch(Exception e)
    	{
    		ans="exception";
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
