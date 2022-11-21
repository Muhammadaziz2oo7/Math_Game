package uz.muhamadaziz.mathgamen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_asosiy.*

class Asosiy_Activity : AppCompatActivity() {
    val main = MainActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asosiy)

        easy.setOnClickListener {
            NumberData.easy = 100
            startActivity(Intent(this,MainActivity::class.java))
        }
        hard.setOnClickListener {
            NumberData.easy = 500
            startActivity(Intent(this,MainActivity::class.java))
        }
        expert.setOnClickListener {
            NumberData.easy = 1000
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}