package com.example.numrandom;

import java.sql.Array;
import java.util.ArrayList;

public class Record {

    private String userName;
    private int points;

    public Record(String userName, int points){
        this.userName = userName;
        this.points = points;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }

}
