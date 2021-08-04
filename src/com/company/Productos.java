package com.company;

public class Productos {

    //Atributos

    private int codigo;
    private int pcompra;
    private int pventa;
    private int cbodega;
    private int cminbodega;
    private boolean iva;

    //Constructor
    public Productos(){}

    public Productos(int codigo,int pcompra,int pventa,int cbodega , int cminbodega,boolean iva) {
        this.codigo = codigo;
        this.pcompra = pcompra;
        this.pventa = pventa;
        this.cbodega = cbodega;
        this.cminbodega = cminbodega;
        this.iva = iva;
    }

    //Metodos

    public String toString(){
        String str = "Codigo: "+this.codigo+"\nPrecio Compra: "+this.pcompra+"\nPrecio Venta: "+this.pventa+"\nCantidad Bodega: "+this.cbodega+"\nCantidad Minima Bodega: "+this.cminbodega+"\nIva: "+this.iva;
        return str;
    }


    //Get Y Set

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPcompra() {
        return pcompra;
    }

    public void setPcompra(int pcompra) {
        this.pcompra = pcompra;
    }

    public int getPventa() {
        return pventa;
    }

    public void setPventa(int pventa) {
        this.pventa = pventa;
    }

    public int getCbodega() {
        return cbodega;
    }

    public void setCbodega(int cbodega) {
        this.cbodega = cbodega;
    }

    public int getCminbodega() {
        return cminbodega;
    }

    public void setCminbodega(int cminbodega) {
        this.cminbodega = cminbodega;
    }

    public boolean isIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }
}
