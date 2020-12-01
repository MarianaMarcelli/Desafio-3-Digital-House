package com.example.desafio3digitalhouse.info_hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.desafio3digitalhouse.R
import com.google.android.material.appbar.MaterialToolbar

class InfoHqFragment : Fragment() {

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

        val navController = findNavController()

        val toolbarInfo = view.findViewById<MaterialToolbar>(R.id.tollbarInfo)
        toolbarInfo.setNavigationOnClickListener {
            navController.navigate(R.id.action_infoHqFragment_to_listaHQsFragment)
        }
    }
}


