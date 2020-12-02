package com.example.desafio3digitalhouse.info_hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.desafio3digitalhouse.R
import com.google.android.material.appbar.MaterialToolbar
import com.squareup.picasso.Picasso

class InfoHqFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_info_hq, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val titulo = view.findViewById<TextView>(R.id.txtComicName)
        val descricao = view.findViewById<TextView>(R.id.txtResumo)
        val preco = view.findViewById<TextView>(R.id.txtPreco)
        val paginas = view.findViewById<TextView>(R.id.txtPaginas)
        val data = view.findViewById<TextView>(R.id.txtData)
 //       val imagemPromo = view.findViewById<ImageView>(R.id.imagePromo)
//        val capa = view.findViewById<ImageButton>(R.id.btnCover)

        val capa.src = arguments?.getString("Capa")
        titulo.text = arguments?.getString("TITULO")
        descricao.text = arguments?.getString("DESCRICAO")
        preco.text = arguments?.getString("PRECO")
        paginas.text = arguments?.getString("PAGINAS")
        data.text = arguments?.getString("DATAPUBLICACAO")


        Picasso.get()
            .load(capa)
            .into(view.findViewById<ImageButton>(R.id.btnCover))





        val navController = findNavController()

        val toolbarInfo = view.findViewById<MaterialToolbar>(R.id.tollbarInfo)
        toolbarInfo.setNavigationOnClickListener {
            navController.navigate(R.id.action_infoHqFragment_to_listaHQsFragment)
        }




    }
}


