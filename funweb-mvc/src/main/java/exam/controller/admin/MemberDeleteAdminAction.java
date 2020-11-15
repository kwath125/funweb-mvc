package exam.controller.admin;

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
public class MemberDeleteAdminAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String[] value = request.getParameterValues("selectedid");
		MemberDao dao = MemberDao.getInstance();
		if (value == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 회원을 선택해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			//out.flush();
			out.close();
			return null;
		}
		
		for (String id : value) {
			System.out.println(id);
			dao.deleteById(id);
			
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('탈퇴 되었습니다.');");
		out.println("location.href = '/memberListAdmin.do';");
		out.println("</script>");
		out.flush();
		out.close();
		
		return null;
		
		
	}

}
