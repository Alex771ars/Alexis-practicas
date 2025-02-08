package EjercicioAngel;

import java.util.ArrayList;

public class Vehiculo {
  
    public String tipo;
    public String placa;

public Vehiculo(String tipo,String placa){

   this.tipo = tipo;
   this.placa = placa;
   }

@Override
public String toString(){
    return "Tipo "+ tipo + " con placa "+ placa;

    }

}