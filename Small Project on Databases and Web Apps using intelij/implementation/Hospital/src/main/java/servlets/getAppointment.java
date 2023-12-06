package servlets;

import db.tables.EditRandevouzTable;
import mainClasses.Randevouz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getAppointment", value = "/getAppointment")
public class getAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("hosp_id");
        String date=request.getParameter("date");
        EditRandevouzTable rt = new EditRandevouzTable();
        Randevouz[] r;
        int i;
        String json;
        System.out.println(id);
        try (PrintWriter out = response.getWriter()) {
            try {
                r = rt.databaseToRandevouzs(id,date).toArray(new Randevouz[0]);
                if (r == null) {
                    response.setStatus(403);
                } else {
                    for(i=0;i<r.length;i++){
                        json = rt.randevouzToJSON(r[i]);
                        System.out.println(i);
                        System.out.println("Randevouzs");
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
