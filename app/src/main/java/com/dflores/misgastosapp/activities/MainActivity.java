package com.dflores.misgastosapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dflores.misgastosapp.R;
import com.dflores.misgastosapp.repositories.OperationsRepository;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton registerButton;
    ImageButton btn_bahorro, btn_bcredito, btn_befectivo;
    TextView saldo1, saldo2, saldo3;
    ProgressBar progressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.register_fb);
        btn_bahorro = findViewById(R.id.buscar_ahorro);
        btn_bcredito = findViewById(R.id.buscar_credito);
        btn_befectivo = findViewById(R.id.buscar_efectivo);
        saldo1 = findViewById(R.id.saldo1);
        saldo2 = findViewById(R.id.saldo2);
        saldo3 = findViewById(R.id.saldo3);
        progressBar = findViewById(R.id.progress_bar);

        double numero = OperationsRepository.total_global();
        Log.e("main asgfasgagasgba","monto: "+numero);
        progressBar.setProgress((int)Math.round(numero));

        saldo1.setText("S/."+String.valueOf(OperationsRepository.total("Ahorro")));
        saldo2.setText("S/."+String.valueOf(OperationsRepository.total("Tarjeta de Crédito")));
        saldo3.setText("S/."+String.valueOf(OperationsRepository.total("Efectivo")));

        btn_bahorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent(getApplicationContext(), DetailActivity.class);
                q.putExtra("valor", "Ahorro");
                startActivity(q);
            }
        });


        btn_bcredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), DetailActivity.class);
                p.putExtra("valor", "Tarjeta de Crédito");
                startActivity(p);
            }
        });


        btn_befectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(getApplicationContext(), DetailActivity.class);
                w.putExtra("valor", "Efectivo");
                startActivity(w);

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewOperationActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
