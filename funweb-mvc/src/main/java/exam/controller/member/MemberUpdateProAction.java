package exam.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.BoardDao;
import exam.dao.MemberDao;
import exam.domain.MemberVo;

public class MemberUpdateProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		// 세션 가져오기
		String id = (String) session.getAttribute("id");
		String passwd = request.getParameter("passwd");
		
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
		
		// 파라미터 가져와서 vo객체에 설정
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setGender(request.getParameter("gender"));
		vo.setEmail(request.getParameter("email"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setMtel(request.getParameter("mtel"));
		
		System.out.println(vo);
		
		
		// 싱글톤 dao 객체 가져오기
		MemberDao dao = MemberDao.getInstance();
		
		// 회원정보 수정하기
		int rowCount = dao.update(vo);
		System.out.println(rowCount);
		
		if (rowCount > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보가 수정되었습니다.');");
			out.println("location.href = '/index.do';");
			out.println("</script>");
			//out.flush();
			out.close();
			return null;
		} 
			else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보를 수정 할 수 없습니다. 다시 시도하세요.');");
			out.println("history.back();");
			out.println("</script>");
			//out.flush();
			out.close();
		}
		
		return null; 
	}

}



