/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.model;

import java.util.Date;

/**
 *
 * @author Paula Acosta
 */
public class Huespedes {

   
    
    private  Integer id_Huesped;
    private Integer id_Reserva;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String Telefono;
    
    
    
    public Huespedes (Integer idReserva, String nombre, String apellido,Date fechaNacimiento, String nacionalidad, String tel){
    super();
   this.id_Reserva= idReserva;
   this.nombre= nombre;
   this.apellido= apellido;
   this.fechaNacimiento= fechaNacimiento;
   this.nacionalidad= nacionalidad;
   this.Telefono= tel;
    
    }
    
    public Huespedes (Integer idHuesped, Integer idReserva, String nombre, String apellido,Date fechaNacimiento, String nacionalidad, String tel){
   
   this.id_Huesped= idHuesped;
   this.id_Reserva= idReserva;
   this.nombre= nombre;
   this.apellido= apellido;
   this.fechaNacimiento= fechaNacimiento;
   this.nacionalidad= nacionalidad;
   this.Telefono= tel;
    
    }
    
     public Integer getId_Huesped() {
        return id_Huesped;
    }

    public void setId_Huesped(Integer id_Huesped) {
        this.id_Huesped = id_Huesped;
    }

    public Integer getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(Integer id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
            
            
            

}
