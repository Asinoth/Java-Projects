package mainClasses;

public class Notification {
    String user_email, user_tel,date_time,message;
    int not_id;

    public String getDate_time(){
        return (this.date_time);
    }

    public void setDate_time(String dt){
        this.date_time = dt;
    }

    public String getUser_email(){
        return (this.user_email);
    }

    public void setUser_email(String ue){
        this.user_email = ue;
    }

    public String getUser_tel(){
        return (this.user_tel);
    }

    public void setUser_tel(String ut){
        this.user_tel = ut;
    }

    public String getMessage(){
        return (this.message);
    }

    public void setMessage(String m){
        this.message = m;
    }

    public int getNot_id(){
        return (this.not_id);
    }

    public void setNot_id(int id){
        this.not_id = id;
    }
}
