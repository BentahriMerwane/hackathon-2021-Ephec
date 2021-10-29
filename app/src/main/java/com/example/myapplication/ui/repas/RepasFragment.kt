package com.example.myapplication.ui.repas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRepasBinding
import com.example.myapplication.ui.gallery.RepasViewModel

class RepasFragment : Fragment() {

    private lateinit var repasViewModel: RepasViewModel
    private var _binding: FragmentRepasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repasViewModel =
            ViewModelProvider(this).get(RepasViewModel::class.java)

        _binding = FragmentRepasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.navRepas
        repasViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}