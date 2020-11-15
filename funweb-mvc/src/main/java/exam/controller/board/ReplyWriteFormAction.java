package exam.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.controller.Action;
import exam.domain.BoardVo;

public class ReplyWriteFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVo vo = new BoardVo();
		
		vo.setReRef(Integer.parseInt(request.getParameter("reRef")));
		vo.setReLev(Integer.parseInt(request.getParameter("reLev")));
		vo.setReSeq(Integer.parseInt(request.getParameter("reSeq")));
		String strPageNum = request.getParameter("pageNum");
		
		int pageNum = Integer.parseInt(strPageNum);
		
		request.setAttribute("boardVo", vo);
		request.setAttribute("pageNum", pageNum);
		
		return "center/replyWriteForm";
	}

}
