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
    
    public static void guardarContactos (String vnombres[],int vnumeros[]){
        
        Scanner leer = new Scanner(System.in);
        int posicion = buscarHueco(vnombres);
        
        if(posicion == -1){
            System.out.println("No hay hueco disponible");
        }else{
            System.out.println("Introduzca el nombre del contacto que desea guardar");
            vnombres[posicion] = leer.nextLine();
            
            System.out.println("Introduzca el número del contacto que desea guardar");
            vnumeros[posicion] = leer.nextInt();
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
                    bandera = false;
                    break;
                case 1:
                    guardarContactos(vnombres,vnumeros);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
               
        }while(bandera);
    }
    
}
