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

   
    
    private  Integer idHuesped;
    private Integer idReserva;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String Telefono;
    
    
    
    public Huespedes (Integer idReserva ,String nombre, String apellido,Date fechaN, String nacionalidad, String tel){
    super();
   this.idReserva= idReserva;
   this.nombre= nombre;
   this.apellido= apellido;
   this.fechaNacimiento= fechaN;
   this.nacionalidad= nacionalidad;
   this.Telefono= tel;
    
    }
    
    public Huespedes (Integer idHuesped,Integer idReserva, String nombre, String apellido,Date fechaN, String nacionalidad, String tel){
     super();
   this.idHuesped= idHuesped;
   this.idReserva= idReserva;
   this.nombre= nombre;
   this.apellido= apellido;
   this.fechaNacimiento= fechaN;
   this.nacionalidad= nacionalidad;
   this.Telefono= tel;
    
    }
    
     public Integer getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Integer idHuesped) {
        this.idHuesped = idHuesped;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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
