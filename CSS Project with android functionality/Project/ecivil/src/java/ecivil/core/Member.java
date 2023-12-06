package ecivil.core;

import ecivil.core.enums.BloodType;
import ecivil.core.enums.Gender;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Member {

    private int id; // (auto-generated) (primary key)
    private String email; // (unique)
    private String password; // (must be encrypted in md5)
    private String firstname;
    private String lastname; 
    private String birthDate; // (format: yyyy-MM-dddd)
    private String telMobile; // (unique)
    private String telHome;
    private Gender gender;
    private String country;
    private String city;
    private String job;
    private String address;
    private boolean hasDrivingLicenceCar;
    private boolean hasDrivingLicenceBike;
    private boolean hasDrivingLicenceTruck;
    private boolean hasDrivingLicenceBoat;
    private boolean hasCar;
    private boolean hasBike;
    private boolean hasTruck;
    private boolean hasBoat;
    private BloodType bloodType;
    private String certificates;
    private String volunteerTeamID;
    private boolean volunteerDesire;
    private String photoPath;
    private String info;
    private String facebook;
    private String skype;
    private String gmail;

    public Member(int gid,String gsex,String gemail,String gpwd,String gmobilenum,String ghomenum,String gname,String gsurname,String gCountry,String gtown,String gjob,String ghomeaddress,    String gblood,String gmoreinfo,String pic,String gcertifications,String gvolunteer,String gorganization,String gvolunteerwant,String gbday,    String carlicen,String boatlicen,String bikelicen,String trucklicen,    String cartrans,String boattrans,String biketrans,String trucktrans,    String gfacebook,String gskype,String ggmail,String gphoto) {
        this.id=gid; // (auto-generated) (primary key)
        this.email=gemail;
        this.password=gpwd;
        this.firstname=gname;
        this.lastname=gsurname;
        this.birthDate=gbday;
        this.telMobile=gmobilenum;
        this.telHome=ghomenum;
        this.gender=Gender.returnSex(gsex);        
        this.country=gCountry;
        this.city=gtown;
        this.job=gjob;
        this.address=ghomeaddress;
        this.bloodType=BloodType.ReturnBloodType(gblood);
        this.bloodType.setBloodType(gblood);
        this.certificates=gcertifications;
        this.photoPath=gphoto;
        this.info=gmoreinfo;
        this.facebook=gfacebook;
        this.skype=gskype;
        this.gmail=ggmail;
        //Licences
        if("Car".equals(carlicen)){
            this.hasDrivingLicenceCar=true;
        }else{
            this.hasDrivingLicenceCar=false;
        }
        if("Boat".equals(boatlicen)){
            this.hasDrivingLicenceBoat=true;
        }else{
            this.hasDrivingLicenceBoat=false;
        }
        if("Bike".equals(bikelicen)){
            this.hasDrivingLicenceBike=true;
        }else{
            this.hasDrivingLicenceBike=false;
        }
        if("Truck".equals(trucklicen)){
            this.hasDrivingLicenceTruck=true;
        }else{
            this.hasDrivingLicenceTruck=false;
        }
        //Transportation
        if("Car".equals(cartrans)){
            this.hasCar=true;
        }else{
            this.hasCar=false;
        }
        if("Boat".equals(boattrans)){
            this.hasBoat=true;
        }else{
            this.hasBoat=false;
        }
        if("Bike".equals(biketrans)){
            this.hasBike=true;
        }else{
            this.hasBike=false;
        }
        if("Truck".equals(trucktrans)){
            this.hasTruck=true;
        }else{
            this.hasTruck=false;
        }
        this.volunteerTeamID=gorganization;
        if(gvolunteerwant!=null){
            this.volunteerDesire=true;
        }
        else{
            this.volunteerDesire=false;
        }
    }

    /**
     * Establish a database connection and add the member in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addInDatabase() throws ClassNotFoundException {

        try {

            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " MEMBER (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, BIRTHDATE, TEL_MOBILE, TEL_HOME, GENDER, COUNTRY, CITY, JOB, ADDRESS, HAS_DRIVING_LICENCE_CAR, HAS_DRIVING_LICENCE_BIKE, HAS_DRIVING_LICENCE_TRUCK, HAS_DRIVING_LICENCE_BOAT, HAS_CAR, HAS_BIKE, HAS_TRUCK, HAS_BOAT, BLOOD_TYPE, CERTIFICATES, VOLUNTEER_TEAM_ID, VOLUNTEER_DESIRE, PHOTO_PATH, INFO, FACEBOOK, SKYPE, GMAIL) "
                    + " VALUES ("
                    + "'" + email + "',"
                    + "'" + password + "',"
                    + "'" + firstname + "',"
                    + "'" + lastname + "',"
                    + "'" + birthDate + "',"
                    + "'" + telMobile + "',"
                    + "'" + telHome + "',"
                    + "'" + gender + "',"
                    + "'" + country + "',"
                    + "'" + city + "',"
                    + "'" + job + "',"
                    + "'" + address + "',"
                    + "'" + hasDrivingLicenceCar + "',"
                    + "'" + hasDrivingLicenceBike + "',"
                    + "'" + hasDrivingLicenceTruck + "',"
                    + "'" + hasDrivingLicenceBoat + "',"
                    + "'" + hasCar + "',"
                    + "'" + hasBike + "',"
                    + "'" + hasTruck + "',"
                    + "'" + hasBoat + "',"
                    + "'" + bloodType + "',"
                    + "'" + certificates + "',"
                    + volunteerTeamID + ","
                    + "'" + volunteerDesire + "',"
                    + "'" + photoPath + "',"
                    + "'" + info + "',"
                    + "'" + facebook + "',"
                    + "'" + skype + "',"
                    + "'" + gmail + "'"
                    + ")";

            stmt.executeUpdate(insertQuery);
            System.out.println("# The member was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            String getIdQuery = "SELECT ID FROM MEMBER WHERE EMAIL = '" + email + "'";
            ResultSet result = stmt.executeQuery(getIdQuery);
            result.next();
            this.id = result.getInt("ID");
            System.out.println("# The ID of the new member is: " + this.id);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * An example of adding a new member in the database.
     *
     * @param args the command line arguments
     * @throws ClassNotFoundException
     */
    

    public void makeMember(int gid,String gsex,String gemail,String gpwd,String gmobilenum,String ghomenum,String gname,String gsurname,String gCountry,String gtown,String gjob,String ghomeaddress,    String gblood,String gmoreinfo,String pic,String gcertifications,String gvolunteer,String gorganization,String gvolunteerwant,String gbday,    String carlicen,String boatlicen,String bikelicen,String trucklicen,    String cartrans,String boattrans,String biketrans,String trucktrans,    String gfacebook,String gskype,String ggmail,String gphoto){
        this.id=gid; // (auto-generated) (primary key)
        this.email=gemail;
        this.password=gpwd;
        this.firstname=gname;
        this.lastname=gsurname;
        this.birthDate=gbday;
        this.telMobile=gmobilenum;
        this.telHome=ghomenum;
        this.gender.setSex(gsex);
        this.country=gCountry;
        this.city=gtown;
        this.job=gjob;
        this.address=ghomeaddress;
        this.bloodType.setBloodType(gblood);
        this.certificates=gcertifications;
        this.photoPath=gphoto;
        this.info=gmoreinfo;
        this.facebook=gfacebook;
        this.skype=gskype;
        this.gmail=ggmail;
        //Licences
        if("Car".equals(carlicen)){
            this.hasDrivingLicenceCar=true;
        }else{
            this.hasDrivingLicenceCar=false;
        }
        if("Boat".equals(boatlicen)){
            this.hasDrivingLicenceBoat=true;
        }else{
            this.hasDrivingLicenceBoat=false;
        }
        if("Bike".equals(bikelicen)){
            this.hasDrivingLicenceBike=true;
        }else{
            this.hasDrivingLicenceBike=false;
        }
        if("Truck".equals(trucklicen)){
            this.hasDrivingLicenceTruck=true;
        }else{
            this.hasDrivingLicenceTruck=false;
        }
        //Transportation
        if("Car".equals(cartrans)){
            this.hasCar=true;
        }else{
            this.hasCar=false;
        }
        if("Boat".equals(boattrans)){
            this.hasBoat=true;
        }else{
            this.hasBoat=false;
        }
        if("Bike".equals(biketrans)){
            this.hasBike=true;
        }else{
            this.hasBike=false;
        }
        if("Truck".equals(trucktrans)){
            this.hasTruck=true;
        }else{
            this.hasTruck=false;
        }
        this.volunteerTeamID=gorganization;
        if(gvolunteerwant!=null){
            this.volunteerDesire=true;
        }
        else{
            this.volunteerDesire=false;
        }
    }
    
    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHasDrivingLicenceCar() {
        return hasDrivingLicenceCar;
    }

    public void setHasDrivingLicenceCar(boolean hasDrivingLicenceCar) {
        this.hasDrivingLicenceCar = hasDrivingLicenceCar;
    }

    public boolean isHasDrivingLicenceBike() {
        return hasDrivingLicenceBike;
    }

    public void setHasDrivingLicenceBike(boolean hasDrivingLicenceBike) {
        this.hasDrivingLicenceBike = hasDrivingLicenceBike;
    }

    public boolean isHasDrivingLicenceTruck() {
        return hasDrivingLicenceTruck;
    }

    public void setHasDrivingLicenceTruck(boolean hasDrivingLicenceTruck) {
        this.hasDrivingLicenceTruck = hasDrivingLicenceTruck;
    }

    public boolean isHasDrivingLicenceBoat() {
        return hasDrivingLicenceBoat;
    }

    public void setHasDrivingLicenceBoat(boolean hasDrivingLicenceBoat) {
        this.hasDrivingLicenceBoat = hasDrivingLicenceBoat;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public boolean isHasBike() {
        return hasBike;
    }

    public void setHasBike(boolean hasBike) {
        this.hasBike = hasBike;
    }

    public boolean isHasTruck() {
        return hasTruck;
    }

    public void setHasTruck(boolean hasTruck) {
        this.hasTruck = hasTruck;
    }

    public boolean isHasBoat() {
        return hasBoat;
    }

    public void setHasBoat(boolean hasBoat) {
        this.hasBoat = hasBoat;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getVolunteerTeamID() {
        return volunteerTeamID;
    }

    public void setVolunteerTeamID(String volunteerTeamID) {
        this.volunteerTeamID = volunteerTeamID;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public boolean isVolunteerDesire() {
        return volunteerDesire;
    }

    public void setVolunteerDesire(boolean volunteerDesire) {
        this.volunteerDesire = volunteerDesire;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    
}
