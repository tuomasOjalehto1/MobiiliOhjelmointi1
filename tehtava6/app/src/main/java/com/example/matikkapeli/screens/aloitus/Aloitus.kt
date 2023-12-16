package com.example.matikkapeli.screens.aloitus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.matikkapeli.R
import com.example.matikkapeli.databinding.FragmentAloitusBinding


class Aloitus : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAloitusBinding>(inflater,
            R.layout.fragment_aloitus, container, false)
        //return inflater.inflate(R.layout.fragment_aloitus, container, false)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_aloitus_to_about)
        }
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_aloitus_to_saannot)
        }
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_aloitus_to_peli2)
        }

        return binding.root
    }
}