package db.tables;

import com.google.gson.Gson;
import db.DB_Connection;
import mainClasses.Hospital;
import mainClasses.Randevouz;
import mainClasses.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditHospitalTable {
    public void createHospitalTable() throws SQLException, ClassNotFoundException {

        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        String query = "CREATE TABLE hospitals"
                + "(hosp_id INTEGER not NULL AUTO_INCREMENT, "
                + "    postal_code VARCHAR(5) not null,"
                + "    street_num INTEGER not null,"
                + "    telephone VARCHAR(10) not null unique,"
                + "    hospname VARCHAR(20) not null,"
                + "    street_name VARCHAR(20) not null,"
                + "    country VARCHAR(20) not null,"
                + " PRIMARY KEY ( hosp_id))";
        stmt.execute(query);
        stmt.close();
    }

    public Hospital getHospById(int id) throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM hospitals WHERE hosp_id= '" + id + "'");
            System.out.println("SELECT * FROM hospitals WHERE hosp_id= '" + id + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Hospital hosp = gson.fromJson(json, Hospital.class);
            return hosp;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addHospitalFromJSON(String json) throws ClassNotFoundException{
        Hospital hosp=jsonToHospital(json);
        addHospitalDoctor(hosp);
    }

    public Hospital jsonToHospital(String json){
        Gson gson = new Gson();

        Hospital user = gson.fromJson(json, Hospital.class);
        return user;
    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addHospitalDoctor(Hospital doc) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " Hospitals (postal_code,street_num,telephone,hospname,street_name,country)"
                    + " VALUES ("
                    + "'" + doc.getPostal_code() + "',"
                    + "'" + doc.getStreet_num() + "',"
                    + "'" + doc.getTelephone() + "',"
                    + "'" + doc.getHospname() + "',"
                    + "'" + doc.getStreet_name() + "',"
                    + "'" + doc.getCountry() + "'"
                    + ")";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The Hospital was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditHospitalTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
