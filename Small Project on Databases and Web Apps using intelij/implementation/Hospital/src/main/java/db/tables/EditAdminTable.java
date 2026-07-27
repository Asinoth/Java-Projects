package db.tables;

import com.google.gson.Gson;
import db.DB_Connection;
import mainClasses.Admin;
import mainClasses.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditAdminTable {
    public void createAdminTable() throws SQLException, ClassNotFoundException {

        Connection con = DB_Connection.getConnection();
        Statement stmt = con.createStatement();

        String query = "CREATE TABLE admins"
                + "(admin_id INTEGER not NULL AUTO_INCREMENT, "
                + "    username VARCHAR(30) not null unique,"
                + "    password VARCHAR(32) not null,"
                + " PRIMARY KEY ( admin_id))";
        stmt.execute(query);
        stmt.close();
    }

    public void addAdminFromJSON(String json) throws ClassNotFoundException{
        Admin user=jsonToAdmin(json);
        addAdmin(user);
    }

    public Admin jsonToAdmin(String json){
        Gson gson = new Gson();

        Admin user = gson.fromJson(json, Admin.class);
        return user;
    }

    /**
     * Establish a database connection and add in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addAdmin(Admin doc) throws ClassNotFoundException {
        try {
            Connection con = DB_Connection.getConnection();

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " admins (username,password)"
                    + " VALUES ("
                    + "'" + doc.getUsername() + "',"
                    + "'" + doc.getPassword() + "'"
                    + ")";
            //stmt.execute(table);
            System.out.println(insertQuery);
            stmt.executeUpdate(insertQuery);
            System.out.println("# The admin was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(EditAdminTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
