package com.example.vestiba;

import java.sql.SQLException;

public class questaoDAO {
    conexao conex;

    public boolean selectQuestao (String assunto, String materia, int ano){
        try{

            return true;
        } catch (Exception e){
            return false;
        }
    }
}
