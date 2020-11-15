package exam.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.MemberDao;
import exam.domain.MemberVo;
import exam.domain.PageDto;
import lombok.extern.java.Log;

@Log
public class MemberListAdminAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("MemberListAdminAction 호출");
		
		// 세션값 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		System.out.println("id" + id);
		
		if (id == null || !id.equals("admin")) { // id.equals("admin") == false
			return "redirect:/index.do";
		}
		
		// DB객체 가져오기
		MemberDao dao = MemberDao.getInstance();
		// 전체 멤버 수
		int totalCount = dao.getCount();
		System.out.println("totalCount" + totalCount);
		
		// 회원 정보 있을 경우 페이지 생성
		String strPageNum = request.getParameter("pageNum");
		if (strPageNum == null || strPageNum.equals("")) {
			strPageNum = "1";
		}
		
		// 페이지 번호
		int pageNum = Integer.parseInt(strPageNum);
		
		// 한페이지에 호출되는 회원 정보
		int pageSize = 10;
		
		// 시작행번호
		int startRow = (pageNum - 1) * pageSize;
		
		//멤버 정보 가져오기
		
		List<MemberVo> list = dao.getMembers();
		
		// 총 페이지 수 구하기
		// 글50개. 한화면에보여줄글 10개 -> 50/10 = 5페이지
		// 글55개. 한화면에보여줄글 10개 -> 55/10 = 5 + 1페이지(나머지 있으면) -> 6페이지
		// int pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
		int pageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			pageCount += 1;
		}
		
		//페이지 블록수 설정
		int pageBlock = 1;
		
		int startPage = ((pageNum / pageBlock) - (pageNum % pageBlock == 0 ? 1 : 0)) * pageBlock + 1;
		
		// 끝페이지 번호 endPage구하기
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) {
		   endPage = pageCount;
		}
		
		// 페이지블록 관련 정보를 PageDTO에 저장(Map 컬렉션 사용 가능)
		PageDto pageDto = new PageDto();
		pageDto.setTotalCount(totalCount);
		System.out.println("totalCount" + totalCount);
		pageDto.setPageCount(pageCount);
		pageDto.setPageBlock(pageBlock);
		pageDto.setStartPage(startPage);
		pageDto.setEndPage(endPage);
		
		// 뷰(jsp)에서 사용할 데이터를 request 영역객체에 저장
		request.setAttribute("memberList", list);
		request.setAttribute("pageDto", pageDto);
		request.setAttribute("pageNum", pageNum);
		
		return "admin/memberListAdmin";  // jsp 뷰 이름 리턴
	}

}



