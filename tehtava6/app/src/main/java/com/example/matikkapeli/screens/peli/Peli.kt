package com.example.matikkapeli.screens.peli

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.matikkapeli.R
import com.example.matikkapeli.databinding.FragmentPeliBinding


class Peli : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPeliBinding>(inflater,
            R.layout.fragment_peli, container, false)


       var viewModel = ViewModelProvider(this)[peliViewModel::class.java]


        viewModel.setQuestion()

        binding.luku1.text = viewModel.numero1.toString()
        binding.luku2.text = viewModel.numero2.toString()


        //binding.kysymyslaskuri.text = viewModel.pisteet.toString()

        viewModel.currentNumber.observe(this, Observer {
            binding.kysymyslaskuri.text = it.toString()

        })


        //Nappia painetaan ja napin painaminen muuttaa vastauksen integeriksi jota verrataan kysymykseen
        binding.button4.setOnClickListener {
                var luku1 : String = binding.luku1.text.toString()
                var final_luku1 = luku1.toInt()
                var luku2 : String = binding.luku2.text.toString()
                var final_luku2 = luku2.toInt()
                var testi : String = binding.vastaus.text.toString()
                var final_ansver = testi.toInt()
                if (final_luku1+final_luku2==final_ansver){
                    viewModel.lisaapiste()
                    binding.kysymyslaskuri.text = "${viewModel.pisteet}/4"
                    viewModel.setQuestion()
                    binding.luku1.text = viewModel.numero1.toString()
                    binding.luku2.text = viewModel.numero2.toString()
                    if (viewModel.pisteet==4){
                        findNavController().navigate(R.id.action_peli_to_loppu)
                    }
                }


                }


        return binding.root
    }



}