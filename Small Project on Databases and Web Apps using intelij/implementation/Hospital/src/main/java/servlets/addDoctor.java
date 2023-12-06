package servlets;

import db.tables.EditDoctorTable;
import mainClasses.Doctor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "addDoctor", value = "/addDoctor")
public class addDoctor extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        System.out.println("username: "+ username);
        String email = request.getParameter("email");
        String password=request.getParameter("password");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String birthdate=request.getParameter("birthdate");
        String amka=request.getParameter("amka");
        String telephone=request.getParameter("telephone");
        String specialty = request.getParameter("specialty");

        EditDoctorTable dt = new EditDoctorTable();
        Doctor doc = new Doctor();
        try (PrintWriter out = response.getWriter()) {
            doc.setSpecialty(specialty);
            doc.setAmka(amka);
            doc.setBirthdate(birthdate);
            doc.setFirstname(firstname);
            doc.setEmail(email);
            doc.setLastname(lastname);
            doc.setUsername(username);
            doc.setPassword(password);
            doc.setTelephone(telephone);

            try {
                String json = dt.doctorToJSON(doc);
                out.println(json);
                dt.addNewDoctor(doc);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            response.setStatus(200);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
