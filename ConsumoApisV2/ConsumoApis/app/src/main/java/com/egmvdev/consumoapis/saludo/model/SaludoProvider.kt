package com.egmvdev.consumoapis.saludo.model

class SaludoProvider {
    companion object{
        fun obtenerSaludo(pos:Int):Saludo{
            var salDef = Saludo(0,"")
            if (pos > 0 && pos < 6){
                for(sal in saludos){
                    if(sal.pos == pos){
                        salDef = sal
                        break
                    }
                }
            }
            return salDef
        }
        private  val saludos = listOf(
            Saludo(1,"Que ondas"),
            Saludo(2,"¿Cómo andas?"),
            Saludo(3,"Que me cuentas"),
            Saludo(4,"Arigatoo"),
            Saludo(5,"Buenos dias")
        )
    }
}