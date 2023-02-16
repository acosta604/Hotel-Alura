/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.model.Reservas;

/**
 *
 * @author Paula Acosta
 */
public class ReservaDAO {

    private Connection connection;

 

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Reservas reservas) {

        try {

            String sql = "INSERT INTO Reservas (fechaEntrada,fechaSalida,valor,formaPago) VALUES (?,?,?,?)";

            try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pst.setDate(1, new java.sql.Date(reservas.getFechaEntrada().getTime()));
                pst.setDate(2, new java.sql.Date(reservas.getFechaSalida().getTime()));
                pst.setString(3, reservas.getValor());
                pst.setString(4, reservas.getFormaPago());
                
                pst.executeUpdate();

                try (ResultSet rst = pst.getGeneratedKeys()) {
                    while (rst.next()) {
                        reservas.setIdReserva(rst.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    public List<Reservas> listarReservas() {

        List<Reservas> reservas = new ArrayList<>();

        try {

            String sql = "SELECT idReserva, fechaEntrada, fechaSalida, valor, formaPago FROM Reservas";

            try (PreparedStatement pst = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

                pst.execute();

                transformarResultSetEnReserva(reservas, pst);
            }

            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reservas> buscarId(String idReserva) {
        List<Reservas> reservas = new ArrayList<>();
        try {

            String sql = "SELECT idReserva, fechaEntrada, fechaSalida, valor, formaPago FROM Reservas WHERE idReserva = ?";

            try (PreparedStatement pst = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, idReserva);
                pst.execute();

                transformarResultSetEnReserva(reservas, pst);
            }
            return reservas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar( Date fechaEntrada, Date fechaSalida, String valor, String formaPago,Integer idReserva) {

        try (PreparedStatement pst = connection.prepareStatement("UPDATE Reservas SET fechaEntrada = ?, fechaSalida = ?, valor = ?, formaPago = ? WHERE idReserva = ?")) {

            
            pst.setDate(1, new java.sql.Date(fechaEntrada.getTime()));
            pst.setDate(2, new java.sql.Date(fechaSalida.getTime()));
            pst.setString(3, valor);
            pst.setString(4, formaPago);
            pst.setInt(5, idReserva);
            pst.execute();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void Eliminar(Integer idReserva) {
        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM Reservas WHERE idReserva = ?")) {
            pst.setInt(1, idReserva);
            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEnReserva(List<Reservas> reserva, PreparedStatement pst) throws SQLException {
        try (ResultSet rst = pst.getGeneratedKeys()) {
            while (rst.next()) {

                Reservas producto = new Reservas(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

                reserva.add(producto);
            }
        }
    }

}
