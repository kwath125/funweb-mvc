package exam.controller.board;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.controller.Action;
import exam.dao.BoardDao;
import exam.domain.BoardVo;

public class ReplyWriteProAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// post 파라미터 한글처리
		request.setCharacterEncoding("utf-8");

		BoardVo vo = new BoardVo();

		String pageNum = request.getParameter("pageNum");
		
		// ip주소  작성일자 값 저장
		vo.setReRef(Integer.parseInt(request.getParameter("reRef")));
		vo.setReLev(Integer.parseInt(request.getParameter("reLev")));
		vo.setReSeq(Integer.parseInt(request.getParameter("reSeq")));
		vo.setName(request.getParameter("name"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setIp(request.getRemoteAddr());
		vo.setRegDate(LocalDateTime.now());
		
		// DB객체 가져오기
		BoardDao dao = BoardDao.getInstance();
		// 주글 한개 등록
		dao.replyInsert(vo) ;
		
		// notice.do로 리다이렉트 이동정보 리턴
		return "redirect:/notice.do?pageNum=" + pageNum;
	}

}




