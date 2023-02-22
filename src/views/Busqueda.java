/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Paula Acosta
 */
package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.controller.HuespedesController;
import jdbc.controller.ReservasController;
import jdbc.model.Huespedes;
import jdbc.model.Reservas;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHuesped;
    private ReservasController reservasController;
    private HuespedesController huespedesController;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;
    String reservas;
    String huespedes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Create the frame.
     */
    public Busqueda() {
        this.reservasController = new ReservasController();
        this.huespedesController = new HuespedesController();
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane.setLayout(null);
        

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);

        JLabel lblTitulo = new JLabel("SISTEMA DE BUSQUEDA");
        lblTitulo.setBounds(331, 62, 290, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
        contentPane.add(lblTitulo);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBounds(20, 169, 865, 328);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        contentPane.add(panel);

        tbHuespedes = new JTable();
        modeloHuesped = new DefaultTableModel();
        modeloHuesped.addColumn("Numero de Huesped");
        modeloHuesped.addColumn("Numero de Reserva");
        modeloHuesped.addColumn("Nombre");
        modeloHuesped.addColumn("Apellido");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        tbHuespedes.setModel(modeloHuesped);
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(tbHuespedes); // Definir la variable scrollPane antes de utilizarla
        scrollPane.setViewportView(tbHuespedes);
        panel.addTab("Huespedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scrollPane, null);
          tbHuespedes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        LlenarTablaHuespedes();

        tbReservas = new JTable();
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        JScrollPane scrollPaner = new JScrollPane(tbReservas);
         scrollPane.setViewportView(tbHuespedes);
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scrollPaner, null);
        tbReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        LlenarTablaReservas();

        JLabel logo = new JLabel("");
        logo.setBounds(56, 51, 104, 107);
        logo.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        contentPane.add(logo);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(539, 159, 193, 2);
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarTabla();
                if (txtBuscar.getText().equals("")) {
                    LlenarTablaHuespedes();
                    LlenarTablaReservas();
                } else {
                    LlenarTablaReservasId();
                    LlenarTablaHuespedesId();
                }
            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaReservas = tbReservas.getSelectedRow();
                int filaHuespedes = tbHuespedes.getSelectedRow();

                if (filaReservas >= 0) {
                    ActualizarReservas();
                    limpiarTabla();
                    LlenarTablaReservas();
                    LlenarTablaHuespedes();
                } else if (filaHuespedes >= 0) {
                    ActualizarHuesped();
                    limpiarTabla();
                    LlenarTablaHuespedes();
                    LlenarTablaReservas();
                }
            }
        });
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnEliminar = new JPanel();
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaReservas = tbReservas.getSelectedRow();
                int filaHuespedes = tbHuespedes.getSelectedRow();

                if (filaReservas >= 0) {

                    reservas = tbReservas.getValueAt(filaReservas, 0).toString();
                    int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?");

                    if (confirmar == JOptionPane.YES_OPTION) {

                        String valor = tbReservas.getValueAt(filaReservas, 0).toString();
                        reservasController.Eliminar(Integer.valueOf(valor));
                        JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
                        limpiarTabla();
                        LlenarTablaReservas();
                        LlenarTablaHuespedes();
                    }
                } else if (filaHuespedes >= 0) {

                    huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
                    int confirmarh = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?");

                    if (confirmarh == JOptionPane.YES_OPTION) {

                        String valor = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
                        huespedesController.Eliminar(Integer.valueOf(valor));
                        JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
                        limpiarTabla();
                        LlenarTablaHuespedes();
                        LlenarTablaReservas();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error fila no seleccionada, por favor realice una busqueda y seleccione una fila para eliminar");
                }
            }
        });
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
    }

    private List<Reservas> BuscarReservas() {
        return this.reservasController.buscarReservas();
    }

    private List<Reservas> listarReservasId() {
        return this.reservasController.buscarReservasId(txtBuscar.getText());
    }

    //CODIGO PARA BUSCAR HUESPEDES POR ID reserva y Nombre
    private List<Huespedes> BuscarHuespedes() {
        return this.huespedesController.listarHuespedes();
    }

    private List<Huespedes> BuscarHuespedesIdNom() {
        return this.huespedesController.listarHuespedesIdNom(txtBuscar.getText(), txtBuscar.getText());
    }

    private void limpiarTabla() {
        ((DefaultTableModel) tbHuespedes.getModel()).setRowCount(0);
        ((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
    }

    // LLENAR TABLA RESERVAS
    private void LlenarTablaReservas() {

        //Llenar Tabla
        List<Reservas> reserva = BuscarReservas();
        if (reserva.isEmpty()) {
            System.out.println("La lista de reservas está vacía.");
        } else {
            System.out.println("La lista de reservas tiene " + reserva.size() + " elementos.");
        }

        try {
            for (Reservas reservas : reserva) {
                modelo.addRow(new Object[]{reservas.getIdReserva(), reservas.getFechaEntrada(), reservas.getFechaSalida(), reservas.getValor(), reservas.getFormaPago()});
                System.out.println(reserva.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void LlenarTablaReservasId() {
        //Llenar Tabla reservas
        List<Reservas> reserva = listarReservasId();
        try {
            for (Reservas reservas : reserva) {
                modelo.addRow(new Object[]{reservas.getIdReserva(), reservas.getFechaEntrada(), reservas.getFechaSalida(), reservas.getValor(), reservas.getFormaPago()});
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // LLENAR TABLA HUESPEDES
    private void LlenarTablaHuespedes() {
        //Llenar Tabla
        List<Huespedes> huesped = BuscarHuespedes();
        try {
            for (Huespedes huespedes : huesped) {
                modeloHuesped.addRow(new Object[]{huespedes.getIdHuesped(), huespedes.getIdReserva(), huespedes.getNombre(), huespedes.getApellido(), huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono()});
                System.out.println(huesped.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void LlenarTablaHuespedesId() {
        //Llenar Tabla huespedes
        List<Huespedes> huesped = BuscarHuespedesIdNom();
        try {
            for (Huespedes huespedes : huesped) {
                modeloHuesped.addRow(new Object[]{huespedes.getIdHuesped(), huespedes.getIdReserva(), huespedes.getNombre(), huespedes.getApellido(), huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono()});
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void ActualizarReservas() {
        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                .ifPresentOrElse(fila -> {

                    Date fechaE = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
                    Date fechaS = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
                    String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
                    String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
                    Integer idReserva = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
                    this.reservasController.actualizar(fechaE, fechaS, valor, formaPago, idReserva);
                    JOptionPane.showMessageDialog(this, String.format("Registro modificado con exito"));
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un registro"));

    }

    private void ActualizarHuesped() {
        int selectedRow = tbHuespedes.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int idHuesped = (int) modeloHuesped.getValueAt(selectedRow, 0);
                int idReserva = (int) modeloHuesped.getValueAt(selectedRow, 1);
                String nombre = (String) modeloHuesped.getValueAt(selectedRow, 2);
                String apellido = (String) modeloHuesped.getValueAt(selectedRow, 3);
                Date fechaNacimiento = (Date) modeloHuesped.getValueAt(selectedRow, 4);
                String nacionalidad = (String) modeloHuesped.getValueAt(selectedRow, 5);
                String telefono = (String) modeloHuesped.getValueAt(selectedRow, 6);

                this.huespedesController.actualizar(idReserva, idHuesped, nombre, apellido, fechaNacimiento, nacionalidad, telefono);
                JOptionPane.showMessageDialog(this, String.format("Registro modificado con éxito"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar registro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para actualizar");
        }
    }

    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
