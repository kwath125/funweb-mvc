package exam.controller.admin;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.controller.Action;
import exam.dao.AttachfileDao;
import exam.dao.BoardDao;
import exam.domain.AttachfileVo;
import exam.domain.BoardVo;
import exam.domain.PageDto;
import lombok.extern.java.Log;

@Log
public class FileNoticeAdminDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		// 세션 가져오기
		String id = (String) session.getAttribute("id");
		
		if (id.equals("admin")){
			
			// num  pageNum  파라미터 가져오기

			String pageNum = request.getParameter("pageNum");
			String[] selected = request.getParameterValues("selected");

		
			if (selected != null) {
				BoardDao dao = BoardDao.getInstance();
				AttachfileDao attachDao = AttachfileDao.getInstance();
				for (int i=0; i<selected.length; i++) {
					int bno = Integer.parseInt(selected[i]);
					List<AttachfileVo> attachList = attachDao.getAttachfilesByBno(bno);
				
				for (AttachfileVo attachVo : attachList) {
					String filename = attachVo.getUuid() + "_" + attachVo.getFilename(); 
				
					File file = new File(attachVo.getUploadpath(), filename);
					
					if (file.exists()) {
						file.delete();
					}
				
				}
				attachDao.deleteAttachfilesByBno(bno);
				dao.deleteByNum(bno);
				
				}
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 되었습니다.');");
				out.println("location.href = '/fileNoticeAdmin.do?pageNum=';" + pageNum);
				out.println("</script>");
				//out.flush();
				out.close();
				return null;
			
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('선택한 글이 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
				//out.flush();
				out.close();
				return null;
			}
		}
		
		return null;
	}

}
