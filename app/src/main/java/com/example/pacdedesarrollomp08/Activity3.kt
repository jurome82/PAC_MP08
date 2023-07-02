package com.example.pacdedesarrollomp08

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Activity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

      val btCamara : Button = findViewById(R.id.btnCamara)


        btCamara.setOnClickListener{ validacionPermisos() }


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


    private val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
       if(result.resultCode == Activity.RESULT_OK)
           intent = result.data
        val bitmap = intent?.extras?.get("data") as Bitmap
        val imgView = findViewById<ImageView>(R.id.ivFoto)
        imgView.setImageBitmap(bitmap)
    }

    //-------------------------------------------------------
    private fun validacionPermisos() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //Permiso no aceptado
            requerirPermisosdeCamara()
        }else{
            //Abrir camara
            abirCamara()
        }
    }//Fin de la Funcion de Validacion permisos.
    //-------------------------------------------------------

    //-------------------------------------------------------
    private fun abirCamara() {

            getAction.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))


        Toast.makeText(this, "Abriendo Camara", Toast.LENGTH_SHORT).show()
    }//Fin de la funcion para abrir la camara.
    //-------------------------------------------------------


    //-------------------------------------------------------
    private fun requerirPermisosdeCamara() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            //El Usuario rechazo los permisos
            Toast.makeText(this, "Permisos rechazados por el Usuario", Toast.LENGTH_SHORT).show()
        } else {
            //pedir permisos
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 777)
        }
    }//Fin de la funcion  requerirPermisosdeCamara
    //-------------------------------------------------------

    //-------------------------------------------------------
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 777){//Nuestros permisos.
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                abirCamara()
            }else{
                //el permiso no ha sido aceptado.
                Toast.makeText(this, "Permisos rechazados por Primera vez", Toast.LENGTH_SHORT).show()
            }
        }
    }//Fin de la funciononRequestPermissionsResult



}//Fin de MainActivity