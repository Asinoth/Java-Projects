package servlets;

import db.tables.EditCertificateTable;
import db.tables.EditRandevouzTable;
import mainClasses.Certificate;
import mainClasses.Randevouz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getCertificate", value = "/getCertificate")
public class getCertificate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("user_id");
        EditCertificateTable ect = new EditCertificateTable();
        Certificate cert;
        String json;
        System.out.println(id);
        try (PrintWriter out = response.getWriter()) {
            try {
                cert = ect.certFromUserId(id);
                if (cert == null) {
                    response.setStatus(403);
                } else {
                    json = ect.certificateToJSON(cert);
                    System.out.println(json);
                    out.println(json);
                    response.setStatus(200);
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
