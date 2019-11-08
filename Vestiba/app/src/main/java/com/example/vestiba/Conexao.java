package com.example.vestiba;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao  extends AsyncTask<Void,Void,Object> {

    @Override
    protected Connection doInBackground(Void... voids) {

        try {
            Class.forName ("org.postgresql.Driver");
            return DriverManager.getConnection ("jdbc:postgresql://localhost:5432/Vestiba","aluno","aluno");
        } catch (Exception e){
            try {
                throw new SQLException(e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

}
