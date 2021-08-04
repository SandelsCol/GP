package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    //Atributos

    private int identificación;
    private String nombre;
    private String dirección;
    private int teléfono;
    private int celular;
    private ArrayList <Cuenta> cuentas = new ArrayList<>();
    private String correo_electrónico;
    public Scanner p = new Scanner(System.in);

    //Constructores

    public Cliente(){}

    public Cliente(int identificación,String nombre,String dirección,int teléfono,int celular,String correo_electrónico){
        this.identificación = identificación;
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
        this.celular = celular;
        this.correo_electrónico = correo_electrónico;
    }

    //Metodos
    public String toString(){
        String data = "Identificación: " + this.identificación + "\nNombre: "+this.nombre+"\nDirreción: " + this.dirección + "\nTelefono: "+this.teléfono +"\nCelular: "+this.celular+"\nCorreo: " + this.correo_electrónico;
        return data;
    }

    public void ShowCuentas(){
        for(Cuenta j : this.cuentas){
            System.out.println(j.info());
        }
    }

    public boolean IsCuenta(){
        if (this.cuentas.isEmpty() == true) {
            return true;
        }else {
            return false;
        }
    }

    public void aggaccount(){
        System.out.println("Cree el ID");
        int id = Integer.parseInt(p.nextLine());
        double dinerod = 0;
        do{
            System.out.println("Digite dinero disponible (No se permiten cantidades negativas)");
            dinerod = Double.parseDouble(p.nextLine());
        }while (dinerod<0);

        System.out.println("Digite si es de credito o debito");
        String tipo = p.nextLine();

        Cuenta nueva = new Cuenta(dinerod,tipo,id);
        this.cuentas.add(nueva);
    }

    //Getters y Setter
    public int getIdentificación() {
        return identificación;
    }

    public void setIdentificación(int identificación) {
        this.identificación = identificación;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public int getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(int teléfono) {
        this.teléfono = teléfono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo_electrónico() {
        return correo_electrónico;
    }

    public void setCorreo_electrónico(String correo_electrónico) {
        this.correo_electrónico = correo_electrónico;
    }

    public ArrayList<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
