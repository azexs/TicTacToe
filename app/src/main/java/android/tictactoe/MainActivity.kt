package android.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMulti = findViewById<Button>(R.id.btnMulti)
        val btnSingle = findViewById<Button>(R.id.btnSingle)



        btnMulti.setOnClickListener(){
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
        btnSingle.setOnClickListener(){
            startActivity(Intent(this@MainActivity, ThirdActivity::class.java))
        }

    }
}
