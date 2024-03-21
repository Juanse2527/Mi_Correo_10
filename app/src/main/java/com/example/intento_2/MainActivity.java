package com.example.intento_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final int DETAIL_REQUEST_CODE = 1;
    private RecyclerView recyclerView;
    private EmailAdapter emailAdapter;
    private List<Email> emailList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailList = new ArrayList<>();
        emailList.add(new Email(1, "Sdelrio", "Trabajo de practicas", "Hola equipo, recordatorio de nuestra reunión mañana a las 10 AM.", "2025-03-20"));
        emailList.add(new Email(2, "Sergio", "Revison de Proyecto", "Enviame las notas ", "2024-03-19"));
        emailList.add(new Email(3, "Laura", "Compra de chaqueta", "Confirmamos la recepción de su pedido. Pronto estará en camino.", "2001-03-30"));


        recyclerView = findViewById(R.id.recyclerViewEmails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        emailAdapter = new EmailAdapter(this, emailList);
        recyclerView.setAdapter(emailAdapter);


        emailAdapter.setOnItemClickListener(new EmailAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Email email = emailList.get(position);
                Intent intent = new Intent(MainActivity.this, DetalleEmailActivity.class);
                intent.putExtra("sender", email.getSender());
                intent.putExtra("subject", email.getSubject());
                intent.putExtra("content", email.getContent());
                intent.putExtra("date", email.getDate());
                startActivityForResult(intent, DETAIL_REQUEST_CODE);
            }
        });
    }

}