package com.example.matikkapeli.screens.loppu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.matikkapeli.R
import com.example.matikkapeli.databinding.FragmentLoppuBinding


class Loppu : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoppuBinding>(
            inflater,
            R.layout.fragment_loppu, container, false
        )
        ViewModelProvider(this)[loppuViewModel::class.java]



        binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_loppu_to_resultFragment)

        }





        return binding.root
    }

}