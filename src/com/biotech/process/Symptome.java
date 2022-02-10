package com.biotech.process;

public class Symptome {
    private String name;
    private int count;

    public Symptome(String name){
        this.name = name;
        this.count = 1;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public void addCount(){
        count++;
    }
}
