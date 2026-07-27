package servlets;

import db.tables.EditDoseTable;
import db.tables.EditRandevouzTable;
import mainClasses.Dose;
import mainClasses.Randevouz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet(name = "newAppointment", value = "/newAppointment")
public class newAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Randevouz rand = new Randevouz();
        EditRandevouzTable rt = new EditRandevouzTable();
        int user_id = Integer.parseInt(request.getParameter("us_id"));
        String time1 = request.getParameter("time1");
        String time2 = String.valueOf((Integer.parseInt(request.getParameter("time2"))-1));
        String date = request.getParameter("date");
        String hosp_id = request.getParameter("hosp_id");
        System.out.println("new appointment");
        Random objGenerator = new Random();
        int randomNumber = objGenerator.nextInt(12);
        ArrayList<String> times = new ArrayList<String>();
        String tm[] = {time1,time2};
        for(int i=0;i<2;i++){
            times.add(tm[i]+":10:00");
            times.add(tm[i]+":20:00");
            times.add(tm[i]+":30:00");
            times.add(tm[i]+":40:00");
            times.add(tm[i]+":50:00");
        }
        String final_time = times.get(randomNumber);
        EditDoseTable edt = new EditDoseTable();
        Integer dose_num = -1;
        try {
             dose_num = edt.nextDose(user_id)+1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Dose d = new Dose();
        d.setDose_num(dose_num);
        d.setBrand("pfizer");
        d.setDate(date);
        d.setUser_id(user_id);
        try {
            edt.addDoseDoctor(d);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Integer dose_id = -1;
        try {
            d = edt.doseId(user_id,date);
            dose_id = d.getDose_id();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user_id + " "+ final_time + " "+ hosp_id + " "+ date + " "+dose_id);
        String date_time = date + " "+ final_time;
        rand.setDate_time(date_time);
        rand.setUser_id(user_id);
        rand.setHosp_id(Integer.parseInt(hosp_id));
        rand.setDone(0);
        rand.setDose_id(dose_id);
        try {
            rt.createNewRandevouz(rand);
            response.setStatus(200);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
