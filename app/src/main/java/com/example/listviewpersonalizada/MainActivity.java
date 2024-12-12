package com.example.listviewpersonalizada;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private RadioButton radioButtonPulsado;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        mensaje = findViewById(R.id.texto);

        ArrayList<Object[]> d = new ArrayList<>();
        d.add(new Object[]{R.drawable.java, "Java", "Plataforma informática de lenguaje de programación creada por Sun Microsystems en 1995."});
        d.add(new Object[]{R.drawable.python, "Python", "Utilizado en las aplicaciones web, el desarrollo de software, la ciencia de datos y el machine learning"});
        d.add(new Object[]{R.drawable.sql, "SQL", "Conjunto de sentencias que permiten consultar y manipular datos almacenados en BBDD."});
        d.add(new Object[]{R.drawable.kotlin, "Kotlin", "Lenguaje de programación de código abierto y tipado estático, creado por la empresa JetBrains."});
        d.add(new Object[]{R.drawable.swift, "Swift", "Lenguaje de Apple para crear apps para iPhone, iPad, Mac, Apple Watch y Apple TV."});

        Adaptador adaptador = new Adaptador(this, R.layout.entrada, d) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    Object[] datos = (Object[]) entrada;
                    TextView textoTitulo = view.findViewById(R.id.texto_titulo);
                    TextView textoDatos = view.findViewById(R.id.texto_datos);
                    ImageView imagen = view.findViewById(R.id.imagen);
                    RadioButton miRadio = view.findViewById(R.id.boton);

                    textoTitulo.setText((String) datos[1]); // Lenguaje de programación
                    textoDatos.setText((String) datos[2]); // Descripción
                    imagen.setImageResource((int) datos[0]); // Imagen

                    miRadio.setOnClickListener(v -> {
                        if (radioButtonPulsado != null) {
                            radioButtonPulsado.setChecked(false);
                        }
                        radioButtonPulsado = miRadio;
                        miRadio.setChecked(true);
                        mensaje.setText("MARCADA UNA OPCIÓN");
                    });
                }
            }
        };
        lista.setAdapter(adaptador);
    }
}
