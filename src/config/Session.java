/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author JOSH
 */
public class Session {
   
    private static Session instance;
    private int uid;   
    private String fnam;
    private String lnam;
    private String uemail;
    private String usernam;
    private String typ; 
    private String stat;

 private Session(){
   //private constructor prevents instance
   }
    public static synchronized Session getInstance() {
       if(instance == null){
       instance = new Session();
       }
       return instance;
    }

    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    

    public String getFnam() {
        return fnam;
    }

    public void setFnam(String fnam) {
        this.fnam = fnam;
    }

    public String getLnam() {
        return lnam;
    }

    public void setLnam(String lnam) {
        this.lnam = lnam;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUsernam() {
        return usernam;
    }

    public void setUsernam(String usernam) {
        this.usernam = usernam;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
