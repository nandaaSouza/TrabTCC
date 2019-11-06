package com.example.vestiba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection getConnection () throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/vestiba","postgres","fernanda");
        } catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }

}
