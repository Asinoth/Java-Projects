package mainClasses;

public class appointmentInfo {
    String brand, hospital_name, date_time;
    int dose_num;

    public int getDose_num() {
        return dose_num;
    }

    public String getBrand() {
        return brand;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public void setDose_num(int dose_num) {
        this.dose_num = dose_num;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }
}
