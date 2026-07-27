package mainClasses;

public class Hospital {
    int hosp_id,postal_code,street_num;
    String telephone, hospname, street_name, country;

    public int getPostal_code(){
        return (this.postal_code);
    }

    public void setPostal_code(int pc){
        this.postal_code = pc;
    }

    public int getHosp_id(){
        return (this.hosp_id);
    }

    public void setHosp_id(int id){
        this.hosp_id = id;
    }

    public int getStreet_num(){
        return (this.street_num);
    }

    public void setStreet_num(int num){
        this.street_num = num;
    }

    public String getTelephone(){
        return (this.telephone);
    }

    public void setTelephone(String tel){
        this.telephone = tel;
    }

    public String getHospname(){
        return (this.hospname);
    }

    public void setHospname(String name){
        this.hospname = name;
    }

    public String getStreet_name(){
        return (this.street_name);
    }

    public void setStreet_name(String sn){
        this.street_name = sn;
    }

    public String getCountry(){
        return (this.country);
    }

    public void setCountry(String c){
        this.country = c;
    }
}
