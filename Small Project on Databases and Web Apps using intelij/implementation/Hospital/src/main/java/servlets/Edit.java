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

@WebServlet(name = "Edit", value = "/Edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String email = request.getParameter("email");
        String password=request.getParameter("password");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String birthdate=request.getParameter("birthdate");
        String postal_code=request.getParameter("postal_code");
        String telephone = request.getParameter("telephone");
        String amka=request.getParameter("amka");
        String type = request.getParameter("type");

        try (PrintWriter out = response.getWriter()) {
            EditUserTable eut = new EditUserTable();
            User user = new User();
            EditMedicalStaffTable emst = new EditMedicalStaffTable();
            MedicalStaff ms = new MedicalStaff();

            if(type.equals("ms")){
                ms.setBirthdate(birthdate);
                ms.setAmka(amka);
                ms.setFirstname(firstname);
                ms.setEmail(email);
                ms.setLastname(lastname);
                ms.setUsername(username);
                ms.setPassword(password);
                ms.setTelephone(telephone);
                ms.setPostal_code(Integer.parseInt(postal_code));
                emst.editMedicalStaff(ms);
                String js = emst.MedicalStaffToJSON(ms);
                out.println(js);
            }else {
                user.setBirthdate(birthdate);
                user.setAmka(amka);
                user.setFirstname(firstname);
                user.setEmail(email);
                user.setLastname(lastname);
                user.setUsername(username);
                user.setPassword(password);
                user.setTelephone(telephone);
                user.setPostal_code(Integer.parseInt(postal_code));
                eut.editUser(user);
                String json = eut.UserToJSON(user);
                out.println(json);
            }

            response.setStatus(200);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}