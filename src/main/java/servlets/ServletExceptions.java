package servlets;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletExceptions")
public class ServletExceptions extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public ServletExceptions() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			System.out.println(0/0);
			String param1 = request.getParameter("param");
			System.out.println(param1);
			response.setStatus(200);
			response.getWriter().write(param1 + " coming from the server.");
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().write(e.toString());
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
