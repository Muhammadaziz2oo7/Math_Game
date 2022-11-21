package uz.muhamadaziz.mathgamen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_yutuq.*

class YutuqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yutuq)

        qaytish.setOnClickListener {
            startActivity(Intent(this,Asosiy_Activity::class.java))
        }
    }
}