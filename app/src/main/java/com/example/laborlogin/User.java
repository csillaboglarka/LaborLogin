package com.example.laborlogin;

import java.util.List;

public class User {
    protected String email;
    protected String birthday;

    /*
    public static final String TABLE_NAME = "Hobbies";

    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_BIRTH = "birth";
    public static final String COLUMN_HOBBY = "hobby";





    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_EMAIL + " TEXT,"
                    + COLUMN_BIRTH + " TEXT,"
                    + COLUMN_HOBBY + " TEXT"
                    + ")";
    */

   public User (String semail,String sbirthday) {
        this.email =semail;
        this.birthday = sbirthday;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }
}
