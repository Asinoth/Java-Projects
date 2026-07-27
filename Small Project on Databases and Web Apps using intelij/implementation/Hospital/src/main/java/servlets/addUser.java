package servlets;

import db.tables.EditMedicalStaffTable;
import db.tables.EditUserTable;
import mainClasses.MedicalStaff;
import mainClasses.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "addUser", value = "/addUser")
public class addUser extends HttpServlet {

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
        String postal_code = request.getParameter("postal_code");

            /* TODO output your page here. You may use following sample code. */
        User u1 = new User();


        try (PrintWriter out = response.getWriter()) {
            u1.setAmka(amka);
            u1.setBirthdate(birthdate);
            u1.setFirstname(firstname);
            u1.setEmail(email);
            u1.setLastname(lastname);
            u1.setUsername(username);
            u1.setPassword(password);
            u1.setTelephone(telephone);
            u1.setPostal_code(Integer.parseInt(postal_code));


            try {
                    EditUserTable eut = new EditUserTable();
                    String json = eut.UserToJSON(u1);
                    out.println(json);
                    eut.addNewUser(u1);

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
