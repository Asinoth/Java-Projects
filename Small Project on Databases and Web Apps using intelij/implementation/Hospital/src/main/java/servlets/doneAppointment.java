package servlets;

import db.tables.EditCertificateTable;
import db.tables.EditDoseTable;
import db.tables.EditRandevouzTable;
import mainClasses.Certificate;
import mainClasses.Dose;
import mainClasses.Randevouz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "doneAppointment", value = "/doneAppointment")
public class doneAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("randevouz_id");
        System.out.println(id);
        EditRandevouzTable rt = new EditRandevouzTable();
        EditDoseTable edt = new EditDoseTable();
        EditCertificateTable ect = new EditCertificateTable();
        Certificate cert = new Certificate();
        try {
            rt.doneRandevouz(id);
            Randevouz rand = rt.randFromId(id);
            Dose d = edt.doseFromId(rand.getDose_id());
            System.out.println("hello");
            System.out.println(d.getDose_num());
            if(d.getDose_num() == 2){
                cert.setBrand(d.getBrand());
                cert.setIssue_date(rand.getDate_time());
                cert.setExp_date("2022-12-31");
                cert.setUser_id(rand.getUser_id());
                ect.addCertificateDoctor(cert);
            }

            response.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
