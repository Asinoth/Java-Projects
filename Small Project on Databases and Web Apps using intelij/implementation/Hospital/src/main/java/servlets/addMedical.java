package servlets;

import db.tables.EditMedicalStaffTable;
import mainClasses.MedicalStaff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addMedical", value = "/addMedical")
public class addMedical extends HttpServlet {
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
        String postal_code = request.getParameter("postal_code");
        String hosp_id = request.getParameter("hosp");

        MedicalStaff u2 = new MedicalStaff();

        try (PrintWriter out = response.getWriter()) {
            u2.setAmka(amka);
            u2.setBirthdate(birthdate);
            u2.setFirstname(firstname);
            u2.setEmail(email);
            u2.setLastname(lastname);
            u2.setUsername(username);
            u2.setPassword(password);
            u2.setTelephone(telephone);
            u2.setPostal_code(Integer.parseInt(postal_code));
            u2.setHosp_id(Integer.parseInt(hosp_id));
            try {
                System.out.println("heloooo");
                EditMedicalStaffTable mst = new EditMedicalStaffTable();
                String json = mst.MedicalStaffToJSON(u2);
                out.println(json);
                mst.addMedicalStaff(u2);
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        response.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
