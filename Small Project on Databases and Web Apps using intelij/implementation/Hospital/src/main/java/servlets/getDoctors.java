package servlets;

import db.tables.EditDoctorTable;
import mainClasses.Doctor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getDoctors", value = "/getDoctors")
public class getDoctors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Doctor[] docs;
        EditDoctorTable dt = new EditDoctorTable();
        int i;
        String json;
        try (PrintWriter out = response.getWriter()) {
            try {
                docs = dt.databaseToDoctor().toArray(new Doctor[0]);
                if (docs == null) {
                    response.setStatus(403);
                } else {
                    for(i=0;i<docs.length;i++){
                        json = dt.doctorToJSON(docs[i]);
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
