/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

import com.google.gson.Gson;
import db.DB_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import mainClasses.Notification;

/**
 *
 * @author micha
 */
public class EditNotificationTable {


    public void addNotificationFromJSON(String json) throws ClassNotFoundException{
        Notification msg=jsonToNotification(json);
        createNewNotification(msg);
    }

    public Notification jsonToNotification(String json) {
        Gson gson = new Gson();
        Notification msg = gson.fromJson(json, Notification.class);
        return msg;
    }

    public String NotificationToJSON(Notification msg) {
        Gson gson = new Gson();

        String json = gson.toJson(msg, Notification.class);
        return json;
    }



    public Notification databaseToNotification(int id) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM Notification WHERE Notification_id= '" + id + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Notification bt = gson.fromJson(json, Notification.class);
            return bt;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void createNotificationTable() throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE Notification "
                + "(not_id INTEGER not NULL AUTO_INCREMENT, "
                + "date_time TIMESTAMP not NULL, "
                + "message VARCHAR(1000) not NULL, "
                + "user_email VARCHAR(20) not NULL, "
                + "user_tel VARCHAR(10) not NULL, "
                + "user_id INTEGER not NULL, "
                + "FOREIGN KEY (user_id) REFERENCES users(user_id), "
                + "PRIMARY KEY (not_id ))";
        stmt.execute(sql);
        stmt.close();
        con.close();

    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void createNewNotification(Notification msg) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " Notification (date_time,message,user_email,user_tel) "
                    + " VALUES ("
                    + "'" + msg.getDate_time() + "',"
                    + "'" + msg.getMessage() + "',"
                    + "'" + msg.getUser_email() + "',"
                    + "'" + msg.getUser_tel() + "'"
                    + ")";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The notification was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditNotificationTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //my code
    public ArrayList<Notification> getNotifications(int doctor_id,String username) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();
        ArrayList<Notification> Notifications =new ArrayList<Notification>();
        ResultSet rs,rs2;
        int user_id;
        try {
            rs2 = stmt2.executeQuery("SELECT user_id FROM users WHERE username='"+username+"'");
            rs2.next();
            String json2 = DB_Connection.getResultsToJSON(rs2);
            user_id = Integer.parseInt(json2.substring(12,json2.length()-2));
            System.out.println(user_id);
            rs = stmt.executeQuery("SELECT * FROM Notification WHERE doctor_id= '" + doctor_id + "' AND user_id='"+ user_id + "'" );
            while (rs.next()) {
                String json = DB_Connection.getResultsToJSON(rs);
                Gson gson = new Gson();
                Notification ms = gson.fromJson(json, Notification.class);
                Notifications.add(ms);
            }
            return Notifications;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void shown(String user_id,String doctor_id) throws  SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String update="UPDATE Notification SET doc_shown='1' WHERE user_id='"+user_id+"' AND doctor_id='" + doctor_id + "'";
        stmt.executeUpdate(update);
    }
}
