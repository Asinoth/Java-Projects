package servlets;

import db.tables.EditUserTable;
import mainClasses.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getUsers", value = "/getUsers")
public class getUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User[] users;
        EditUserTable dt = new EditUserTable();
        int i;
        String json;
        try (PrintWriter out = response.getWriter()) {
            try {
                users = dt.databaseToUsers().toArray(new User[0]);
                if (users == null) {
                    response.setStatus(403);
                } else {
                    for(i=0;i<users.length;i++){
                        json = dt.UserToJSON(users[i]);
                        System.out.println(i);
                        System.out.println(json);
                        out.println(json);
                    }
                }
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
