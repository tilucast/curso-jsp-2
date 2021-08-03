package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.ImageDAO;
import connection.SingleConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Image;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ImageDAO imageDAO = new ImageDAO();
	private static final Connection connection = SingleConnection.getConnection();

    
    public FileUpload() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			List<Image> listOfImages = imageDAO.select();
			
			request.setAttribute("listOfImages", listOfImages);
			request.getRequestDispatcher("/pages/loadImages.jsp").forward(request, response);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String file = request.getParameter("file");
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			
			if(name == null || name.equals("null") || name.isEmpty()) {
				name = "blank";
			}
			
			Image img = new Image(file, name, type);
			
			imageDAO.create(img);
			
			response.getWriter().write("Image uploaded successfully.");
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			response.setStatus(500);
			response.getWriter().write("Something went wrong");
		} catch(Exception e2) {
			e2.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			response.setStatus(500);
			response.getWriter().write("Something went wrong");
		}
	}

}
