package mainClasses;

public class Certificate {
    String brand, exp_date, issue_date;
    int cert_id,user_id;

    public int getCert_id(){
        return(this.cert_id);
    }

    public void setCert_id(int id){this.cert_id = id;}

    public String getBrand(){
        return (this.brand);
    }

    public void setBrand(String b){
        this.brand = b;
    }

    public String getExp_date(){
        return (this.exp_date);
    }

    public void setExp_date(String exp){
        this.exp_date = exp;
    }

    public String getIssue_date(){
        return (this.issue_date);
    }

    public void setIssue_date(String issue){
        this.issue_date = issue;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
