package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDto;
import dto.MemberDto;

/**
 * Servlet implementation class DoTest
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); // 클라이언트가 요청한 uri
		// uri -> http://localhost:8888/jsp_exception_20250807/loginOk.do
		String con = request.getContextPath(); // 컨텍스트 패스의 길이 인덱스부터 끝까지 추출
		// con -> http://localhost:8888/jsp_exception_20250807
		String command = uri.substring(con.length()); // loginOk.do
		// command -> /loginOk.do
		
		String viewPage = "";
		HttpSession session = null;
		if(command.equals("/loginOk.do")) {
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			if(mid.equals("tiger") && mpw.equals("12345")) {
				session = request.getSession();
				
				session.setAttribute("sid", mid);
				// response.sendRedirect("welcome.jsp");
				
				viewPage = "welcome.jsp";
			} else {
				request.setAttribute("errorMsg", "잘못된 아이디 또는 비밀번호입니다.");
				
				viewPage = "login.jsp";
			}
		} else if(command.equals("/login.do")) {
			viewPage = "login.jsp";
		} else if(command.equals("/welcome.do")) {
			viewPage = "welcome.jsp";
		} else if(command.equals("/logout.do")) {
			session = request.getSession();
			session.invalidate();
			
			request.setAttribute("errorMsg", "로그아웃 하신 후에 다시 로그인 하시려면 다시 입력해주세요.");
			viewPage = "login.jsp";
		} else if (command.equals("/freeboard.do")) {
			// 게시판 더미 데이터로 만들기
			List<BoardDto> boardList = new ArrayList<BoardDto>();
			
			boardList.add(new BoardDto("안녕하세요","쥐똥이","2025-08-07"));
			boardList.add(new BoardDto("감사해요","개똥이","2025-08-07"));
			boardList.add(new BoardDto("잘있어요","소똥이","2025-08-07"));
			boardList.add(new BoardDto("다시 만나요","말똥이","2025-08-07"));
			boardList.add(new BoardDto("길가다가 5000원 주움.","양똥이","2025-08-07"));
			
			request.setAttribute("boardList", boardList); // request 객체에 게시판 목록 넣기
			
			viewPage = "boardList.jsp";
		} else if (command.equals("/member.do")) {
			// 회원 정보
			
			List<MemberDto> memberList = new ArrayList<MemberDto>();
			
			memberList.add(new MemberDto("tiger", "쥐똥이", "17", "2025-03-01"));
			memberList.add(new MemberDto("lion", "개똥이", "19", "2025-04-09"));
			memberList.add(new MemberDto("blackcat", "소똥이", "21", "2025-04-11"));
			memberList.add(new MemberDto("whitedog", "말똥이", "27", "2025-05-05"));
			memberList.add(new MemberDto("redtiger", "양똥이", "31", "2025-06-20"));
			
			request.setAttribute("memberList", memberList);
			
			viewPage = "memberList.jsp";
		}
		
		
		
		//response.sendRedirect(viewPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}