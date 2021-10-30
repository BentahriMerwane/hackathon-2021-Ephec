package com.example.myapplication.ui.parametres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentParametresBinding

class ParametresFragment : Fragment() {

    private lateinit var parametreViewModel: ParametreViewModel
    private var _binding: FragmentParametresBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        parametreViewModel =
            ViewModelProvider(this).get(ParametreViewModel::class.java)

        _binding = FragmentParametresBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.navRepas
        parametreViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}