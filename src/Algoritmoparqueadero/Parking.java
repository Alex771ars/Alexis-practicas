/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmoparqueadero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parking {
    
    public int Maxdispo;
    private List<Transporte> Vehiculosparking;
    
public Parking(int Maxdispo) {

    this.Maxdispo = Maxdispo;
    this.Vehiculosparking = new ArrayList<>();
}  
    
public boolean registrodevehiculo (Transporte transporte){
 
    if (Vehiculosparking.size()<Maxdispo){
        Vehiculosparking.add(transporte);
        System.out.println("El Vehiculo ha ingresado exitosamente.");
        return true;
    } else{
        System.out.println("No hay disponibilidad para parquear.");
        return false;
        }
}

public double costoparking(Transporte transporte,int horaparking){

    double ratehora = 0.0;
    
     switch (transporte.tipo) {
         case "Carro":
                ratehora = 1000.0;  // Ejemplo: $2 por hora para carros
                break;
            case "Moto":
                ratehora = 500.0;  // Ejemplo: $1.5 por hora para motos
                break;
            case "Bicicleta":
                ratehora = 200.0;  // Ejemplo: $3 por hora para camiones
                break;
            default:
                System.out.println("No se pertmite este tipo de vehiculo");  // Mensaje de error si el tipo no es válido
                return 0;
        }
            return ratehora * horaparking; 
       
     }
    
public int disponibilidad() {
    return Maxdispo - Vehiculosparking.size();

}

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Crear un objeto Scanner para leer entradas del usuario
        Parking parking = new Parking(5);
        
        while (true) {
            System.out.println("\n1. Registrar vehiculo");
            System.out.println("2. Costo de parking");
            System.out.println("3. Validar disponibilidad");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();  // Leer la opción del usuario
            scanner.nextLine();  // Limpiar el buffer de entrad
            
            
     switch (opcion) {
                case 1:
                    // Registrar un nuevo vehículo
                    System.out.print("Ingrese la placa del vehiculo: ");
                    String placa = scanner.nextLine();  // Leer placa
                    System.out.print("Ingrese el tipo de vehiculo (carro, moto, bicicleta): ");
                    String tipo = scanner.nextLine();  // Leer tipo de vehículo
                    System.out.print("Ingrese la fecha y hora de ingreso (Formato: dd/MM/yyyy HH:mm): ");
                    String datehoraingreso = scanner.nextLine();  // Leer fecha y hora de ingreso

                    Transporte transporte = new Transporte(placa, tipo, datehoraingreso);  // Crear un objeto Vehiculo
                    parking.registrodevehiculo(transporte);  // Registrar el vehículo en el parqueadero
                    break;
                    
                    
                     case 2:
                    // Calcular el costo del estacionamiento
                    System.out.print("Ingrese la placa para dimensionar el costo: ");
                    placa = scanner.nextLine();  // Leer placa del vehículo
                    System.out.print("cuantas horas desea parquear ");
                    int horaparking = scanner.nextInt();  // Leer las horas estacionadas

                    // Buscar el vehículo por placa
                    boolean vehiculoidentificado = false;
                    for (Transporte v : parking.Vehiculosparking) {
                        if (v.getplaca().equals(placa)) {  // Si el vehículo es encontrado por su placa
                            double costo = parking.costoparking(v, horaparking);  // Calcular el costo
                            System.out.println("El costo de parquear es: COP " + costo);  // Mostrar el costo
                            vehiculoidentificado = true;
                            break;
                        }
                    }

                    if (!vehiculoidentificado) {  // Si no se encuentra el vehículo
                        System.out.println("No se encuentra el vehiculo con esa placa.");
                    }
                    break;
                    
                    case 3:
                    // Mostrar la capacidad disponible en el parqueadero
                    int espacioDisponible = parking.disponibilidad();  // Obtener los espacios disponibles
                    System.out.println("Espacio disponible en el parqueadero: " + espacioDisponible);  // Mostrar la cantidad de espacios disponibles
                    break;

                case 4:
                    // Salir del sistema
                    System.out.println("Gracias por usar el sistema de parking.");
                    scanner.close();  // Cerrar el scanner
                    return;  // Terminar el programa

                default:
                    // Manejar opción inválida
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
                 }
                    
                    
        
        }
        
  
        
        
        
        
        
        
        
 }



}







