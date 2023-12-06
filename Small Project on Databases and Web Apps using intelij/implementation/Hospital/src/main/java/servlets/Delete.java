package servlets;

import db.tables.EditDoctorTable;
import db.tables.EditUserTable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String num=request.getParameter("num");
        EditUserTable sut = new EditUserTable();
        EditDoctorTable dt = new EditDoctorTable();
        try {
            System.out.println(Integer.parseInt(num));
            if ( Integer.parseInt(num) == 1) {
                System.out.println("hello!!");
                sut.deleteUser(username);
            }else{
                dt.deleteDoctor(username);
            }

            response.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
