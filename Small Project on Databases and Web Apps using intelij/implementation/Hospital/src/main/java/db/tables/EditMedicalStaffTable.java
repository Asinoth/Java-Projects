package db.tables;

import com.google.gson.Gson;
import db.DB_Connection;
import mainClasses.Doctor;
import mainClasses.MedicalStaff;
import mainClasses.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditMedicalStaffTable {
    public void createMedicalStaffTable() throws SQLException, ClassNotFoundException {

        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        String query = "CREATE TABLE MedicalStaff"
                + "(ms_id INTEGER not NULL AUTO_INCREMENT, "
                + "    username VARCHAR(30) not null unique,"
                + "    email VARCHAR(40) not null unique,	"
                + "    password VARCHAR(32) not null,"
                + "    firstname VARCHAR(20) not null,"
                + "    lastname VARCHAR(30) not null,"
                + "    birthdate DATE not null,"
                + "    amka VARCHAR (11) not null,"
                + "    telephone VARCHAR(14) not null,"
                + "    postal_code INTEGER not null,"
                + "    hosp_id INTEGER not null,"
                + "FOREIGN KEY (hosp_id) REFERENCES hospitals (hosp_id), "
                + " PRIMARY KEY ( ms_id))";
        stmt.execute(query);
        stmt.close();
    }

    public MedicalStaff databaseToMedicalStaff(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM MedicalStaff WHERE username = '" + username + "' AND password='" + password + "'");
            rs.next();
            String json = DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            MedicalStaff doc = gson.fromJson(json, MedicalStaff.class);
            return doc;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String MedicalStaffToJSON(MedicalStaff doc) {
        Gson gson = new Gson();

        String json = gson.toJson(doc, MedicalStaff.class);
        return json;
    }

    public void editMedicalStaff(MedicalStaff su) throws SQLException, ClassNotFoundException{
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();
        String update="UPDATE medicalstaff SET email='"+su.getEmail()+
                "', password='"+ su.getPassword()+
                "', firstname='"+ su.getFirstname()+
                "', lastname='"+ su.getLastname()+
                "', birthdate='"+ su.getBirthdate()+
                "', telephone='"+ su.getTelephone()+
                "', postal_code='"+ su.getPostal_code()+
                "', hosp_id='"+ su.getHosp_id()+
                "'WHERE username = '"+su.getUsername()+"'";
        stmt.executeUpdate(update);
    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addMedicalStaff(MedicalStaff doc) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " MedicalStaff (username,email,password,firstname,lastname,birthdate,amka,telephone,postal_code,hosp_id)"
                    + " VALUES ("
                    + "'" + doc.getUsername() + "',"
                    + "'" + doc.getEmail() + "',"
                    + "'" + doc.getPassword() + "',"
                    + "'" + doc.getFirstname() + "',"
                    + "'" + doc.getLastname() + "',"
                    + "'" + doc.getBirthdate() + "',"
                    + "'" + doc.getAmka() + "',"
                    + "'" + doc.getTelephone() + "',"
                    + "'" + doc.getPostal_code() + "',"
                    + "'" + doc.getHosp_id() + "'"
                    + ")";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The MedicalStaff was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditMedicalStaffTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
