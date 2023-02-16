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
import jdbc.model.Huespedes;

/**
 *
 * @author Paula Acosta
 */
public class HuespedesDAO {

    private Connection connection;

    public HuespedesDAO(Connection connection) {
        this.connection = connection;

    }
    //Se inicia la función guardar y se pasa como argumento un objeto de tipo Huespedes.

  	public void guardar(Huespedes huesped) {
		try {
			String sql = "INSERT INTO Huespedes (nombre, apellido, fechaNacimiento, nacionalidad, Telefono, idReserva) VALUES (?, ?, ?, ?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pst.setString(1, huesped.getNombre());
				pst.setString(2, huesped.getApellido());
				pst.setDate(3, new java.sql.Date(huesped.getFechaNacimiento().getTime()));
				pst.setString(4, huesped.getNacionalidad());
				pst.setString(5, huesped.getTelefono());
				pst.setInt(6, huesped.getIdReserva());

				pst.execute();

				try (ResultSet rst = pst.getGeneratedKeys()) {
					while (rst.next()) {
						huesped.setIdHuesped(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
public List<Huespedes> listarHuespedes() {
		List<Huespedes> huespedes = new ArrayList<>();
		try {
			String sql = "SELECT idHuesped,idReserva, nombre, apellido,fechaNacimiento,nacionalidad,Telefono FROM Huespedes";

            try (PreparedStatement pst = connection.prepareStatement(sql)) {
          
                pst.execute();

                transformarResultSetEnHuesped(huespedes, pst);
            }

            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huespedes> buscarIdNom(String idHuesped, String nombre) {
        List<Huespedes> huespedes = new ArrayList<>();
        try {

            String sql = "SELECT idHuesped,idReserva, nombre, apellido, fechaNacimiento, nacionalidad, Telefono  FROM Huespedes WHERE  idReserva = ? OR nombre= ?";
                                                                           //elimine Statement.GENERETED KEYS
            try (PreparedStatement pst = connection.prepareStatement(sql)) {
                pst.setString(1, idHuesped);
                pst.setString(2, nombre);
                pst.execute();

                transformarResultSetEnHuesped(huespedes, pst);
            }
            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar( Integer idReserva, Integer idHuesped,String nombre, String apellido, Date fechaN, String nacionalidad, String tel) {

        try (PreparedStatement pst = connection.prepareStatement("UPDATE Huespedes SET nombre = ?, apellido = ?, fechaNacimiento = ?, nacionalidad = ?, Telefono = ?  WHERE idHuesped = ? ")) {

            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setDate(3, fechaN);
            pst.setString(4, nacionalidad);
            pst.setString(5, tel);
            pst.setInt(6, idHuesped);
        
            pst.execute();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void Eliminar(Integer idHuesped) {

        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM Huespedes WHERE idHuesped = ?")) {

            pst.setInt(1, idHuesped);
            pst.execute();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

  	private void transformarResultSetEnHuesped(List<Huespedes> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Huespedes huespedes = new Huespedes( rst.getInt(1), rst.getInt(2),rst.getString(3), rst.getString(4), rst.getDate(5), rst.getString(6), rst.getString(7));
				reservas.add(huespedes);
			}
		}				
	}
	
	
		

}
