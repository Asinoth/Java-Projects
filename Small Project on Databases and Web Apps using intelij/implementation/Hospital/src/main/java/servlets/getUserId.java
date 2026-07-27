/* This servlet returns the id of a user with a specific username */

package servlets;

import db.tables.EditUserTable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getUserId", value = "/getUserId")
public class getUserId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        EditUserTable ut = new EditUserTable();
        Integer id;
        try (PrintWriter out = response.getWriter()) {
            try {
                id = ut.UserId(username);
                out.println(id);
                response.setStatus(200);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
