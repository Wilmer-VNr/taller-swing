package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class form2 {
    public JPanel mainPanel;
    private JTextField placa;
    private JTextField marca;
    private JTextField cilindraje;
    private JTextField tipoCombustible;
    private JTextField color;
    private JTextField propietario;
    private JTextField fechaCompra;
    private JButton limpiar;
    private JButton IngresarDatos;

    public form2() {
        IngresarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://127.0.0.1:3306/Vehiculo";
                String user = "root";
                String password = "1234";

                Vehiculo vehiculo1 = new Vehiculo();

                String sql = "INSERT INTO vehiculo (placa, marca, cilindraje, tipoCombustible, color, propietario, fechaCompra) VALUES (?, ?, ?, ?, ?, ?, ?)";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conexión con la base de datos exitosa");
                    PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

                    vehiculo1.setPlaca(placa.getText());
                    vehiculo1.setMarca(marca.getText());
                    vehiculo1.setCilindraje(Float.parseFloat(cilindraje.getText()));
                    vehiculo1.setTipoCombustble(tipoCombustible.getText());
                    vehiculo1.setColor(color.getText());
                    vehiculo1.setPropietario(propietario.getText());

                    // Convertir fecha
                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = inputFormat.parse(fechaCompra.getText());
                    String formattedDate = outputFormat.format(date);
                    vehiculo1.setFechaCompra(formattedDate);

                    cadenaPreparada.setString(1, vehiculo1.getPlaca());
                    cadenaPreparada.setString(2, vehiculo1.getMarca());
                    cadenaPreparada.setFloat(3, vehiculo1.getCilindraje());
                    cadenaPreparada.setString(4, vehiculo1.getTipoCombustble());
                    cadenaPreparada.setString(5, vehiculo1.getColor());
                    cadenaPreparada.setString(6, vehiculo1.getPropietario());
                    cadenaPreparada.setString(7, vehiculo1.getFechaCompra());

                    cadenaPreparada.executeUpdate();

                    JOptionPane.showMessageDialog(mainPanel, vehiculo1.toString(), "Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Error al ingresar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Error al formatear la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placa.setText("");
                marca.setText("");
                cilindraje.setText("");
                tipoCombustible.setText("");
                color.setText("");
                propietario.setText("");
                fechaCompra.setText("");
            }
        });
    }
}
