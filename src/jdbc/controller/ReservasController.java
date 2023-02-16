/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.ReservaDAO;
import jdbc.model.Reservas;

/**
 *
 * @author Paula Acosta
 */
public class ReservasController {
    
private ReservaDAO reservaDAO;
 
 public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
 
	public void guardar(Reservas reservas) {
		this.reservaDAO.guardar(reservas);
	}
		
	public List<Reservas> listarReservas() {
		return this.reservaDAO.listarReservas();
		}
		
		public List<Reservas> listarReservasId(String idReserva) {
			return this.reservaDAO.buscarId(idReserva);
		}
	
	public void actualizar(Date fechaEntrada, Date fechaSalida, String valor, String formaPago,Integer idReserva) {
		this.reservaDAO.Actualizar(  fechaEntrada, fechaSalida, valor, formaPago, idReserva);
	}
	
	public void Eliminar(Integer idReserva) {
		this.reservaDAO.Eliminar(idReserva);
	}
        
}


