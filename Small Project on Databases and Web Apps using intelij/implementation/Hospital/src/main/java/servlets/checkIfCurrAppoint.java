package servlets;

import db.tables.EditDoseTable;
import db.tables.EditHospitalTable;
import db.tables.EditInfoTable;
import db.tables.EditRandevouzTable;
import mainClasses.Dose;
import mainClasses.Randevouz;
import mainClasses.appointmentInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "checkIfCurrAppoint", value = "/checkIfCurrAppoint")
public class checkIfCurrAppoint extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("us_id");
        EditRandevouzTable rt = new EditRandevouzTable();
        EditHospitalTable eht = new EditHospitalTable();
        EditDoseTable edt = new EditDoseTable();
        EditInfoTable eit = new EditInfoTable();
        Randevouz r;
        String json;
        System.out.println(id);
        try (PrintWriter out = response.getWriter()) {
            try {
                r = rt.getCurrRand(id);
                if (r == null) {
                    response.setStatus(403);
                } else {
                    System.out.println(r.getHosp_id());
                    String hosp_name = eht.getHospById(r.getHosp_id()).getHospname();
                    System.out.println("hospital_name:"+ hosp_name);
                    Dose d = edt.doseFromId(r.getDose_id());
                    String brand = d.getBrand();
                    Integer dose_num = d.getDose_num();
                    appointmentInfo ap = new appointmentInfo();
                    ap.setBrand(brand);
                    ap.setDate_time(r.getDate_time());
                    ap.setDose_num(dose_num);
                    ap.setHospital_name(hosp_name);
                    json = eit.infoToJSON(ap);
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
