package com.example.vestiba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tela_pesquisa extends AppCompatActivity {

    Button pesquisar;
    EditText ano_questao;
    EditText materia_questao;
    EditText assunto_mateira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisa);

        pesquisar = (Button)findViewById(R.id.fazer_pesquisa);


        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesquisaIntent = new Intent(tela_pesquisa.this, tela_pesquisa.class);
                startActivity(pesquisaIntent);


            }
        });


    }
}
