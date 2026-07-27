package ecivil.core.enums;

public enum Gender {

    MALE("male"), FEMALE("female"), NEITHER("neither"), BOTH("both");
    private String value;

    private Gender(String value) {
        this.value = value;
    }
    
    public void setSex(String value){
        this.value=value;
        
    }
    
    /**
     *
     * @param value
     * @return
     */
    public static Gender returnSex(String value){
        if("male".equals(value)){
            return MALE;
        }
        else if("female".equals(value)){
            return FEMALE;
        }
        else if("both".equals(value)){
            return BOTH;
        }
        else{
            return NEITHER;
        }
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
