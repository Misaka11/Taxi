package com.getdata;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SCPosServlet
 */
@WebServlet("/SCPosServlet")
public class SCPosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SCPosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    	String sj_to=request.getParameter("sj_to");
    	String sj_from=request.getParameter("sj_from");
    	String sql="select SCJD,SCWD from T_BUSI_RUN where SCSJ between to_date('"+sj_from+"','yyyy-mm-dd hh24:mi:ss') and to_date('"+sj_to+"','yyyy-mm-dd hh24:mi:ss')";
	    String ans="exception";
    	OracleJdbc test = new OracleJdbc();
    	try
    	{
    		ans=test.querySCPos(sql);
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
