/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioAngel;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    
    private List<Vehiculo> vehiculos;
    
    public Parqueadero() {
        this.vehiculos = new ArrayList<>();       
    }     
    public void añadirVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);  // Agrega el vehículo a la lista
    }    
    public void mostrarVehiculos() {
        System.out.println("Los siguientes vehiculos "
                + "se encuentran en el parqueadero:");
         for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);  
    }     
    }  
    public static void main(String[] args) {
        // Crear un parqueadero
        Parqueadero parking = new Parqueadero();
    
        Vehiculo vehiculo1 = new Vehiculo("Carro", "VUY85D");
        Vehiculo vehiculo2 = new Vehiculo("Moto", "GMA66X");
        Vehiculo vehiculo3 = new Vehiculo("Bicicleta", "GW21");
      
        parking.añadirVehiculo(vehiculo1);
        parking.añadirVehiculo(vehiculo2);
        parking.añadirVehiculo(vehiculo3);
  
        parking.mostrarVehiculos();           
    }   
}

