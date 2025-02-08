/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmoparqueadero;

import java.util.*;

public class Parqueadero {
    
   // Capacidad de vehículos en el parqueadero
    private static final int C_CARRO = 1;
    private static final int C_MOTO = 1;
    private static final int C_BICICLETA = 1;

    //Contador
    private int carros = 0;
    private int motos = 0;
    private int bicicletas = 0;

    //precios
    private static final int P_CARRO = 1000;
    private static final int P_MOTO = 500;
    private static final int P_BICICLETA = 200;


    private List<Vehiculo> vehiculos = new ArrayList<>();

    
    class Vehiculo {
        String tipo;
        String placa;
        String fechaIngreso;
        

        public Vehiculo(String tipo, String placa, String fechaIngreso) {
            this.tipo = tipo;
            this.placa = placa;
            this.fechaIngreso = fechaIngreso;
        }
    }

    // Método para registrar un vehículo
    public String registrarVehiculo(String tipo, String placa,String fechaIngreso) {
        // Validar si el tipo de vehículo es válido
        if (!tipo.equals("Carro") && !tipo.equals("Moto") && !tipo.equals("Bicicleta")) {
            return "Lo siento: Este vehiculo no es permitido.";
        }

        // Validar la dispo
        if (tipo.equals("Carro") && carros >= C_CARRO) {
            return "Error: No hay cupo disponible para carros.";
        }
        if (tipo.equals("Moto") && motos >= C_MOTO) {
            return "Error: No hay cupo disponible para motos.";
        }
        if (tipo.equals("Bicicleta") && bicicletas >= C_BICICLETA) {
            return "Error: No hay cupo disponible para bicicletas.";
        }
        
        // Registrar el vehículo
        Vehiculo vehiculo = new Vehiculo(tipo, placa, fechaIngreso);
        vehiculos.add(vehiculo);

        // Actualizar contador según el tipo de vehículo
        switch (tipo) {
            case "Carro":
                carros++;
                break;
            case "Moto":
                motos++;
                break;
            case "Bicicleta":
                bicicletas++;
                break;
        }

        return "El vehiculo ha sido registrado con exito. Placa: " + placa + " Tipo: " + tipo;
    }

    // Método para calcular el costo de estacionamiento
    public int calcularCosto(String tipo,int horaparking) {
        long horasEstacionado = horaparking;

        int costo = 0;

        // Calcular el costo según el tipo de vehículo
        switch (tipo) {
            case "Carro":
                costo = (int) (horasEstacionado * P_CARRO);
                break;
            case "Moto":
                costo = (int) (horasEstacionado * P_MOTO);
                break;
            case "Bicicleta":
                costo = (int) (horasEstacionado * P_BICICLETA);
                break;
        }

        return costo;
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Calcular costo de estacionamiento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese tipo de vehiculo (Carro, Moto, Bicicleta): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese la placa del vehiculo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese la fecha y hora de ingreso (Formato: dd/MM/yyyy HH:mm): ");
                    String fechaIngreso = scanner.nextLine(); 
                    System.out.println(registrarVehiculo(tipo,placa,fechaIngreso));
                    break;

                case 2:
                    System.out.print("Ingrese tipo de vehiculo para calcular el costo (Carro, Moto, Bicicleta): ");
                    tipo = scanner.nextLine();
                    System.out.print("Ingrese la placa del vehiculo: ");
                    placa = scanner.nextLine();
                    System.out.print("cuantas horas desea parquear ");
                    int horaparking = scanner.nextInt();  // Leer las horas estacionadas
                    // Buscar el vehículo en la lista
                    boolean encontrado = false;
                    for (Vehiculo v : vehiculos) {
                        if (v.placa.equals(placa) && v.tipo.equals(tipo)) {
                            encontrado = true;
                            int costo = calcularCosto(tipo,horaparking);
                            System.out.println("El costo de parking para el vehiculo con placa " + placa + " es: COP" + costo);
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Error: No se encuentra el vehiculo registrado con esa placa y tipo.");
                    }
                    break;

                case 3:
                    System.out.println("Muchas gracias por usar el sistema de parking.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no valida. Intente nuevamente.");
            }
        }
    }
    
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        parqueadero.mostrarMenu();
    }
}





