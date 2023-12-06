/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainClasses;

/**
 *
 * @author Mike
 */
public class Randevouz {
    int randevouz_id,user_id,hosp_id,done,dose_id;
    String date_time;

    public int getRandevouz_id() {
        return randevouz_id;
    }

    public void setRandevouz_id(int randevouz_id) {
        this.randevouz_id = randevouz_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getHosp_id(){
        return (this.hosp_id);
    }

    public void setHosp_id(int nid){
        this.hosp_id = nid;
    }

    public int getDone(){
        return (this.done);
    } // check if appointment done or canceled

    public void setDone(int d){
        this.done = d;
    }

    public int getDose_id(){
        return (this.dose_id);
    } // check if appointment done or canceled

    public void setDose_id(int d){
        this.dose_id = d;
    }



}
