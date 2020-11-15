package exam.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.BoardDao;
import exam.dao.MemberDao;
import exam.domain.MemberVo;

public class MemberUpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 세션값 가져오기
		HttpSession session = request.getSession(); 
		String id = (String)session.getAttribute("id"); 
		// 세션값 없으면 /memberLogin.do 리다이렉트 이동 
		if (id == null) { 
			return "redirect:/memberLogin.do"; 
		}
		
		MemberDao dao = MemberDao.getInstance();
		
		MemberVo vo = dao.getMemberById(id);
		
		request.setAttribute("member", vo);
		
		return "member/update";  // jsp 뷰 이름 리턴
	}

}



