package com.company;

public class factura {

    //Atributos
    private String user;
    private double total;
    private double totalIVA;
    private int cant;

    //constructor
    public factura(){}
    public factura(String user,double total ,double totalIVA, int cant){
        this.total = total;
        this.cant = cant;
        this.user = user;
        this.totalIVA = totalIVA;
    }

    //Metodos
    public String infofacturas(){
        String base = "Usuario: "+this.user+"\nTotal IVA: "+this.totalIVA+"\nTotal Sin Iva: "+ this.total +"\nCantidad:" + this.cant;
        return base;
    }
}
