package com.example.myapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.ui.commande.CommandeFragment

class LoginFragment : Fragment() {
    private lateinit var loginViewModel: LoginViewModel

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val textView: TextView = binding.navLogin
        loginViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}