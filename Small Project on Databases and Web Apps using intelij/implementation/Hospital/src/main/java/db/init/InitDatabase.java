/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.init;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import static db.DB_Connection.getInitialConnection;

import db.tables.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mainClasses.*;

/**
 *
 * @author micha
 */
public class InitDatabase {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        InitDatabase init = new InitDatabase();
        init.initDatabase();
        init.initTables();
        init.addToDatabaseExamples();
    }

    public void initDatabase() throws SQLException, ClassNotFoundException {
        Connection conn = getInitialConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE DATABASE HY351");
        stmt.close();
        conn.close();
    }

    public void initTables() throws SQLException, ClassNotFoundException {
        EditUserTable eut = new EditUserTable();
        eut.createUserTable();

        EditAdminTable eat = new EditAdminTable();
        eat.createAdminTable();

        EditHospitalTable eht = new EditHospitalTable();
        eht.createHospitalTable();

        EditDoseTable edst = new EditDoseTable();
        edst.createDoseTable();

        EditRandevouzTable er = new EditRandevouzTable();
        er.createRandevouzTable();

        EditNotificationTable ent = new EditNotificationTable();
        ent.createNotificationTable();

        EditCertificateTable ect = new EditCertificateTable();
        ect.createCertificateTable();

        EditMedicalStaffTable nt = new EditMedicalStaffTable();
        nt.createMedicalStaffTable();
    }

    public void addToDatabaseExamples() throws ClassNotFoundException {
        //Users
        String userJSON = "{\"username\":\"chrrepou\",\"email\":\"chr.repou@gmail.com\",\"password\":\"christi123*\","
                + "\"firstname\":\"Christina\",\"lastname\":\"Repou\",\"birthdate\":\"2000-08-24\","
                + "\"amka\":\"24080001241\",\"telephone\":\"1234567890\","
                + "\"postal_code\":\"38445\"}";
        EditUserTable eut = new EditUserTable();
        eut.addUserFromJSON(userJSON);

        String admin = "{\"username\":\"admin\",\"email\":\"admin@admin.gr\","
                + "\"password\":\"admin12*\"}";
        EditAdminTable at = new EditAdminTable();
        at.addAdminFromJSON(admin);

        Hospital hosp1 = new Hospital();
        hosp1.setPostal_code(38222);
        hosp1.setStreet_num(134);
        hosp1.setTelephone("2421351804");
        hosp1.setHospname("Nosokomeio Bolou");
        hosp1.setStreet_name("Polymeri");
        hosp1.setCountry("Greece");

        Hospital hosp2 = new Hospital();
        hosp2.setPostal_code(71500);
        hosp2.setStreet_num(10);
        hosp2.setTelephone("2813402111");
        hosp2.setHospname("PAGNI");
        hosp2.setStreet_name("Panepistimiou");
        hosp2.setCountry("Greece");

        EditHospitalTable eht = new EditHospitalTable();
        eht.addHospitalDoctor(hosp1);
        eht.addHospitalDoctor(hosp2);

        //Dose
        Dose d = new Dose();
        d.setBrand("pfizer");
        d.setDate("2022-05-20");
        d.setUser_id(1);
        d.setDose_num(1);
        EditDoseTable edt = new EditDoseTable();
        edt.addDoseDoctor(d);

        //Randevouz
        Randevouz rand = new Randevouz();
        rand.setDose_id(1);
        rand.setDone(0);
        rand.setHosp_id(2);
        rand.setUser_id(1);
        rand.setDate_time("2022-05-20 15:00:00");
//        String randevouzJSON = "{\"date_time\":\"2022-05-20 15:00:00\","
//                + "\"us_id\":\"1\","
//                + "\"hosp_id\":\"2\","
//                + "\"status\":\"0\","
//                + "\"dose_id\":\"1\"}";
        EditRandevouzTable er = new EditRandevouzTable();
        er.createNewRandevouz(rand);
//        er.addRandevouzFromJSON(randevouzJSON);
//
//        //Treatment
//        EditTreatmentTable ert = new EditTreatmentTable();
//        String trjson = "{\"doctor_id\":\"1\",\"user_id\":\"1\",\"start_date\":\"2021-10-26\","
//                + "\"end_date\":\"2021-11-09\","
//                + "\"treatment_text\":\"Xapia gia xolisterini 3 fores ti mera\","
//                + "\"bloodtest_id\":\"1\"}";
//
//        ert.addTreatmentFromJSON(trjson);
//
//        //Message
//        EditNotificationTable ett = new EditNotificationTable();
//        String msgjson = "{\"doctor_id\":\"1\",\"user_id\":\"1\",\"date_time\":\"2021-10-11 15:11:00\","
//                + "\"message\":\"Den eimai kala\","
//                + "\"sender\":\"user\"}";
//
//        ett.addMessageFromJSON(msgjson);
//
    }

//    public void databaseToJSON() throws ClassNotFoundException, SQLException {
//        //Users
//        EditUserTable eut = new EditUserTable();
//        User su = eut.databaseToUser("mountanton", "123456");
//        String json = eut.UserToJSON(su);
//        System.out.println("User\n" + json + "\n");
//
//        //Doctors
//        EditDoctorTable edt = new EditDoctorTable();
//        ArrayList<Doctor> doctors = edt.databaseToDoctors();
//        Gson gson = new Gson();
//        JsonArray jsonDoc = gson.toJsonTree(doctors).getAsJsonArray();
//        System.out.println("Doctors\n" + jsonDoc + "\n");
//
//        //Blood Test
//        EditBloodTestTable ebt = new EditBloodTestTable();
//        BloodTest bt = ebt.databaseToBloodTest("03069200000", "2021-10-11");
//        String jsonBT = ebt.bloodTestToJSON(bt);
//        System.out.println("BloodTest\n" + jsonBT + "\n");
//
//        //Randevouz
//        EditRandevouzTable er = new EditRandevouzTable();
//        Randevouz r = er.databaseToRandevouz(1);
//        String jsonRand = er.randevouzToJSON(r);
//        System.out.println("Randevouz\n" + jsonRand + "\n");
//
//        //Message
//        EditNotificationTable emt = new EditNotificationTable();
//        Message msg = emt.databaseToMessage(1);
//        String jsonmsg = emt.messageToJSON(msg);
//        System.out.println("Message\n" + jsonmsg + "\n");
//
//        //Treatment
//        EditTreatmentTable ett = new EditTreatmentTable();
//        Treatment tr = ett.databaseToTreatment(1);
//        String jsontr = ett.treatmentToJSON(tr);
//        System.out.println("Treatment\n" + jsontr + "\n");
//    }
//
//    public void updateRecords() throws ClassNotFoundException, SQLException {
//        EditUserTable es = new EditUserTable();
//        es.updateUser("mountanton", 85.0);
//
//        EditDoctorTable edt = new EditDoctorTable();
//        edt.updateDoctor("mountanton", 190);
//
//        EditBloodTestTable ebt = new EditBloodTestTable();
//        ebt.updateBloodTest(1, 180);
//
//        EditRandevouzTable er = new EditRandevouzTable();
//        er.updateRandevouz(1, 1, "Provlima Me vitamini", "selected");
//    }
//
//    public void deleteRecords() throws ClassNotFoundException, SQLException {
//        EditRandevouzTable er = new EditRandevouzTable();
//        er.deleteRandevouz(1);
//
//        EditBloodTestTable eb = new EditBloodTestTable();
//        eb.deleteBloodTest(1);
//    }
}
