package listintelefonico;

import java.util.Scanner;

public class ListinTelefonico {
    
    public static int menu(){
        
        Scanner leer = new Scanner(System.in);
        int opcion = -1;
        
        while(opcion<0 || opcion>4){
            System.out.println("");
            System.out.println("MENÚ");
            System.out.println("0- Salir");
            System.out.println("1- Guardar contactos");
            System.out.println("2- Ver contactos");
            System.out.println("3- Eliminar contacto");
            System.out.println("4- Editar contacto");
            System.out.println("");
            System.out.println("Introduzca la opcion que desee realizar");
            opcion = leer.nextInt();
        }
        return opcion;
    }
    
    //Si devuelve -1, no ha encontrado una posición vacia
    public static int buscarHueco(String vnombres[]){
        
        int posicion = -1;
        
        for(int i = 0;i<vnombres.length;i++){
            if(vnombres[i] == null){
                posicion = i;
                i = vnombres.length + 1;
            }
        }
        return posicion;
    }
    
    //Si devuelve -1, no ha encontrado el contacto
    public static int buscarContacto(String vnombres[],String nombre){
        
        int posicion = -1;
        
        for(int i=0;i<vnombres.length;i++){
            if(vnombres[i].equals(nombre)){
                posicion = i;
                i = vnombres.length + 1;
            }
        }
        return posicion;
    }
    
    public static void editarContactos(String vnombres[],int vnumeros[]){
        //Apunte: Se debe crear más de un objeto de la clase Scanner
        //OJO: Si intentamos leer con uno solo, nos fallará
        //El objeto "leer" lo emplearemos para Strings
        //El objeto "leer1" lo emplearemos para Enteros
        Scanner leer = new Scanner(System.in);
        Scanner leer1 = new Scanner(System.in);
        int eleccion = -1, numero = -1, posicion = -1;
        String nombre = "";
        
        System.out.println("Introduzca el nombre del contacto que desea editar");
        nombre = leer.nextLine();
        
        posicion = buscarContacto(vnombres,nombre);
        
        if(posicion == -1){
            System.out.println("");
            System.out.println("Contacto no encontrado");
        }else{
            System.out.println("Introduzca el apartado que desee modificar:");
            System.out.println("1->Nombre  2->Tlf.  3->Todo");
            eleccion = leer1.nextInt();
        
            if(eleccion == 1){
                System.out.println("Ha marcado la opción 1: Introduzca el nuevo nombre del contacto");
                nombre = leer.nextLine();
            
                vnombres[posicion] = nombre;
                  
            }else if(eleccion == 2){
                System.out.println("Ha marcado la opción 2: Introduzca el nuevo número del contacto");
                numero = leer1.nextInt();
                
                vnumeros[posicion] = numero;
                
            }else if(eleccion == 3){
                System.out.println("Ha marcado la opción 3: Introduzca el nuevo nombre y número del contacto");
                nombre = leer.nextLine();
                numero = leer1.nextInt();
                
                vnombres[posicion] = nombre;
                vnumeros[posicion] = numero;
            }
            System.out.println("");
            System.out.println("OPCIÓN COMPLETADA");
        }
    }
    
    public static void eliminarContacto(String vnombres[],int vnumeros[]){
        Scanner leer = new Scanner(System.in);
        int posicion = -1;
        String nombre = "";
        
        System.out.println("");
        System.out.println("Introduzca el nombre del contacto que desea eliminar");
        nombre = leer.nextLine();
        
        posicion = buscarContacto(vnombres,nombre);
        
        if(posicion == -1){
            System.out.println("");
            System.out.println("Contacto no encontrado");
        }else{
            vnombres[posicion] = null;
            vnumeros[posicion] = -1;
            
            System.out.println("");
            System.out.println("CONTACTO ELIMINADO");
        }
    }
    
    public static void verContactos(String vnombres[],int vnumeros[]){
        //Apunte: Se debe crear más de un objeto de la clase Scanner
        //OJO: Si intentamos leer con uno solo, nos fallará
        //El objeto "leer" lo emplearemos para Strings
        //El objeto "leer1" lo emplearemos para Enteros
        Scanner leer = new Scanner(System.in);
        Scanner leer1 = new Scanner(System.in);
        int numero = 0;
        String nombre = "";
        
        System.out.println("Introduzca el apartado que desee realizar:");
        System.out.println("1->Ver Todos  2->Ver Contacto");
        numero = leer1.nextInt();
        
        if(numero == 1){
            for(int i=0;i<vnombres.length;i++){
                if(vnombres[i] != null){
                    System.out.println("");
                    System.out.println("Contacto " + i + ": " + vnombres[i] + "  " + vnumeros[i]);
                }
            }
        }else if(numero == 2){
            
            System.out.println("Introduzca el nombre del contacto que desea ver");
            nombre = leer.nextLine();
            
            if(buscarContacto(vnombres,nombre) == -1){
                System.out.println("");
                System.out.println("Contacto no encontrado");
            }else{
                System.out.println("");
                System.out.println("Contacto: " + vnombres[buscarContacto(vnombres,nombre)] + "  " + vnumeros[buscarContacto(vnombres,nombre)]);
            }
        }else{
            //Si el número no es ni 1 ni 2, sale del método
            System.out.println("");
            System.out.println("Opción errónea");
        }
    }
    
    public static void guardarContactos(String vnombres[],int vnumeros[]){
        
        Scanner leer = new Scanner(System.in);
        int i = 0;
        
        i = buscarHueco(vnombres);
        
        if (i == -1){
            System.out.println("");
            System.out.println("HUECO LLENO");
        }else{
            System.out.println("");
            System.out.println("HUECO VACÍO");
            System.out.println("");
            System.out.println("Introduzca el nombre del contacto que desea guardar");
            vnombres[i] = leer.nextLine();

            System.out.println("Introduzca el número del contacto que desea guardar");
            vnumeros[i] = leer.nextInt();
        }
    }

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        int tamaño;
        boolean bandera = true;
        
        System.out.println("Introduzca el número de contactos que quiere agregar, en un principio");
        tamaño = leer.nextInt();
        
        String vnombres[] = new String[tamaño];
        int vnumeros[] = new int[tamaño];
        
        do{
            switch(menu()){
                case 0:
                    System.out.println("");
                    System.out.println("¡Hasta luego!");
                    bandera = false;
                    break;
                case 1:
                    guardarContactos(vnombres,vnumeros);
                    break;
                case 2:
                    verContactos(vnombres,vnumeros);
                    break;
                case 3:
                    eliminarContacto(vnombres,vnumeros);
                    break;
                case 4:
                    editarContactos(vnombres,vnumeros);
                    break;
            }
               
        }while(bandera);
    }
    
}
