package db.tables;

import com.google.gson.Gson;
import db.DB_Connection;
import mainClasses.Certificate;
import mainClasses.Randevouz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditCertificateTable {
    public void createCertificateTable() throws SQLException, ClassNotFoundException {

        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        String query = "CREATE TABLE certificates"
                + "(cert_id INTEGER not NULL AUTO_INCREMENT, "
                + "    brand VARCHAR(10) not null,"
                + "    exp_date DATE not null,"
                + "    issue_date DATE not null,"
                + "    user_id INTEGER not NULL,"
                + "FOREIGN KEY (user_id) REFERENCES users(user_id), "
                + " PRIMARY KEY ( cert_id))";
        stmt.execute(query);
        stmt.close();
    }

    public Certificate certFromUserId(String id) throws SQLException, ClassNotFoundException {
        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM certificates WHERE user_id= '" + id + "'");
            rs.next();
            String json=DB_Connection.getResultsToJSON(rs);
            Gson gson = new Gson();
            Certificate cert = gson.fromJson(json, Certificate.class);
            return cert;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String certificateToJSON(Certificate r) {
        Gson gson = new Gson();

        String json = gson.toJson(r, Certificate.class);
        return json;
    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addCertificateDoctor(Certificate doc) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " certificates(brand,exp_date,issue_date,user_id)"
                    + " VALUES ("
                    + "'" + doc.getBrand() + "',"
                    + "'" + doc.getExp_date() + "',"
                    + "'" + doc.getIssue_date() + "',"
                    + "'" + doc.getUser_id() + "'"
                    + ")";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The Certificate was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditCertificateTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
