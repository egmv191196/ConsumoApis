package com.egmvdev.consumoapis.saludo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egmvdev.consumoapis.saludo.model.Saludo
import com.egmvdev.consumoapis.saludo.model.SaludoProvider

class SaludoViewModel:ViewModel() {
    val saludo = MutableLiveData<Saludo>()

    fun obtenerSaludo(pos:Int){
        //seria como mandar a  traer un valor com retofit
        val saludoActual = SaludoProvider.obtenerSaludo(pos)
        saludo.postValue(saludoActual)
    }
}