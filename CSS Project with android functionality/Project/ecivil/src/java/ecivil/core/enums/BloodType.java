package ecivil.core.enums;

public enum BloodType {

    O_PLUS("O+"), A_PLUS("A+"), B_PLUS("B+"), AB_PLUS("AB+"), O_MINUS("O-"), A_MINUS("A-"), B_MINUS("B-"), AB_MINUS("AB-"), UNKNOWN("Unknown");
    private String value;

    private BloodType(String value) {
        this.value = value;
    }

    public static BloodType ReturnBloodType(String blood){
        if(blood.equals("O+")){
            return O_PLUS;
        }
        else if(blood.equals("A+")){
            return A_PLUS;
        }
        else if(blood.equals("B+")){
            return B_PLUS;
        }
        else if(blood.equals("AB+")){
            return AB_PLUS;
        }
        else if(blood.equals("O-")){
            return O_MINUS;
        }
        else if(blood.equals("A-")){
            return A_MINUS;
        }
        else if(blood.equals("B-")){
            return B_MINUS;
        }
        else if(blood.equals("AB-")){
            return AB_MINUS;
        }else{
            return UNKNOWN;
        }
    }
    
    public void setBloodType(String value){
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}
