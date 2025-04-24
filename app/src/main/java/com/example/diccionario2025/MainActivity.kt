package com.example.diccionario2025

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.diccionario2025.databinding.ActivityMainBinding
import com.example.diccionario2025.databinding.ContenedorMainBinding

class MainActivity : AppCompatActivity() {

    protected val mainActivity = this

    private lateinit var activityMaininding: ActivityMainBinding
    private lateinit var contenedorMainBinding: ContenedorMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMaininding = ActivityMainBinding.inflate(layoutInflater)
        contenedorMainBinding = ContenedorMainBinding.inflate(layoutInflater)

        val view = activityMaininding.root
        setContentView(view)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Iniciar appPreferences
        AppPreferences.init(mainActivity)

        var miBuscadorTop = mainActivity.findViewById<SearchView>(R.id.activity_main_searchview)
        miBuscadorTop.setOnClickListener() {
            miBuscadorTop.setQuery("", false)

        }

        miBuscadorTop.setOnQueryTextListener(object: SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                //guardamos la cadena busqueda en las appPreferences
                var queryText = miBuscadorTop.query
                AppPreferences.queryText = queryText.toString().trim()


                //Reseteamos el texto en el SearchView
                miBuscadorTop.setQuery("",false)

                //mostar el fragmemntde resultados
                replaceFragment(ResultadosFragment(), "Resultados")

                return false
            }//cierre de onQueryTextSubmit

        }//cierre del body
        )//cierre del setOnQueryTextListener

    }// fin onCreate

    private fun replaceFragment(fragment: Fragment,tag: String){

        val fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.activity_main_frame, fragment, tag)
        fr.commit()

    }


}// fin clase