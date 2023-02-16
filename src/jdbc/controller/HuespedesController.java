/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.HuespedesDAO;
import jdbc.model.Huespedes;

/**
 *
 * @author Paula Acosta
 */
public class HuespedesController {

    // se Declara una variable privada "huespedDAO"
    //que será un objeto de la clase HuespedesDAO.
    private HuespedesDAO huespedDAO;

    //
    public HuespedesController() {
        Connection connection = new ConnectionFactory().recuperarConexion();
        this.huespedDAO = new HuespedesDAO(connection);
    }

    public void guardar(Huespedes huespedes) {
        try {
            this.huespedDAO.guardar(huespedes);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Huespedes> listarHuespedes() {
        return this.huespedDAO.listarHuespedes();
    }

    public List<Huespedes> listarHuespedesIdNom(String idHuesped, String nombre) {
        return this.huespedDAO.buscarIdNom(idHuesped, nombre);
    }

    public void actualizar(Integer idReserva, Integer idHuesped, String nombre, String apellido, Date fechaN, String nacionalidad, String tel) {
        this.huespedDAO.Actualizar(idReserva, idHuesped, nombre, apellido, fechaN, nacionalidad, tel);
    }

    public void Eliminar(Integer idHuesped) {
        this.huespedDAO.Eliminar(idHuesped);
    }

}
