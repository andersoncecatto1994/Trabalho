package com.example.usuario.pesquisa;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pesquisar extends AppCompatActivity {

    private Button btnBom, btnRuim, btnResultado, btnIniciar;
    private Integer totBom = 0;
    private Integer totRuim = 0;
    private Integer resBom, resRuim;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pesquisar);

        btnBom = (Button) findViewById(R.id.btnBom);
        btnRuim = (Button) findViewById(R.id.btnRuim);
        btnResultado = (Button) findViewById(R.id.btnResultado);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);

        sp = this.getSharedPreferences("Votos", 0);
        SharedPreferences.Editor edt = sp.edit();
        sp.getInt("bom", 0);
        sp.getInt("ruim", 0);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               limpar();
                Toast.makeText(Pesquisar.this, "Contadores Reiniciados. Pode iniciar uma nova Pesquisa", Toast.LENGTH_LONG).show();
                return;
            }
        });

        btnBom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totBom = sp.getInt("bom", 0);
                totBom = totBom + 1;
                SharedPreferences.Editor edt = sp.edit();
                edt.putInt("bom", totBom);
                edt.commit();
            }
        });

        btnRuim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totRuim = sp.getInt("ruim", 0);
                totRuim = totRuim + 1;
                SharedPreferences.Editor edt = sp.edit();
                edt.putInt("ruim", totRuim);
                edt.commit();
            }
        });

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resBom = sp.getInt("bom", 0);
                resRuim = sp.getInt("ruim", 0);
                Toast.makeText(Pesquisar.this, "Votos Bons: " + resBom + "\n" + "Votos Ruins: " + resRuim, Toast.LENGTH_LONG).show();
                return;
            }
        });
    }

    public void limpar() {
        SharedPreferences.Editor edt = sp.edit();
        edt.putInt("bom",0);
        edt.putInt("ruim",0);
        edt.commit();
    }
}
