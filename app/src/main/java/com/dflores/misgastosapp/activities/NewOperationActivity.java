package com.dflores.misgastosapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.dflores.misgastosapp.R;
import com.dflores.misgastosapp.models.OperationsModel;
import com.dflores.misgastosapp.repositories.OperationsRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.RandomAccess;

public class NewOperationActivity extends AppCompatActivity {
    Spinner spinner;
    Button registrar_btn ;
    RadioButton r1;
    RadioButton r2;
    EditText monto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        spinner = findViewById(R.id.spinner_tipo);
        registrar_btn = findViewById(R.id.btn_register);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        monto = findViewById(R.id.monto);

        registrar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

    }

    private void add(){
        String saldo = spinner.getSelectedItem().toString();
        String cantidad = monto.getText().toString();
        String tipo;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        if(r1.isChecked()){
            tipo = "Ingresos";
        }else{
            tipo = "Egresos";
        }
        OperationsRepository.agregar(date, tipo, cantidad, saldo);
        Intent e = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(e);
        finish();
    }
}
