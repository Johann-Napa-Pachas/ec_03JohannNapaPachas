package com.example.ec_appmoviles.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ec_appmoviles.R
import com.example.ec_appmoviles.databinding.FragmentDetailBinding
import com.example.ec_appmoviles.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mostrar el mensaje en el TextView
        binding.txtMessage.text = "Soy el estudiante Johann Napa Pachas del 6to Ciclo de la Carrera de Desarrollo de Sistemas de Información con correo institucional: AT73581983@idat.edu.pe, esta app fue hecha exactamente para ver productos segun su categoria o usuario"
        binding.txtMessage.visibility = View.VISIBLE // Hacer el TextView visible
    }
}