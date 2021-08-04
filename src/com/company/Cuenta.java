package com.company;

public class Cuenta {

    //Atributos
    private double dinero;
    private String type;
    private int id;

    //Constructor
    public Cuenta(){}

    public Cuenta(double dinero, String type,int identificacion){
        this.id = identificacion;
        this.dinero = dinero;
        this.type = type;
    }

    //Metodos
    public boolean dinero(){
        if(this.dinero>0){
            return true;
        }else {
            return false;
        }
    }

    public String info(){
        String razor = "ID: "+ this.id + " Dinero: "+this.dinero+" Tipo: "+this.type;
        return razor;
    }


    //Get Y Set
    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
