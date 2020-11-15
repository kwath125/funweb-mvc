package exam.controller.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.controller.Action;
import lombok.extern.java.Log;

@Log
public class AboutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("AboutAction");
		return "/about";
	}

}
