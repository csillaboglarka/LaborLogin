package com.example.laborlogin;
public class Hobbie {

    public static final String COLUMN_ID="id";
    public static final String DATABASE_NAME = "hobbies.db";
    public static final String TABLE_NAME = "hobbies_table";
    public static final String COL1 = "NAME";

    private int id;
    private String hobbie;

    public static final String CREATE_TABLE=
            "CREATE TABLE" + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL1 + " TEXT,"
                    +  ")";
    public Hobbie()
    {

    }

    public  Hobbie(int id,String hobbie)
    {
        this.id=id;
        this.hobbie=hobbie;
    }
    public  Hobbie(String hobbie)
    {

        this.hobbie=hobbie;
    }

    public int getId()
    {
        return id;
    }

    public String getHobbie()
    {
        return hobbie;
    }

    public void setHobbie(String hobbie)
    {
        this.hobbie=hobbie;
    }

    public void setId(int id) {
        this.id=id;
    }



}