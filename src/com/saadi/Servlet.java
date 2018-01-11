package com.saadi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = -5844582179064431926L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		try {
			Filter resultFilter = new Filter();
			resultFilter.setFilterList(req.getParameter("FilterList"));
			resultFilter.setFilterValue(req.getParameter("FilterValue"));
			DrawJsp filteredjsp = new DrawJsp();
			filteredjsp.setResultFilter(resultFilter);
			StringBuilder json;
			json = filteredjsp.draw();

			req.setAttribute("json", json);
			req.getRequestDispatcher("offers.jsp").forward(req, res);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}
