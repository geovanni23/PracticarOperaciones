package ramirez.lopez.practicaroperaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        btnRegresar.setOnClickListener {
            val miSegundoIntent = Intent(this, MainActivity::class.java)
            startActivity(miSegundoIntent)
        }
    }
}
