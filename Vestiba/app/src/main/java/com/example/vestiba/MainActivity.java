package com.example.vestiba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesquisa = (Button)findViewById(R.id.convidado);

        pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesquisaIntent = new Intent(MainActivity.this, tela_pesquisa.class);
                startActivity(pesquisaIntent);
            }
        });

        Conexao c = new Conexao();
        c.execute();
    }
}
