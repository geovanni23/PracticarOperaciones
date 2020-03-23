package ramirez.lopez.practicaroperaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tercera.*

class TerceraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tercera)

        val textoOperacion = intent.getStringExtra("operacion")
        val intResultado = intent.getIntExtra("resultado", 0)

        tvError.text = textoOperacion
        tvRespuesta.text = "$intResultado"

        btnRegresar2.setOnClickListener {
            val miTercerIntent = Intent(this, MainActivity::class.java)
            startActivity(miTercerIntent)
        }
    }
}
