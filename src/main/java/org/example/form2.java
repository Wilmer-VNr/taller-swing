package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form2 {
    public JPanel mainPanel;
    private JTextField placa;
    private JTextField marca;
    private JTextField cilindraje;
    private JTextField tipoCombustible;
    private JTextField color;
    private JTextField propietario;
    private JTextField fechaCompra;
    private JButton ingresarDatos;

    public form2() {
        ingresarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://127.0.0.1:3306/Vehiculos";
                String user="root";
                String password="123456";


                String placaText = placa.getText();
                String marcaText = marca.getText();
                float cilindrajeText = Float.parseFloat(cilindraje.getText());
                String tipoCombustibleText = tipoCombustible.getText();
                String colorText = color.getText();
                String propietarioText = propietario.getText();
                String fechaCompraText = fechaCompra.getText();


                String sql = "INSERT into vehiculos (placa,marca,cilindraje,tipoCombustible, color, propietario, fechaCompra) VALUES(?,?,?,?,?,?,?)";

                Vehiculo vehiculos = new Vehiculo(placaText,marcaText,cilindrajeText,tipoCombustibleText,colorText,propietarioText,fechaCompraText);

                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

                    cadenaPreparada.setString(1, String.valueOf(placa));
                    cadenaPreparada.setString(2, String.valueOf(marca));
                    cadenaPreparada.setString(3, String.valueOf(cilindraje));
                    cadenaPreparada.setString(4, String.valueOf(tipoCombustible));
                    cadenaPreparada.setString(5, String.valueOf(color));
                    cadenaPreparada.setString(6, String.valueOf(propietario));
                    cadenaPreparada.setString(7, String.valueOf(fechaCompra));

                    cadenaPreparada.executeUpdate();

                    JOptionPane.showMessageDialog(mainPanel, vehiculos.toString(), "Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Por favor, ingrese una placa válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}


/*


                    JOptionPane.showMessageDialog(mainPanel, vehiculos.toString(), "Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);



                } catch (NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Por favor, ingrese una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                */
