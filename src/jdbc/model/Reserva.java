/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.model;

import java.util.Date;



/**
 * @author Paula Acosta
 */
public class Reserva {

    private Integer id_Reserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Double valor;
    private String formaPago;

    public Reserva(Date fechaE, Date fechaS, Double valor, String formaP) {
        super();
        this.fechaEntrada = fechaE;
        this.fechaSalida = fechaS;
        this.valor = valor;
        this.formaPago = formaP;

    }

    public Reserva(Integer idReserva, Date fechaE, Date fechaS, Double valor, String formaP) {
        this.id_Reserva = idReserva;
        this.fechaEntrada = fechaE;
        this.fechaSalida = fechaS;
        this.valor = valor;
        this.formaPago = formaP;

    }

    public Integer getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(Integer id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Double getValor() {
        return valor;
    }

    public String getFormaPago() {
        return formaPago;
    }


}
