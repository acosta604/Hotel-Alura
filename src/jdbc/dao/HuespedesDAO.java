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
            // Se crea una cadena de texto llamada sql que representa una sentencia SQL 
            //de inserción en la tabla huespedes.
            String sql = "INSERT INTO Huespedes (nombre,apellido,fechaNacimiento,nacionalidad,telefono,idReserva)+"
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            /**
             * try with resources Se crea una instancia de PreparedStatement con
             * la conexión a la base de datos y la sentencia SQL. La opción
             * Statement.RETURN_GENERATED_KEYS indica que se desea recuperar las
             * claves generadas.*
             */
            try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                /* Se establecen los valores para cada uno de los campos en la tabla
                * Se establecen los valores para cada uno de los campos en la tabla
                * huespedes usando el método setString o setDate y el índice del parámetro.*/
                pst.setString(1, huesped.getNombre());
                pst.setString(2, huesped.getApellido());
                pst.setDate(3, (Date) huesped.getFechaNacimiento());
                pst.setString(4, huesped.getNacionalidad());
                pst.setString(5, huesped.getTelefono());
                pst.setInt(6, huesped.getId_Reserva());

                //Se ejecuta la sentencia SQL mediante el método execute.
                pst.execute();

                /*try with resources Se recuperan las
                 * claves generadas y se establecen en el objeto huesped. */
                try (ResultSet rst = pst.getGeneratedKeys()) {
                    while (rst.next()) {
                        huesped.setId_Huesped(rst.getInt(1));
                    }
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Huespedes> listarHuespedes() {

        List<Huespedes> huespedes = new ArrayList<Huespedes>();

        try {

            String sql = "SELECT (idHuesped,idReserva, nombre,apellido,fechaNacimiento,nacionalidad,Telefono) +"
                    + "FROM Huespedes";

            try (PreparedStatement pst = connection.prepareStatement(sql)) {

                pst.execute();

                transformarResultSetEnHuesped(huespedes, pst);
            }

            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar(Integer idHuesped, Integer idReserva, String nombre, String apellido, Date fechaN, String nacionalidad, String tel) {

        try (PreparedStatement pst = connection.prepareStatement("UPDATE Huespedes  SET "
                + "idReserva = ?, nombre= ?, apellido =?, fechaNacimiento=?, nacionalidad= ?, Telefono=? "
                + "WHERE idHuesped = ? ")) {

            pst.setInt(1, idHuesped);
            pst.setInt(2, idReserva);
            pst.setString(3, nombre);
            pst.setString(4, apellido);
            pst.setDate(5, fechaN);
            pst.setString(6, nacionalidad);
            pst.setString(7, tel);

            pst.execute();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void Eliminar(Integer idHuesped, Integer idReserva, String nombre, String apellido, Date fechaN, String nacionalidad, String tel) {

        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM Huespedes WHERE idHuesped = ?")) {

            pst.setInt(1, idHuesped);
            pst.execute();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    private void transformarResultSetEnHuesped(List<Huespedes> reservas, PreparedStatement pst) throws SQLException {
        try (ResultSet rst = pst.getResultSet()) {
            while (rst.next()) {
                Huespedes huespedes = new Huespedes(rst.getInt(1), rst.getInt(2), rst.getString(3), rst.getString(4), rst.getDate(5), rst.getString(6), rst.getString(7));
                reservas.add(huespedes);
            }
        }
    }

}
