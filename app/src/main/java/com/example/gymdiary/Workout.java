package com.example.gymdiary;

public class Workout {

    private int rep,serie,poid;
    private String Machine;

    public Workout(){

    }

    public Workout(int rep,int serie,int poid,String machine){
        this.Machine = machine;
        this.rep = rep;
        this.serie = serie;
        this.poid = poid;
    }

    public int getPoid() {
        return poid;
    }

    public int getRep() {
        return rep;
    }

    public int getSerie() {
        return serie;
    }

    public String getMachine() {
        return Machine;
    }

    public void setMachine(String machine) {
        Machine = machine;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
}

