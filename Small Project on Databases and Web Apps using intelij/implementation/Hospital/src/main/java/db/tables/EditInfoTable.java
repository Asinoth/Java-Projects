package db.tables;

import com.google.gson.Gson;
import mainClasses.Randevouz;
import mainClasses.appointmentInfo;

public class EditInfoTable {
    public String infoToJSON(appointmentInfo r) {
        Gson gson = new Gson();

        String json = gson.toJson(r, appointmentInfo.class);
        return json;
    }
}
