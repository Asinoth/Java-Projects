/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

import com.google.gson.Gson;
import mainClasses.Randevouz;
import db.DB_Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mike
 */
public class EditRandevouzTable {


    public void addRandevouzFromJSON(String json) throws ClassNotFoundException{
        Randevouz r=jsonToRandevouz(json);
        createNewRandevouz(r);
    }


    public Randevouz databaseToRandevouz(int id) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM randevouz WHERE randevouz_id= '" + id + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Randevouz bt = gson.fromJson(json, Randevouz.class);
            return bt;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void deleteRandevouz(String id,String date) throws  SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String update="UPDATE randevouz SET status='cancelled' WHERE randevouz_id='"+id+"'";
        stmt.executeUpdate(update);
        update = "UPDATE randevouz SET date_time='"+date+"' WHERE randevouz_id='"+id+"'";
        stmt.executeUpdate(update);
    }

    public void doneRandevouz(String id) throws  SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String update="UPDATE randevouz SET done='1' WHERE randevouz_id='"+id+"'";
        stmt.executeUpdate(update);
    }

    public ArrayList<Randevouz> databaseToRandevouzs(String id,String date)throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        ArrayList<Randevouz> rand = new ArrayList<Randevouz>();
        ResultSet rs;
        System.out.println("id: "+id);
        try {
            rs = stmt.executeQuery("SELECT * FROM randevouz WHERE hosp_id='"+id+"'"+"AND date_time LIKE '"+date+"%'");
            while (rs.next()) {
                String json = DB_Connection.getResultsToJSON(rs);
                Gson gson = new Gson();
                Randevouz r = gson.fromJson(json, Randevouz.class);
                rand.add(r);
                System.out.println(r.getUser_id());
            }
            return rand;

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Randevouz> getAvailableRandevouzs(String hosp_id,String date, String hour)throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        ArrayList<Randevouz> rand = new ArrayList<Randevouz>();
        ResultSet rs;
        System.out.println("hosp_id: "+hosp_id);
        try {
            String dt1 = "'"+date+" "+hour+":00:00'";
            System.out.println(dt1);
            String dt2 = "'"+date+" "+(Integer.parseInt(hour)+2)+":00:00'";
            String query = "SELECT * \n" +
                    "FROM randevouz WHERE hosp_id = "+hosp_id+" AND date_time between " + dt1 +" and " + dt2;
            rs = stmt.executeQuery(query);
            System.out.println(query);
            while (rs.next()) {
                String json = DB_Connection.getResultsToJSON(rs);
                Gson gson = new Gson();
                Randevouz r = gson.fromJson(json, Randevouz.class);
                rand.add(r);
                System.out.println(r.getUser_id());
            }
            return rand;

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }


    public Randevouz getCurrRand(String id) throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM randevouz WHERE user_id= '" + id + "'and done= '0'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Randevouz bt = gson.fromJson(json, Randevouz.class);
            return bt;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Randevouz randFromId(String id) throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM randevouz WHERE randevouz_id= '" + id + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Randevouz bt = gson.fromJson(json, Randevouz.class);
            return bt;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Randevouz jsonToRandevouz(String json) {
        Gson gson = new Gson();
        Randevouz r = gson.fromJson(json, Randevouz.class);
        return r;
    }


    public String randevouzToJSON(Randevouz r) {
        Gson gson = new Gson();

        String json = gson.toJson(r, Randevouz.class);
        return json;
    }

    public void deleteRandevouz(int randevouzID) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String deleteQuery = "DELETE FROM randevouz WHERE randevouz_id='" + randevouzID + "'";
        stmt.executeUpdate(deleteQuery);
        stmt.close();
        con.close();
    }



    public void createRandevouzTable() throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE randevouz "
                + "(randevouz_id INTEGER not NULL AUTO_INCREMENT, "
                + " date_time TIMESTAMP not NULL, "
                + " user_id INTEGER not NULL, "
                + " hosp_id INTEGER not NULL, "
                + " done INTEGER not NULL, "
                + " dose_id INTEGER not NULL, "
                + "FOREIGN KEY (user_id) REFERENCES users (user_id), "
                + "FOREIGN KEY (hosp_id) REFERENCES hospitals (hosp_id), "
                + "FOREIGN KEY (dose_id) REFERENCES doses (dose_id), "
                + "PRIMARY KEY ( randevouz_id  ))";
        stmt.execute(sql);
        stmt.close();
        con.close();

    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void createNewRandevouz(Randevouz rand) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " randevouz (date_time,user_id,hosp_id,done,dose_id)"
                    + " VALUES ("
                    + "'" + rand.getDate_time() + "',"
                    + "'" + rand.getUser_id() + "',"
                    + "'" + rand.getHosp_id() + "',"
                    + "'" + rand.getDone() + "',"
                    + "'" + rand.getDose_id() + "'"
                    + ")";
            //stmt.execute(table);

            stmt.executeUpdate(insertQuery);
            System.out.println("# The randevouz was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditRandevouzTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

