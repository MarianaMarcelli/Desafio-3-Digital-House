package com.example.desafio3digitalhouse.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.desafio3digitalhouse.R

class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkbox = view.findViewById<CheckBox>(R.id.checkBoxRemember)
            checkbox.isChecked = false

        val navController = findNavController()

        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            var camposValidos = true

            val emailLogin = view.findViewById<EditText>(R.id.edtEmailLogin)
            val passwordLogin = view.findViewById<EditText>(R.id.edtPasswordLogin)

            if (emailLogin.text.toString().isBlank()) {
                emailLogin.error = "Campo vazio"
                camposValidos = false
            }
            if (passwordLogin.text.toString().isBlank()) {
                passwordLogin.error = "Campo vazio"
                camposValidos = false
            }
            if (camposValidos) {
                emailLogin.text?.clear()
                passwordLogin.text?.clear()

                navController.navigate(R.id.action_loginFragment_to_listaHQsFragment)
            }
        }
        view.findViewById<Button>(R.id.btnCreatAccount).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment2)
        }
    }
}
