package com.example.rolldicegit;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView rolldice;
    private ImageView dice;
    private int[] numerosDoDado = {
            R.drawable.diceum,
            R.drawable.dicedois,
            R.drawable.dicetres,
            R.drawable.dicequatro,
            R.drawable.dicecinco,
            R.drawable.diceseis
    };
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayerMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rolldice = findViewById(R.id.rollDice);
        dice = findViewById(R.id.dice);

        iniciarReproducaoMusica();

        MediaPlayer mediaPlayerClique = MediaPlayer.create(this, R.raw.dice);
        rolldice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerClique != null) {
                    mediaPlayerClique.start();
                }

                int numeroAleatorio = new Random().nextInt(numerosDoDado.length);
                dice.setImageResource(numerosDoDado[numeroAleatorio]);
            }
        });
    }

    private void iniciarReproducaoMusica() {
        mediaPlayer = MediaPlayer.create(this, R.raw.muscfundo);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberar recursos quando a atividade for destruída
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
