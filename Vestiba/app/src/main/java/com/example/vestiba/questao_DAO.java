package com.example.vestiba;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class questao_DAO extends AsyncTask<Void,Void,Object> {

    Conexao c;



    public ArrayList<Questao> selectQuestao (String materia, String assunto, int ano) throws SQLException {
        String sql = "Select * from questao where enunciado like '%a%'";
        String user = "aluno";
        String senha = "aluno";
        String db = "Vestiba";
        String server = "localhost:5432/Vestiba";

        c = ConnectionHelper(user, senha, db, server);

//        c.createStatement();



        PreparedStatement stmt = c.doInBackground().prepareStatement(sql);
        ResultSet result = stmt.executeQuery();
        // stmt.setString(1, x);



        List<Questao> questoes = new ArrayList<Questao>();

        while (result.next()) {
            Questao q = new Questao();
            q.enunciado = (result.getString("enunciado"));
            q.anoquestao = (result.getInt("anoquestao"));
            questoes.add(q);
        }

        stmt.close();
        System.out.println(questoes);

        return (ArrayList<Questao>) questoes;

    }

    private Conexao ConnectionHelper(String user, String senha, String db, String server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try {
            Class.forName("org.postgresql.Driver");
            ConnectionURL = "jdbc:postgresql://" + server + ";"
                    + "databaseName=" + db + ";user=" + user
                    + ";password=" + senha + ";" + "ssl=false";
            connection = DriverManager.getConnection(ConnectionURL);

//            return connection;

        } catch (SQLException se) {
            Log.e("ERROR", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
return null;
    }

    @Override
    protected Object doInBackground(Void... voids) {
        return null;
    }
}
