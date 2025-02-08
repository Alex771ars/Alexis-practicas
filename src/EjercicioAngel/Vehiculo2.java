/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioAngel;

public class Vehiculo2 {

public String tipo;
    public String placa;

public Vehiculo2(String tipo,String placa){

   this.tipo = tipo;
   this.placa = placa;
   }

public void parquear(){
    System.out.println("El vehiculo"+ " " + tipo + " "+ "con placa"+ " "+ placa +
            " ha sido parqueado.");
}
public static void main(String[]args){
    Vehiculo2 vehiculo1 = new Vehiculo2("Carro","RRTWS");
    Vehiculo2 vehiculo2 = new Vehiculo2("Moto","GUV300");
    Vehiculo2 vehiculo3 = new Vehiculo2("bicicleta","GW21");
    vehiculo1.parquear();
    vehiculo2.parquear();
    vehiculo3.parquear();
}    
}
