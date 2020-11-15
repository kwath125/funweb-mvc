package exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.MemberDao;

public class MemberUpdateUserCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// 세션값 가져오기
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id");
		String passwd = request.getParameter("passwd");
		
		// DB객체 가져오기
		MemberDao dao = MemberDao.getInstance();
				
		// -1: 아이디 없음, 0: 비밀번호 틀림, 1: 아이디 비밀번호 일치
		int check = dao.userCheck(id, passwd);
				
		
		// 세션값 없으면 /memberLogin.do 리다이렉트 이동 
		if (id == null) { 
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
		
		return "member/updateUserCheck";  // jsp 뷰 이름 리턴
	}

}



