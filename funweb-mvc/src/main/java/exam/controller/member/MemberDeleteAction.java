package exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.MemberDao;
import exam.domain.MemberVo;

public class MemberDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 세션값 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		// 세션값 없으면 login.do로 이동
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
		
		// DB객체 가져오기
		MemberDao dao = MemberDao.getInstance();
		// 아이디 가져오기
		MemberVo vo = dao.getMemberById(id);
		// jsp화면(뷰) 만들때 필요한 데이터를 영역객체에 저장
		request.setAttribute("memberVo", vo);
		
		return "member/delete";  // jsp 뷰 이름 리턴
	}

}



