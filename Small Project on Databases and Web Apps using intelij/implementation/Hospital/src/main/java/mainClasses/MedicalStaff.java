package mainClasses;

public class MedicalStaff extends User{
    int ms_id, hosp_id;
    public int getMs_id(){
        return (this.ms_id);
    }

    public void setMs_id(int nid){
        this.ms_id = nid;
    }

    public int getHosp_id(){
        return (this.hosp_id);
    }

    public void setHosp_id(int nid){
        this.hosp_id = nid;
    }
}
