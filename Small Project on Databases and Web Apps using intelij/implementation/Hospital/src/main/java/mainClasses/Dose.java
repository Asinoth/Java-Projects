package mainClasses;

public class Dose {
    int dose_id;
    String date;
    int dose_num,user_id; //eg. 1st, 2nd

    String brand;

    public int getUser_id(){ return (this.user_id);}
    public void setUser_id(int uid){this.user_id = uid;}
    public int getDose_id(){
        return (this.dose_id);
    }

    public void setDose_id(int id){
        this.dose_id = id;
    }

    public  String getDate(){
        return (this.date);
    }

    public void setDate(String dt){
        this.date = dt;
    }

    public int getDose_num(){
        return (this.dose_num);
    }

    public  void setDose_num(int tp){
        this.dose_num = tp;
    }

    public String getBrand(){
        return (this.brand);
    }

    public void setBrand(String b){
        this.brand = b;
    }
}
