package com.egmvdev.consumoapis.practica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egmvdev.consumoapis.practica.model.Persona

class RegistrarViewModel:ViewModel() {
    val persona =MutableLiveData<Persona>()
    fun obtenerPersona(perso:Persona){
        persona.postValue(perso)
    }
}