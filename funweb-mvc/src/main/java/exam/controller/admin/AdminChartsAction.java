package exam.controller.admin;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import exam.controller.Action;
import exam.dao.ChartDao;

public class AdminChartsAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		//Admin 사용자 확인
		String id = (String) session.getAttribute("id");
		if (id == null || !id.equals("admin")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 계정이 아닙니다.');");
			out.println("location.href = '/memberLogin.do';");
			out.println("</script>");
			//out.flush();
			out.close();
			return null;
		}
			
		ChartDao dao = ChartDao.getInstance();
		List<List<Object>> dateList = dao.getBoardDate();
		System.out.println("dateList = " + dateList);
		List<List<Object>> ageList = dao.getAge();
		System.out.println("ageList = " + ageList);

		
		Gson gson = new Gson();
		String dateStr = gson.toJson(dateList);
		System.out.println("dateStr  = " + dateStr);
		String ageStr = gson.toJson(ageList);
		System.out.println("ageStr  = " + ageStr);
		
		// 뷰(jsp)에서 사용할 데이터를 request 영역객체에 저장
		request.setAttribute("dateStr", dateStr);
		request.setAttribute("ageStr", ageStr);
		
		
		return "admin/adminCharts";  // jsp 뷰 이름 리턴
	}

}



