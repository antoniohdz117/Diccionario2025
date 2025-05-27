package com.example.diccionario2025

import android.annotation.SuppressLint
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import android.os.Bundle
import android.text.Html.fromHtml
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diccionario2025.databinding.FragmentResultadosBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class ResultadosFragment : Fragment() {

    private var _binding: FragmentResultadosBinding? = null
    private val binding get() = _binding

    //valor que posibilitara usar los metodos de la interfaz RetrofitServiceWords atraves de trtrofit service word
    val retrofit = RetrofitFactoryWords.makeRetrofitService()


    class Word(
        val entrda: String,
        val superindice: String,
        val acepciones: Array<String>
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultadosBinding.inflate(inflater, container, false)
        val view = binding?.root
        obtenPalabra()

        // TODO: Ejecutar metodo para obtener palabra
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



    @SuppressLint("NotifyDataSetChanged")
    private fun obtenPalabra(){

        val word = AppPreferences.queryText
        val listaPalabrasViewModel= ArrayList<WorldViewModel>()
        val adapter = WordsAdapter(listaPalabrasViewModel)
        binding?.fragmentResultadosReciclerView?.adapter = adapter
        listaPalabrasViewModel.clear()

        //Creamos un nuevo hilo
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getPalabraFormada(word, "j1FUX2y7DklLgclZs5Nm6WaUjGcAgoR1", "appsunam")

            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    val words = response.body()!!.toList()
                    if(words.isNotEmpty()){
                        words.forEach{
                            val spEntrada = fromHtml(it.entrda)
                            val superindice = it.superindice
                            val acepciones = fromHtml(it.acepciones.joinToString("<br><br>"))

                            listaPalabrasViewModel.add(WorldViewModel(spEntrada,superindice,acepciones ))
                            adapter.notifyDataSetChanged()
                        }
                    }

                    }
                }
            }
        }
        //Codigo apr amantener y regarr el hlom principal




}