package com.example.desafio3digitalhouse.register.view

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.desafio3digitalhouse.R
import com.google.android.material.appbar.MaterialToolbar

class RegisterFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        val toolbarRegister = view.findViewById<MaterialToolbar>(R.id.tollbarRegister)
        toolbarRegister.setNavigationOnClickListener {
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }

        view.findViewById<Button>(R.id.btnSave).setOnClickListener {

            var todosCamposValidos = true

            val name = view.findViewById<EditText>(R.id.edtNameRegister)
            val email = view.findViewById<EditText>(R.id.edtEmailRegister)
            val password = view.findViewById<EditText>(R.id.edtPasswordRegister)


            if (name.text.toString().isBlank()) {
                name.error = "Campo vazio"
                todosCamposValidos = false
            }

            if (email.text.toString().isBlank()) {
                email.error = "Campo vazio"
                todosCamposValidos = false
            }
            if (password.text.toString().isBlank()) {
                password.error = "Campo vazio"
                todosCamposValidos = false
                closeKeyboard()
            }
            if (todosCamposValidos) {
                name.text.clear()
                email.text.clear()
                password.text.clear()

                navController.navigate(R.id.action_registerFragment_to_listaHQsFragment)
            }
        }
    }

    private fun closeKeyboard() {
        val imm: InputMethodManager =
            _view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(_view.windowToken, 0)
    }
}