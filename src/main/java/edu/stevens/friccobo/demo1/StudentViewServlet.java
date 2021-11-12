package edu.stevens.friccobo.demo1;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/student")
public class StudentViewServlet extends HttpServlet  {

    @Inject
    AssignmentMap assignmentMap;

    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));

        String githubUrl = assignmentMap.get(assignmentId);

        if(githubUrl == null){
            response.setStatus(404);
        } else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            writer.println("<html>");
            writer.println("<a href='"+githubUrl+ "'>Go To Github</a>");
            writer.println("</html>");
        }

    }

    @Override
    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

    }
}
