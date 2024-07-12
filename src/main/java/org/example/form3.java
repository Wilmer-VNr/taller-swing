package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form3 {
    public JPanel mainPanel;
    private JTextField marcatxt;
    private JTextField cilindrajetxt;
    private JTextField tipoCombustbletxt;
    private JTextField colortxt;
    private JTextField fechaCompratxt;
    private JTextField consultatxt;
    private JButton buscar;
    private JTextField propietariotxt;

    public form3() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://127.0.0.1:3306/Vehiculo";
                String user = "root";
                String password = "1234";

                String id = consultatxt.getText();

                Vehiculo vehiculo = new Vehiculo();

                String sql = "SELECT * FROM vehiculo WHERE placa = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conexión con la base de datos exitosa");

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, id);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        vehiculo.setMarca(resultSet.getString("marca"));
                        vehiculo.setCilindraje(resultSet.getFloat("cilindraje"));
                        vehiculo.setTipoCombustble(resultSet.getString("tipoCombustible"));
                        vehiculo.setColor(resultSet.getString("color"));
                        vehiculo.setPropietario(resultSet.getString("propietario"));
                        vehiculo.setFechaCompra(resultSet.getString("fechaCompra"));

                        marcatxt.setText(vehiculo.getMarca());
                        cilindrajetxt.setText(String.valueOf(vehiculo.getCilindraje()));
                        tipoCombustbletxt.setText(vehiculo.getTipoCombustble());
                        colortxt.setText(vehiculo.getColor());
                        propietariotxt.setText(vehiculo.getPropietario());
                        fechaCompratxt.setText(vehiculo.getFechaCompra());
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "No se encontró un vehículo con esa placa.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(mainPanel, "Error al buscar el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
