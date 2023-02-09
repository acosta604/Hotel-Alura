/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdb.factory;

import java.sql.SQLException;

/**
 *
 * @author Paula Acosta
 */
public class TestConnection {
    
    
    public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionTest = new ConnectionFactory();
		java.sql.Connection connection = connectionTest.recuperarConexion();
                
		System.out.println("Conexion exitosa");
              
		System.out.println("Cerrando conexion...");

		connection.close();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
