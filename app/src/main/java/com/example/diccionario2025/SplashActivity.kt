package com.example.diccionario2025

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splash)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        object : Thread() {
            override fun run(){
                super.run()
                sleep(3000)
                //#Intent es una clase
                //miDedoSimulandoUnIntent
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(Intent(intent))
                //pasar parametros a otra activity si es necesario
                intent.putExtra("nombrePrametro1", 20)
                intent.putExtra("nombreUsuario", "Juanito")
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                finish()
            }
        }
    }
}