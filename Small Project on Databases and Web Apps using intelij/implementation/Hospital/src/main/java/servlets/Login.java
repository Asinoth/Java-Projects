package servlets;

import db.tables.EditAdminTable;
import db.tables.EditMedicalStaffTable;
import db.tables.EditUserTable;
import mainClasses.Doctor;
import mainClasses.MedicalStaff;
import mainClasses.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        EditUserTable eut = new EditUserTable();
        EditMedicalStaffTable nt = new EditMedicalStaffTable();
        EditAdminTable at = new EditAdminTable();
        User su = null;
        Doctor doc = null;
        MedicalStaff nu = null;

        try {
            if(session.getAttribute("loggedIn") == null){
                su = eut.databaseToUser(username, password);
                nu = nt.databaseToMedicalStaff(username, password);
            }else {
                su = eut.databaseToUser((String) session.getAttribute("loggedIn"),(String) session.getAttribute("pass"));
                nu = nt.databaseToMedicalStaff((String) session.getAttribute("loggedIn"),(String) session.getAttribute("pass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = response.getWriter()) {
            if (session.getAttribute("loggedIn") == null) {

                /* TODO output your page here. You may use following sample code. */
                if (su == null && doc == null && nu == null) {
                    response.setStatus(403);
                } else {
                    String json = "";
                    if(su != null) {
                        json = eut.UserToJSON(su);
                    } else {
                        json = nt.MedicalStaffToJSON(nu);
                    }
                    out.println(json);
                    session = request.getSession(true);
                    session.setAttribute("loggedIn", username);
                    session.setAttribute("pass", password);
                    response.setStatus(200);
                }
            }else {
                String json = "";
                if(su != null) {
                    json = eut.UserToJSON(su);
                } else {
                    json = nt.MedicalStaffToJSON(nu);
                }
                System.out.println(json);
                out.println(json);
                response.setStatus(200);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
