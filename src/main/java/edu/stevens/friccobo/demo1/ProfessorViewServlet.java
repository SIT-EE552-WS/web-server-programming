package edu.stevens.friccobo.demo1;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/professor")
public class ProfessorViewServlet extends HttpServlet {

    @Inject
    AssignmentMap assignmentMap;

    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<pre>");
        writer.println(assignmentMap);
        writer.println("</pre>");

        writer.println("<form action='/professor' method='post'>" +
                "<label>Assignment ID " +
                "<input type=text name='assignmentId'/>" +
                "</label>" +
                "<label>Github URL" +
                "<input type=text name='githubUrl'/>" +
                "</label>" +
                "<input type='submit' value='Submit'/>" +
                "</form>");
        writer.println("</html>");
    }

    @Override
    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )  {

        Integer assignmentId = Integer.valueOf(request.getParameter("assignmentId"));
        String githubUrl = request.getParameter("githubUrl");

        assignmentMap.put(assignmentId, githubUrl);

    }
}
