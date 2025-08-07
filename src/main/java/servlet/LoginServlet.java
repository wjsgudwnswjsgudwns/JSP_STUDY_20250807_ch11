package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/*.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".do 호출");
		String mid = request.getParameter("mid");
		System.out.println("login.jsp에서 넘겨 받은 mid : " + mid);
		String mpw = request.getParameter("mpw");
		System.out.println("login.jsp에서 넘겨 받은 mpw : " + mpw);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			HttpSession session = request.getSession(); // 세션 생성
			
			session.setAttribute("sid", mid);
			response.sendRedirect("welcome.jsp");
		} else {
			//response.sendRedirect("loginFail.jsp");
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 잘못 되었습니다");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
