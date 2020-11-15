package exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.MemberDao;
import lombok.extern.java.Log;

@Log
public class MemberUpdateUserCheckProAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("MemberUpdateUserCheckProAction");
		
		// id passwd 파라미터 가져오기
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id");
		String passwd = request.getParameter("passwd");
		// 세션값 없으면 loginForm.jsp로 이동
		if (id == null) {
			return "redirect:/memberLogin.do";
		}
		
		// DB객체 가져오기
		MemberDao dao = MemberDao.getInstance();
		
		// -1: 아이디 없음, 0: 비밀번호 틀림, 1: 아이디 비밀번호 일치
		int check = dao.userCheck(id, passwd);

		if (check == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
			//out.flush();
			out.close();
		} else if (check == 1) {
			return "redirect:/memberUpdate.do";
		}
		
		return "redirect:/index.do";
	}

}




