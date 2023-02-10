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

/**
 *
 * @author Paula Acosta
 */
public class HuespedesController {
    
    // se Declara una variable privada "huespedDAO"
    //que será un objeto de la clase HuespedesDAO.
    private HuespedesDAO  huespedDAO;
    
    
    //

	 public HuespedesController() {
			Connection connection = new ConnectionFactory().recuperarConexion();
			this.huespedDAO = new HuespedesDAO(connection);
		}
	 
		
         }
    
 
    

