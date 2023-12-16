package com.example.matikkapeli.screens.peli

import android.annotation.SuppressLint
import android.os.Bundle
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


        viewModel.pisteet.observe(this, Observer {
            binding.kysymyslaskuri.text = "${it.toString()}/4"
            if (it==4){

                findNavController().navigate(R.id.action_peli_to_loppu)
            }
        })

        viewModel.numero1.observe(this, Observer {
            binding.luku1.text = it.toString()
        })

        viewModel.numero2.observe(this, Observer {
            binding.luku2.text = it.toString()
        })

        //viewModel.secondscount.observe(this, Observer {
        //    Log.i("Aika", viewModel.secondscount.toString())
        //})


        //Nappia painetaan ja napin painaminen muuttaa vastauksen integeriksi jota verrataan kysymykseen
        binding.button4.setOnClickListener {

            var ansver : String = binding.vastaus.text.toString();

            viewModel.checkAnswer(ansver);
            binding.vastaus.text.clear()

        }


        return binding.root
    }



}