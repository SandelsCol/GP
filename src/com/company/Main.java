package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Programa creado por Santiago Del Valle

    public static void main(String[] args) {

        //Scanner
        Scanner p = new Scanner(System.in);
        String space;

        //Estructuras de datos
        ArrayList<Cliente> data = new ArrayList<>();
        ArrayList<Productos> subdata = new ArrayList<>();
        ArrayList<factura> pedidosconfirmados = new ArrayList<>();
        ArrayList<factura> pedidosrechazados = new ArrayList<>();

        //Main
        System.out.println("GESTION DE PEDIDOS");
        while(true){
            try{
                System.out.println("MENU PRINCIPAL");
                System.out.println("1/Administración de clientes\n2/Administración de productos\n3/Administración de pedidos\n4/Ver Pedidos\n0/Salir");
                byte des = Byte.parseByte(p.nextLine());
                switch (des){
                    case 1 :
                        //Clientes
                        boolean ss = true;
                        do{
                            System.out.println("MENU CLIENTES");
                            System.out.println("1/Agregar clientes\n2/Eliminar clientes\n3/Editar clientes\n4/Buscar clientes\n5/Listar clientes\n0/Menu Principal");
                            byte user = Byte.parseByte(p.nextLine());
                            switch (user){
                                case 1 :
                                    //Entrada de datos
                                    System.out.println("Digite Identificación");
                                    int identificacion = Integer.parseInt(p.nextLine());
                                    System.out.println("Digite Nombre");
                                    String nombre = p.nextLine();
                                    //Se verifica si el nombre existe o no dentro de la data
                                    for(Cliente u : data){
                                        if(u.getNombre().equals(nombre.toLowerCase())){
                                            String aux="";
                                            do{
                                                System.out.println("Ese nombre ya esta duplicado en la base de datos , Por favor elegir otro");
                                                aux = p.nextLine();
                                                nombre = aux;
                                            }while (u.getNombre().equals(nombre.toLowerCase()));
                                        }
                                    }
                                    System.out.println("Digite Dirreción");
                                    String ruta = p.nextLine();
                                    System.out.println("Digite Telefono");
                                    int telefono = Integer.parseInt(p.nextLine());
                                    System.out.println("Digite Celular");
                                    int celular = Integer.parseInt(p.nextLine());
                                    System.out.println("Digite Correo");
                                    String correo = p.nextLine();

                                    //Creacion y almacenamiento del objeto
                                    Cliente objeto = new Cliente(identificacion,nombre.toLowerCase(),ruta,telefono,celular,correo);
                                    data.add(objeto);
                                    System.out.println("Space para continuar");
                                    space = p.nextLine();
                                    break;

                                case 2 :
                                    System.out.println("¿Cuál cliente desea borrar?");
                                    String nombre_borrar = p.nextLine();
                                    boolean comp = false;
                                    for(Cliente u : data){
                                        if(u.getNombre().equals(nombre_borrar.toLowerCase())){
                                            data.remove(u);
                                            comp = true;
                                            break;
                                        }
                                    }
                                    if(comp == true){
                                        System.out.println("Se han aplicado los cambios\nSpace para continuar");
                                        space = p.nextLine();

                                    }else {
                                        System.out.println("El nombre del cliente no esta en la base de datos\nSpace para continuar");
                                        space = p.nextLine();
                                    }
                                    break;

                                case 3 :
                                    //Editor de objetos por parametro
                                    System.out.println("¿Cuál cliente desea editar?");
                                    String nombre_editar = p.nextLine();
                                    for(Cliente u : data){
                                        if(u.getNombre().equals(nombre_editar.toLowerCase())){
                                            System.out.println("¿Qué parametro quiere cambiar del cliente?\n1/Identificación\n2/Nombre\n3/Dirreción\n4/Telefono\n5/Celular\n6/Correo");
                                            try{
                                                byte desname = Byte.parseByte(p.nextLine());
                                                switch (desname){
                                                    case 1:
                                                        System.out.println("Digite Identificación");
                                                        int inde = Integer.parseInt(p.nextLine());
                                                        u.setIdentificación(inde);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 2:
                                                        System.out.println("Digite Nombre");
                                                        String nam = p.nextLine();
                                                        u.setNombre(nam);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 3:
                                                        System.out.println("Digite Ruta");
                                                        String rut = p.nextLine();
                                                        u.setDirección(rut);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 4:
                                                        System.out.println("Digite Telefono");
                                                        int tel = Integer.parseInt(p.nextLine());
                                                        u.setTeléfono(tel);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 5:
                                                        System.out.println("Digite Celular");
                                                        int cel = Integer.parseInt(p.nextLine());
                                                        u.setCelular(cel);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 6:
                                                        System.out.println("Digite Correo Electronico");
                                                        String corr = p.nextLine();
                                                        u.setCorreo_electrónico(corr);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                }
                                            }catch (Exception e){
                                                System.out.println(e);
                                            }
                                        }
                                    }
                                    break;
                                case 4 :
                                    System.out.println("Digite el ID del cliente: ");
                                    int rid = Integer.parseInt(p.nextLine());
                                    for(Cliente u : data){
                                        if(u.getIdentificación() == rid){
                                            System.out.println(u.toString());
                                            if(u.getCuentas().isEmpty()){
                                                System.out.println("El usuario no tiene cuentas");
                                                System.out.println("¿Desea agregar una cuenta? (1 Si / Otro No)");
                                                byte xd = Byte.parseByte(p.nextLine());
                                                if(xd==1){
                                                    u.aggaccount();
                                                }
                                                System.out.println("Space para continuar");
                                                space = p.nextLine();
                                            }else {
                                                System.out.println("Estas son las cuentas disponibles: ");
                                                u.ShowCuentas();
                                                System.out.println("¿Desea agregar otra cuenta? (1 Si / Otro No)");
                                                byte xd = Byte.parseByte(p.nextLine());
                                                if(xd==1){
                                                    u.aggaccount();
                                                }
                                                System.out.println("Space para continuar");
                                                space = p.nextLine();
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                case 5 :
                                    for(Cliente u : data){
                                        System.out.println(u.getNombre());
                                    }
                                    System.out.println("Space para continuar");
                                    space = p.nextLine();
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu principal...");
                                    ss = false;
                                    break;
                                default:
                                    System.out.println("Esa opción no esta disponible");
                            }
                        }while (ss==true);
                        break;

                    case 2 :
                        //ADMINISTRACIÓN DE PRODUCTOS
                        boolean sx = true;
                        do{
                            System.out.println("MENU PRODUCTOS");
                            System.out.println("1/Agregar productos\n2/Eliminar productos\n3/Editar productos\n4/Buscar productos\n5/Listar productos\n0/Menu Principal");
                            byte product = Byte.parseByte(p.nextLine());
                            switch (product){
                                case 1:
                                    System.out.println("Digite Codigo");
                                    int codigo = Integer.parseInt(p.nextLine());
                                    for(Productos u : subdata){
                                        if(u.getCodigo() == codigo){
                                            do{
                                                System.out.println("Ese nombre ya esta duplicado en la base de datos , Por favor elegir otro");
                                                codigo = Integer.parseInt(p.nextLine());
                                            }while (u.getCodigo() == codigo);
                                        }
                                    }
                                    System.out.println("Digite Precio Compra");
                                    int pcompra = Integer.parseInt(p.nextLine());
                                    System.out.println("Digite Precio Venta");
                                    int pventa = Integer.parseInt(p.nextLine());
                                    System.out.println("Digite Cantidad Bodega");
                                    int cabodega = Integer.parseInt(p.nextLine());
                                    System.out.println("Digite Cantidad Minima Bodega");
                                    int caminbodega = Integer.parseInt(p.nextLine());

                                    Productos object = new Productos(codigo,pcompra,pventa,cabodega,caminbodega,true);
                                    subdata.add(object);
                                    break;
                                case 2:
                                    System.out.println("¿Cuál producto desea borrar?");
                                    int coddelete = Integer.parseInt(p.nextLine());
                                    boolean comp = false;
                                    for(Productos u : subdata){
                                        if(u.getCodigo() == coddelete){
                                            subdata.remove(u);
                                            comp = true;
                                            break;
                                        }
                                    }
                                    if(comp == true){
                                        System.out.println("Se han aplicado los cambios\nSpace para continuar");
                                        space = p.nextLine();

                                    }else {
                                        System.out.println("El codigo del producto no esta en la base de datos\nSpace para continuar");
                                        space = p.nextLine();
                                    }
                                    break;
                                case 3:
                                    System.out.println("¿Cuál producto desea editar?");
                                    int cod = Integer.parseInt(p.nextLine());
                                    for(Productos u : subdata){
                                        if(u.getCodigo()==cod){
                                            System.out.println("¿Qué parametro quiere cambiar del producto?\n1/Codigo\n2/Precio de compra\n3/Precio de venta\n4/Cantidad bodega\n5/Cantidad minima bodega\n6/iva");
                                            try{
                                                byte slo = Byte.parseByte(p.nextLine());
                                                switch (slo){
                                                    case 1:
                                                        System.out.println("Digite Codigo");
                                                        int inde = Integer.parseInt(p.nextLine());
                                                        u.setCodigo(inde);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 2:
                                                        System.out.println("Digite Precio De Compra");
                                                        int pbuy = Integer.parseInt(p.nextLine());
                                                        u.setPcompra(pbuy);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 3:
                                                        System.out.println("Digite Precio De Venta");
                                                        int psell = Integer.parseInt(p.nextLine());
                                                        u.setPventa(psell);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 4:
                                                        System.out.println("Digite Cantidad Bodega");
                                                        int cbod = Integer.parseInt(p.nextLine());
                                                        if(cbod<u.getCminbodega()){
                                                            do{
                                                                System.out.println("La cantidad estipulada es menor que la cantidad minima establecida, digite otra cantidad");
                                                                cbod = Integer.parseInt(p.nextLine());
                                                            }while (cbod<u.getCminbodega());
                                                        }
                                                        u.setCbodega(cbod);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 5:
                                                        System.out.println("Digite Cantidad Minima Bodega");
                                                        int cminbodega = Integer.parseInt(p.nextLine());
                                                        if(cminbodega <= 0){
                                                            u.setCminbodega(0);
                                                        }else {
                                                            u.setCminbodega(cminbodega);
                                                        }
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                    case 6:
                                                        System.out.println("Digite Si tiene Iva");
                                                        boolean ll = Boolean.parseBoolean(p.nextLine());
                                                        u.setIva(ll);
                                                        System.out.println("Space para continuar");
                                                        space = p.nextLine();
                                                        break;
                                                }
                                            }catch (Exception e){
                                                System.out.println(e);
                                            }
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Digite código para buscar un producto");
                                    int pp = Integer.parseInt(p.nextLine());
                                    for(Productos u : subdata){
                                        if(u.getCodigo()==pp){
                                            System.out.println(u.toString());
                                            System.out.println("Space para continuar");
                                            space = p.nextLine();
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.println("Listado de codigos");
                                    int mayor = 0;
                                    int aux;
                                    int ccs=0;
                                    for(Productos u : subdata){
                                        System.out.println(u.getCodigo());
                                        aux = u.getCbodega();
                                        if(aux > mayor){
                                            mayor = aux;
                                            ccs = u.getCodigo();
                                        }
                                    }
                                    System.out.println("Ademas...el producto con mayor unidades es: "+ccs+" con un total de "+mayor+" unidades");
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu principal...");
                                    sx = false;
                                    break;
                            }
                        }while (sx == true);
                        break;
                    case 3:
                        //ADMINISTRACIÓN DE PEDIDOS
                        boolean gg = false;
                        do{
                            //Ingreso de productos
                            System.out.println("Bienvenido al menu de compra / venta de productos");
                            try{
                                System.out.println("Ingrese el nombre del cliente");
                                String cc = p.nextLine();
                                for(Cliente u : data){
                                    if(u.getNombre().equals(cc.toLowerCase())){
                                        if(u.IsCuenta()!=true){
                                            System.out.println("Digite el ID de la cuenta deseada");
                                            int hj = Integer.parseInt(p.nextLine());
                                            for(Cuenta k : u.getCuentas()){
                                                if(k.getId()==hj){
                                                    System.out.println("¿Cuantos productos desea comprar? (Max 20 / Min 1)");
                                                    byte cant = Byte.parseByte(p.nextLine());
                                                    double precio_iva = 0;
                                                    double precio_Noiva = 0;
                                                    if(cant > 0 && cant<=20){
                                                        for(int i = 1 ; i <= cant ; i++){
                                                            System.out.println("Digite el código del producto "+i);
                                                            int cprodu = Integer.parseInt(p.nextLine());
                                                            for(Productos x : subdata){
                                                                if(x.getCodigo()==cprodu){
                                                                    double Iva = x.getPventa()+(x.getPventa()*0.19);
                                                                    double NoIva =x.getPventa();
                                                                    if(x.getCbodega() < x.getCminbodega()){
                                                                        System.out.println("El producto no puede bajar de su cantidad minima bódega");
                                                                        factura objfalse = new factura(cc,0,0,1);
                                                                        pedidosrechazados.add(objfalse);
                                                                    }else {
                                                                        if(k.getDinero()>=x.getPventa()){
                                                                            precio_iva = Iva + precio_iva;
                                                                            precio_Noiva = NoIva + precio_Noiva;
                                                                            k.setDinero(k.getDinero()-precio_Noiva);
                                                                            x.setCbodega(x.getCbodega()-1);
                                                                        }else {
                                                                            System.out.println("El usuario no tiene suficiente dinero para comprar este producto");
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        factura objnice = new factura(cc,precio_Noiva,precio_iva,cant);
                                                        pedidosconfirmados.add(objnice);
                                                    }else {
                                                        System.out.println("Número de productos invalidos");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }catch (Exception e){
                                System.out.println("No existe ningún producto");
                            }

                            //Salir del menu
                            System.out.println("¿Desea continuar? (1 SI / 2 NO)");
                            byte xzx = Byte.parseByte(p.nextLine());
                            if(xzx==1){
                                gg = true;
                            }else {
                                gg = false;
                            }
                        }while (gg == true);
                        break;
                    case 4:
                        System.out.println("Pedidos Confirmados: ");
                        for(factura u : pedidosconfirmados){
                            System.out.println(u.infofacturas());
                        }
                        System.out.println("Pedidos Rechazados: ");
                        for(factura u : pedidosrechazados){
                            System.out.println(u.infofacturas());
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        System.exit(0);
                    default:
                        System.out.println("Opción Invalida");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}