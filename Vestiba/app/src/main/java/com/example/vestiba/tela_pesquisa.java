package com.example.vestiba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class tela_pesquisa extends AppCompatActivity {

    Button pesquisar;
    EditText ano_questao;
    EditText materia_questao;
    EditText assunto_mateira;
    int ano = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisa);

        pesquisar = (Button)findViewById(R.id.fazer_pesquisa);
        ano_questao = (EditText) findViewById(R.id.ano_questao);
        materia_questao = (EditText) findViewById(R.id.materia_questao);
        assunto_mateira = (EditText) findViewById(R.id.assunto_questao);

        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String anoString = ano_questao.getText().toString();
                try {
                    ano = Integer.parseInt(anoString);
                }catch (Exception e){
                    ano = 0;
                }

                String materia = materia_questao.getText().toString();
                String assunto = assunto_mateira.getText().toString();

                if (anoString.isEmpty() &&  materia.isEmpty() && assunto.isEmpty() ) {
                    Toast.makeText(tela_pesquisa.this, "Escolha pelo menos um filtro", Toast.LENGTH_SHORT).show();
                } else {
                    questao_DAO questaodao = new questao_DAO();

                    ArrayList<Questao> lista = null;

                    try {
                        lista  = questaodao.selectQuestao(materia, assunto, ano);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    if (lista!=null) {
                        Toast.makeText(tela_pesquisa.this, "Pesquisa realizada com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(tela_pesquisa.this, "Tente novamente!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
