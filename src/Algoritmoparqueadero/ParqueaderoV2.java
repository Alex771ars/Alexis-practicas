/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmoparqueadero;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
public class ParqueaderoV2 {
    
    // Variables para controlar los espacios disponibles en el parqueadero
    private static String[] carros = new String[2]; // Espacios para 2 carros
    private static String[] motos = new String[1];  // Espacios para 1 moto
    private static LocalDateTime[] ingresoCarros = new LocalDateTime[2]; // Almacenar hora de ingreso de carros
    private static LocalDateTime[] ingresoMotos = new LocalDateTime[1];  // Almacenar hora de ingreso de motos
    private static int espaciosCarros = 2;  // Número de espacios para carros
    private static int espaciosMotos = 1;   // Número de espacios para motos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para leer entradas del usuario
        int opcion; // Variable para almacenar la opción seleccionada por el usuario

        // Menú interactivo donde el usuario puede elegir qué acción realizar
        while (true) {
            System.out.println("Opciones generales:");
            System.out.println("1. Ingresar un carro");
            System.out.println("2. Ingresar una moto");
            System.out.println("3. Mostrar vehiculos en el parqueadero");
            System.out.println("4. Registrar salida de un vehiculo con su costo de parking");
            System.out.println("5. Salir");
            System.out.print("Por favor elija una opcion para continuar: ");
            opcion = scanner.nextInt(); // Leer la opción seleccionada por el usuario
            scanner.nextLine(); // Consumir el salto de línea sobrante después de leer el número

            // Dependiendo de la opción, se ejecutara un método diferente
            switch (opcion) {
                case 1:
                    ingresarCarro(scanner);  // Ingresar un carro
                    break;
                case 2:
                    ingresarMoto(scanner);   // Ingresar una moto
                    break;
                case 3:
                    mostrarVehiculos();      // Mostrar los vehículos en el parqueadero
                    break;
                case 4:
                    registrarSalida(scanner); // Registrar salida de un vehículo
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el servicio"); // Salir del programa
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida."); // Si la opción no es válida
            }
        }
    }

    // Método para ingresar un carro
    private static void ingresarCarro(Scanner scanner) {
        if (espaciosCarros > 0) { // Si hay espacio disponible para un carro
            System.out.print("Ingrese la placa del carro: ");
            String placa = scanner.nextLine(); // Leer la placa del carro

            // Obtener la fecha y hora actuales
            LocalDateTime fechaHora = LocalDateTime.now();

            // Buscar un espacio vacío en el arreglo de carros
            for (int i = 0; i < 2; i++) {
                if (carros[i] == null) {  // Si el espacio está vacío
                    carros[i] = placa + " - Ingreso: " + obtenerFechaHora(fechaHora);   // Guardar la placa y la fecha
                    ingresoCarros[i] = fechaHora; // Almacenar la hora de ingreso del carro
                    espaciosCarros--;     // Reducir el número de espacios disponibles
                    System.out.println("Carro ingresado exitosamente.");
                    return;  // Salir del método una vez el carro ha sido ingresado
                }
            }
        } else {
            System.out.println("No hay disponibilidad para carros."); // Si no hay espacio
        }
    }

    // Método para ingresar una moto
    private static void ingresarMoto(Scanner scanner) {
        if (espaciosMotos > 0) { // Si hay espacio disponible para una moto
            System.out.print("Ingrese la placa de la moto: ");
            String placa = scanner.nextLine(); // Leer la placa de la moto

            // Obtener la fecha y hora actuales
            LocalDateTime fechaHora = LocalDateTime.now();

            // Buscar un espacio vacío en el arreglo de motos
            for (int i = 0; i < 1; i++) {
                if (motos[i] == null) {  // Si el espacio está vacío
                    motos[i] = placa + " - Ingreso: " + obtenerFechaHora(fechaHora);    // Guardar la placa y la fecha
                    ingresoMotos[i] = fechaHora; // Almacenar la hora de ingreso de la moto
                    espaciosMotos--;      // Reducir el número de espacios disponibles
                    System.out.println("Moto ingresada exitosamente.");
                    return;  // Salir del método una vez la moto ha sido ingresada
                }
            }
        } else {
            System.out.println("No hay disponibilidad para motos."); // Si no hay espacio
        }
    }

    // Método para mostrar los vehículos que están actualmente en el parqueadero
    private static void mostrarVehiculos() {
        System.out.println("Vehiculos en el parqueadero:");
        
        // Mostrar los carros que están en el parqueadero
        System.out.println("Carros:");
        for (String carro : carros) {
            if (carro != null) {  // Solo mostrar los carros que tienen placa (no están vacíos)
                System.out.println(carro); // Imprimir la placa del carro
            }
        }

        // Mostrar las motos que están en el parqueadero
        System.out.println("Motos:");
        for (String moto : motos) {
            if (moto != null) {  // Solo mostrar las motos que tienen placa (no están vacías)
                System.out.println(moto); // Imprimir la placa de la moto
            }
        }
    }

    // Método para obtener la fecha y hora actuales en formato legible
    private static String obtenerFechaHora(LocalDateTime fechaHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Formato deseado
        return fechaHora.format(formatter); // Devolver la fecha y hora formateada
    }

    // Método para registrar la salida de un vehículo y calcular el tiempo estacionado
    private static void registrarSalida(Scanner scanner) {
        System.out.print("Ingrese la placa del vehiculo que desea retirar: ");
        String placa = scanner.nextLine();

        // Buscar el vehículo por placa en los carros
        for (int i = 0; i < 2; i++) {
            if (carros[i] != null && carros[i].contains(placa)) {
                // Calcular la duración
                Duration duracion = Duration.between(ingresoCarros[i], LocalDateTime.now());
                long horas = duracion.toHours();
                long minutos = duracion.toMinutes() % 60;
                long precio = horas * 1000 + (minutos > 0 ? 1000 : 0); // Precio por hora para carro 
                System.out.println("El vehiculo con placa " + placa + " ha estado estacionado por: " + horas + " horas y " + minutos + " minutos.");
                System.out.println("El precio de estacionamiento es: COP " + precio);
                
                // Liberar el espacio
                carros[i] = null;
                ingresoCarros[i] = null;
                espaciosCarros++;
                return;
            }
        }

        // Buscar el vehículo por placa en las motos
        for (int i = 0; i < 1; i++) {
            if (motos[i] != null && motos[i].contains(placa)) {
                // Calcular la duración
                Duration duracion = Duration.between(ingresoMotos[i], LocalDateTime.now());
                long horas = duracion.toHours();
                long minutos = duracion.toMinutes() % 60;
                long precio = horas * 500 + (minutos > 0 ? 500 : 0); // Precio por hora para moto 
                System.out.println("La moto con placa " + placa + " ha estado estacionada por: " + horas + " horas y " + minutos + " minutos.");
                System.out.println("El precio de estacionamiento es: COP " + precio);
                
                // Liberar el espacio
                motos[i] = null;
                ingresoMotos[i] = null;
                espaciosMotos++;
                return;
            }
        }

        System.out.println("Placa no encontrada. Verifique e intente nuevamente.");
    }
    
}
