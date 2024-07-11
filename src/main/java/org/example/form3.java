package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class form3 {
    public JPanel mainPanel;
    private JTextField consultatxt;
    private JButton buscarVehiculo;

    public form3() {
        buscarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://127.0.0.1:3306/Vehiculos";
                String user="root";
                String password="123456";

                try(Connection connection= DriverManager.getConnection(url,user,password)) {
                    System.out.println("Conectado a la base de datos");
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Ingrese la placa del vehiculo: ");
                    String placa=sc.nextLine();
                    String query="Select * from Vehiculos where consultatxt  ="+ placa ;
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        System.out.println("Placa: "+(resultSet.getString("PLACA")));
                        System.out.println("Marca: "+(resultSet.getString("MARCA")));
                        System.out.println("Cilindraje: "+(resultSet.getString("CILINDRAJE")));
                        System.out.println("Tipo de combustible: "+resultSet.getString("TIPOCOMBUSTIBLE"));
                        System.out.println("Color: "+resultSet.getString("COLOR"));
                        System.out.println("Propietario: "+resultSet.getString("PROPIETARIO"));
                        System.out.println("Fecha de Compra: "+resultSet.getString("FECHACOMPRA"));;

                    }
                }
                catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }

        });
    }

    public JPanel getMainPanel3() {
        return mainPanel;
    }
}
