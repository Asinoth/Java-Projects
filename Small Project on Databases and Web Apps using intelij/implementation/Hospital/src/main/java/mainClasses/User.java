package mainClasses;

/**
 *
 * @author Mike
 */
public class User {
    String username,email,password,firstname,lastname,birthdate,amka,telephone;
    int postal_code, user_id;


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



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthDate) {
        this.birthdate = birthDate;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public int getPostal_code(){return (this.postal_code);}

    public void setPostal_code(int pc){ this.postal_code = pc;}

    public int getUser_id(){
        return(this.user_id);
    }

    public void setUser_id(int id){
        this.user_id = id;
    }

}
