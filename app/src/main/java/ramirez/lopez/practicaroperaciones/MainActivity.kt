package ramirez.lopez.practicaroperaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var resultado = 0
    var textoOperacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generarOperacion()

        btnVerificar.setOnClickListener {
            if(etRespuesta.text.isNotEmpty()){
                verificarRespuesta()
            }else{
                m("Escribe una respuesta")
            }
        }
    }

    fun m(mensaje:String){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
    }

    fun verificarRespuesta(){
        var i = Intent()
        if (etRespuesta.text.toString().toInt() == resultado){
            //m("Correcto!")
            i = Intent(this, SegundaActivity::class.java)
        }else{
            //m("Incorrecto!")
            i = Intent(this, TerceraActivity::class.java)
            i.putExtra("resultado", resultado)
            i.putExtra("operacion", textoOperacion)
        }
        startActivity(i)
        generarOperacion()
    }

    fun generarOperacion(){
        etRespuesta.text.clear()

        val listaOperaciones = listOf("+","-","*")
        val num1 = Random.nextInt(0, 11)
        val num2 = Random.nextInt(0, 11)
        val operacionRealizar = listaOperaciones[Random.nextInt(0, 3)]

        when(operacionRealizar){
            "+"->{
                resultado = num1 + num2
                textoOperacion = "$num1 + $num2 = ?"
            }
            "-"->{
                resultado = num1 - num2
                textoOperacion = "$num1 - $num2 = ?"
            }
            "*"->{
                resultado = num1 * num2
                textoOperacion = "$num1 x $num2 = ?"
            }
        }

        tvOperacion.text = textoOperacion
    }
}
