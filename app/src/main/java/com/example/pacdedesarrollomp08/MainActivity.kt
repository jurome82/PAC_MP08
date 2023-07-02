package com.example.pacdedesarrollomp08

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val reproductor: MediaPlayer = MediaPlayer.create(this,R.raw.cancion)
        reproductor.isLooping = true

        var btnPlay: ImageButton = findViewById(R.id.btnPlay)
        btnPlay.setOnClickListener {
            if (reproductor.isPlaying) {
                reproductor.pause()
                btnPlay.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24)
            }else{
                reproductor.start()
                btnPlay.setBackgroundResource(R.drawable.ic_baseline_stop_circle_24)
            }
        }


        //-------------------------------------------------------
        /**
         * Creamos variable boton para pasar de un Activity a otra
         */
        //Pasamos del Boton 1 llamamos a la Activity2
        var boton1: Button = findViewById(R.id.btnUno)
        boton1.setOnClickListener {
            val intent: Intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
        //Pasamos del Boton 2 llamamos a la Activity3
        var boton2: Button = findViewById(R.id.btn2)
        boton2.setOnClickListener {
            val intent: Intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }
        //Pasamos del Boton 3 llamamos a la Activity4
        var boton3: Button = findViewById(R.id.btn3)
        boton3.setOnClickListener {
            val intent: Intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }
        //-------------------------------------------------------------------------




    }//Fin del OnCreate

}//Fin de MainActivity