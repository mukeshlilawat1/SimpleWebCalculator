package com.lilawat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class ServletCalc extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		try {
			int fn = Integer.parseInt(req.getParameter("fn"));
			int sn = Integer.parseInt(req.getParameter("sn"));
			String op = req.getParameter("op");
			int result = 0;

			switch (op) {
			case "+":
				result = fn + sn;
				break;
			case "-":
				result = fn - sn;
				break;
			case "*":
				result = fn * sn;
				break;
			case "/":
				if (sn == 0)
					throw new ArithmeticException("Cannot divide by zero");
				result = fn / sn;
				break;
			case "%":
				result = fn % sn;
				break;
			case "^":
				result = (int) Math.pow(fn, sn);
				break; // Power
			case "max":
				result = Math.max(fn, sn);
				break;
			case "min":
				result = Math.min(fn, sn);
				break;
			default:
				throw new Exception("Invalid Operation");
			}

			req.setAttribute("s", result);
			req.getRequestDispatcher("/servlet2").forward(req, resp);

		} catch (NumberFormatException | ArithmeticException e) {
			out.println(" Error: " + e.getMessage());
		} catch (Exception e) {
			out.println("<html><body><h3>Error: " + e.getMessage() + "</h3></body></html>");
		}

	}

}
