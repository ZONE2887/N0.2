package PH.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import PH.bean.Phone;
import PH.dao.PhDao;

/**
 * Servlet implementation class IndexPhServlet
 */
@WebServlet("/sy.s")
public class SyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhDao pdao = new PhDao();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Phone> list = null;
		try {
			list = pdao.selectIndex();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
