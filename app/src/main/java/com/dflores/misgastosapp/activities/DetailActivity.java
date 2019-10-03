package com.dflores.misgastosapp.activities;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dflores.misgastosapp.R;
import com.dflores.misgastosapp.adapters.OperationsAdapter;
import com.dflores.misgastosapp.repositories.OperationsRepository;

public class DetailActivity extends AppCompatActivity {

    TextView monto, detail;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail = findViewById(R.id.dtlTitle);
        monto = findViewById(R.id.suma);

        recyclerView = findViewById(R.id.f_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String valor = getIntent().getExtras().getString("valor");
        OperationsAdapter adapter = new OperationsAdapter();
        adapter.setOperaciones(OperationsRepository.getOperation(valor));
        monto.setText(String.valueOf(OperationsRepository.total(valor)));
        detail.setText("Saldo Actual "+valor);
        recyclerView.setAdapter(adapter);

    }
}
