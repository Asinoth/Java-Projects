package db.tables;

import com.google.gson.Gson;
import db.DB_Connection;
import mainClasses.Dose;
import mainClasses.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditDoseTable {
    public void addDoseFromJSON(String json) throws ClassNotFoundException{
        Dose user=jsonToDose(json);
        addDoseDoctor(user);
    }

    public Dose jsonToDose(String json){
        Gson gson = new Gson();

        Dose user = gson.fromJson(json, Dose.class);
        return user;
    }

    public String DoseToJSON(Dose user){
        Gson gson = new Gson();

        String json = gson.toJson(user, Dose.class);
        return json;
    }
    public void createDoseTable() throws SQLException, ClassNotFoundException {

        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        String query = "CREATE TABLE doses"
                + "(dose_id INTEGER not NULL AUTO_INCREMENT, "
                + "    dose_date DATE not null,"
                + "    dose_num INTEGER not null,"
                + "    brand VARCHAR(10) not null,"
                + "    user_id INTEGER not NULL, "
                + "FOREIGN KEY (user_id) REFERENCES users(user_id), "
                + " PRIMARY KEY ( dose_id))";
        stmt.execute(query);
        stmt.close();
    }

    public Dose doseFromId(Integer id) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM doses WHERE dose_id = '" + id + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Dose user = gson.fromJson(json, Dose.class);
            return user;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public int nextDose(Integer user_id) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM doses WHERE user_id = '" + user_id + "'");
            int counter = 0;
            while (rs.next()) {
                counter++;
            }
            return counter;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public Dose doseId(Integer user_id, String date) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM doses WHERE user_id = '" + user_id + "' and dose_date = '"+date + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Dose user = gson.fromJson(json, Dose.class);
            return user;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addDoseDoctor(Dose doc) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " Doses (dose_date,dose_num,brand,user_id)"
                    + " VALUES ("
                    + "'" + doc.getDate() + "',"
                    + "'" + doc.getDose_num() + "',"
                    + "'" + doc.getBrand() + "',"
                    + "'" + doc.getUser_id() + "'"
                    + ")";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The Dose was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditDoseTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
