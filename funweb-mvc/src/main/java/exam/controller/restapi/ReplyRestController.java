package exam.controller.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import exam.dao.ReplyDao;
import exam.domain.Criteria;
import exam.domain.ReplyVo;

@WebServlet(urlPatterns = "/api/reply", loadOnStartup = 1)
public class ReplyRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReplyDao replyDao;
	private Gson gson;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출됨");
		
		replyDao = ReplyDao.getInstance();
		gson = new Gson();
		
		//ServletContext application = config.getServletContext();
		//application.setAttribute("timer", new Timer(true));
	}

	public void destroy() {
		System.out.println("destroy() 호출됨");
	}

	// SELECT SQL문 수행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		
		// rno, bno, pageNum 파라미터 가져오기
		String strRno = request.getParameter("rno");
		String strBno = request.getParameter("bno");
		String strPageNum = request.getParameter("pageNum");
		
		String strJson = "";
		
		if (strRno != null) {
			// 댓글번호의 글 한개를 응답으로 주기
			int rno = Integer.parseInt(strRno);
			
			ReplyVo replyVo = replyDao.selectOne(rno);
			
			strJson = gson.toJson(replyVo);
			
		} else if (strBno != null && strPageNum != null) {
			// 게시글 번호에 달린 댓글 여러개를 페이징으로 가져오기
			int bno = Integer.parseInt(strBno);
			int pageNum = Integer.parseInt(strPageNum);
			
			Criteria cri = new Criteria(pageNum, 10);
			
			List<ReplyVo> list = replyDao.getListWithPaging(bno, cri);
			
			strJson = gson.toJson(list);
			
		} else { // strBno != null
			// 게시글 번호에 달린 댓글 여러개를 모두 가져오기
			int bno = Integer.parseInt(strBno);
			
			List<ReplyVo> list = replyDao.getList(bno);
			
			strJson = gson.toJson(list);
		}
		
		System.out.println(strJson);
		
		// 성공 응답주기
		response.setStatus(200); // 정상응답 코드 200 설정
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(strJson);
		out.close();
	} // doGet()

	// INSERT SQL문 수행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출됨");
		request.setCharacterEncoding("utf-8"); // 한글처리
		
		// http RequestBody 영역의 JSON 문자열 가져오기
		BufferedReader reader = request.getReader();
		if (reader == null) {
			System.out.println("RequestBody 영역에 메시지가 없습니다.");
			response.setStatus(500);
			return;
		}
		
		// http RequestBody 영역의 JSON 문자열을 ReplyVo 객체로 변환하기
		ReplyVo replyVo = gson.fromJson(reader, ReplyVo.class);
		System.out.println(replyVo);
		
		// ReplyVo를 DB 테이블에 INSERT 하기
		int count = replyDao.add(replyVo);
		
		// 입력스트림 닫기
		reader.close();
		
		
		// 응답처리
		if (count > 0) {
			response.setStatus(200); // 정상응답 코드 200 설정
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("success");
			//out.flush();
			out.close();
		} else {
			System.out.println("insert 실패...");
			response.setStatus(500); // 서버 내부로직 오류코드 500 설정
		}
	} // doPost()

	
	// UPDATE SQL문 수행
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPut() 호출됨");
		request.setCharacterEncoding("utf-8"); // 한글처리
		
		// http RequestBody 영역의 JSON 문자열 가져오기
		BufferedReader reader = request.getReader();
		if (reader == null) {
			System.out.println("RequestBody 영역에 메시지가 없습니다.");
			response.setStatus(500);
			return;
		}
		
		// http RequestBody 영역의 JSON 문자열을 ReplyVo 객체로 변환하기
		ReplyVo replyVo = gson.fromJson(reader, ReplyVo.class);
		System.out.println(replyVo);
		
		// ReplyVo UPDATE 하기
		replyDao.modify(replyVo);
		
		// 입력스트림 닫기
		reader.close();
		
		// 응답처리
		response.setStatus(200); // 정상응답 코드 200 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("success");
		out.close();
	} // doPut()

	
	// DELETE SQL문 수행
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doDelete() 호출됨");
		
		// rno 파라미터 가져오기
		String strRno = request.getParameter("rno");
		if (strRno == null) {
			System.out.println("삭제할 댓글번호 rno 파라미터가 없습니다.");
			response.setStatus(500);
			return;
		}
		
		int rno = Integer.parseInt(strRno);
		
		int count = replyDao.remove(rno);
		
		// 응답처리
		if (count > 0) {
			response.setStatus(200); // 정상응답 코드 200 설정
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("success");
			//out.flush();
			out.close();
		} else {
			System.out.println("insert 실패...");
			response.setStatus(500); // 서버 내부로직 오류코드 500 설정
		}
	} // doDelete()

}







