package exam.controller.member;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.MemberDao;
import exam.domain.MemberVo;
import lombok.extern.java.Log;

@Log
public class MemberDeleteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		// 세션 가져오기
		String id = (String) session.getAttribute("id");
		// 세션 없으면 login.do로 이동
		if (id == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용할 수 있습니다.');");
			out.println("location.href = '/memberLogin.do';");
			out.println("</script>");
			//out.flush();
			out.close();
			return null;
		}
		
		
		// post 파라미터 한글처리
		request.setCharacterEncoding("utf-8");
				
		// MemberVo 객체 생성
		MemberVo vo = new MemberVo();
		
		
		// "passwd 파라미터"
		String passwd = request.getParameter("passwd");

		// DB객체 가져오기
		MemberDao dao = MemberDao.getInstance();
		
		// -1: 아이디 없음, 0: 비밀번호 틀림, 1: 아이디 비밀번호 일치
		int check = dao.userCheck(id, passwd);
		
		if (check == 1) { // 아이디와 비밀번호 일치 하면 -> 1
			// 테이블에서 행 삭제
			dao.deleteById(id);
			session.invalidate();
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("id")) {
						cookie.setMaxAge(0); // 유효기간 0 설정
						cookie.setPath("/"); // 경로 설정
						response.addCookie(cookie);
					}
				}
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴 되었습니다.');");
			out.println("location.href = '/index.do';");
			out.println("</script>");
			//out.flush();
			out.close();
			return null;
			

		} else if (check == 0) { // 비밀번호 틀림
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
			//out.flush();
			out.close();
			return null;
		}
		
		return "redirect:/memberLogin.do";
	}

}
