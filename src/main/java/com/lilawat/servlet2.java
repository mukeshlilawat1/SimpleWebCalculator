package com.lilawat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object result = req.getAttribute("s");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<title>Calculation Result</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head><body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<div class='row justify-content-center'>");
        out.println("<div class='col-md-6'>");
        out.println("<div class='card shadow p-4'>");

        out.println("<h3 class='text-center mb-4'>Calculation Result</h3>");
        out.println("<p class='fs-5'><strong>Result:</strong> " + result + "</p>");

        out.println("<div class='text-center mt-4'>");
        out.println("<a href='index.html' class='btn btn-primary'>Back to Calculator</a>");
        out.println("</div>");

        out.println("</div></div></div></div>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
