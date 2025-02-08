/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmoparqueadero;


public class Transporte {
    
    public String tipo;
    public String placa;
    public String datehoraingreso;
    
public Transporte (String tipo, String placa, String datehoraingreso){

    this.tipo = tipo;
    this.placa= placa;
    this.datehoraingreso= datehoraingreso;
    
}
    
public String gettipo () {
    return tipo;
}    
    
public String getplaca () {
    return placa;
}    
    
public String getdatehoraingreso () {
    return datehoraingreso;
}       
    
}
