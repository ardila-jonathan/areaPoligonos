
package ejercicio;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    static ArrayList<Poligono> poligono = new ArrayList<Poligono>();
    static Scanner entrada = new Scanner(System.in); 
    
    public static void main(String[] args) {
        
        llenarPoligono();
        mostrarResultados();
        
        
    }
    public static void llenarPoligono(){
        int option;
        char respuesta;
        
        do{
            do {                
            System.out.println("Digite el tipo de poligono ");
            System.out.println("1-Triangulo");
            System.out.println("2-Rectangulo");
            System.out.println("Option: ");
            option = entrada.nextInt();   
            } while (option<1 || option>2 );
            
            switch(option){
                
                case 1: llenarTiangulo();
                    break;
                
                case 2: llenarRectangulo();
                    break;
                
                
            }
            
            System.out.println("desea introducir otro poligono? digite s o n");
            respuesta = entrada.next().charAt(0);
            System.out.println(" ");
            
        }while(respuesta=='s' || respuesta=='S');
        
        
    }
    
    public static void llenarTiangulo(){
        double lado1,lado2,lado3;
        
        System.out.println("\nDigite el lado 1 del triangulo ");
        lado1 = entrada.nextDouble();
        System.out.println("\nDigite el lado 2 del triangulo ");
        lado2 = entrada.nextDouble();
        System.out.println("\nDigite el lado 3 del triangulo ");
        lado3 = entrada.nextDouble();
        
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        poligono.add(triangulo);
    }
    
    public static void llenarRectangulo(){
        
        double lado1,lado2;
        
        System.out.println("\nDigite el lado 1 del rectangulo ");
        lado1 = entrada.nextDouble();
        System.out.println("\nDigite el lado 2 del rectangulo ");
        lado2 = entrada.nextDouble();
        
        Rectangulo rectangulo = new Rectangulo(lado1, lado2);
        poligono.add(rectangulo);
        
    }
    
    public static void mostrarResultados(){
        
        for(Poligono poli: poligono){
            
            System.out.println(poli.toString());
            System.out.println("Area-> "+poli.area());
            System.out.println(" ");
        }
        
    }
}
