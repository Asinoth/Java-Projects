package servlets;

import db.tables.EditRandevouzTable;
import mainClasses.Randevouz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "getAvailableRandevouz", value = "/getAvailableRandevouz")
public class getAvailableRandevouz extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id=request.getParameter("hosp_id");
        String date=request.getParameter("date");
        String hour = request.getParameter("hour");
        EditRandevouzTable rt = new EditRandevouzTable();
        Randevouz[] r;
        System.out.println(id);
        try (PrintWriter out = response.getWriter()) {
            try {
                r = rt.getAvailableRandevouzs(id,date,hour).toArray(new Randevouz[0]);
                if (r == null) {
                    response.setStatus(403);
                } else {
                    out.println(r.length);
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
