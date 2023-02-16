/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.model;

import java.util.Date;

/**
 * @author Paula Acosta
 */
public class Reservas {

    private Integer idReserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String valor;
    private String formaPago;

    public Reservas(Date fechaE, Date fechaS,String valor, String formaP) {
        super();
        this.fechaEntrada = fechaE;
        this.fechaSalida = fechaS;
        this.valor = valor;
        this.formaPago = formaP;

    }

    public Reservas(Integer idReserva, Date fechaE, Date fechaS, String valor, String formaP) {
        this.idReserva = idReserva;
        this.fechaEntrada = fechaE;
        this.fechaSalida = fechaS;
        this.valor = valor;
        this.formaPago = formaP;

    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer id_Reserva) {
        this.idReserva = id_Reserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public String getValor() {
        return valor;
    }

    public String getFormaPago() {
        return formaPago;
    }


}
