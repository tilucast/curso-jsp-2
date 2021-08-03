package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnection;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterAuthenticate implements Filter{
	
	private static Connection connection;
	
	public FilterAuthenticate() {
		
	}
	
	@Override
	public void destroy() {
		
		try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("I am working exactly as intended.");
		
		//when any of the mutating operations are coded, remember to call here connection.commit.
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		connection = SingleConnection.getConnection();
	}

}
