package com.example.desafio3digitalhouse.info_hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.desafio3digitalhouse.R
import com.google.android.material.appbar.MaterialToolbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_cover_detail.*


class CoverDetailFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cover_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val imagemCapa = requireArguments().getString("CAPA")

        Picasso.get()
            .load(imagemCapa)
            .into(view.findViewById<ImageButton>(R.id.imageCoverDetail))

        val navController = findNavController()

        val closeButton = view.findViewById<ImageButton>(R.id.btnCloseCoverDetail)
        closeButton.setOnClickListener {
            navController.navigate(R.id.action_coverDetailFragment_to_infoHqFragment)
        }
    }
}
