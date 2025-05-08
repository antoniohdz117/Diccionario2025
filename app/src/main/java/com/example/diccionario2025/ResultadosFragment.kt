package com.example.diccionario2025

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diccionario2025.databinding.FragmentResultadosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultadosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultadosFragment : Fragment() {

    private var _binding: FragmentResultadosBinding? = null
    private val binding get() = _binding

    //valor que posibilitara usar los metodos de la interfaz RetrofitServiceWords
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



    private fun obtenPalabra(){

        val word = AppPreferences.queryText
        retrofit.getPalabraFormada(a,b,c)


    }
}