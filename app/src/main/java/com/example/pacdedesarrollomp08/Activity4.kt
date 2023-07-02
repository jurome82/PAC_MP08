package com.example.pacdedesarrollomp08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)




        //-------------------------------------------------------
        /**
         * Creamos variable boton para pasar de un Activity a otra
         */
        //Pasamos del Boton Volver llamamos a la MainActiviti (inicio)
        var botonIni: Button = findViewById(R.id.btnVolver)
        botonIni.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //-------------------------------------------------------

    }//Fin del OnCreate
}//Fin de MainActivity