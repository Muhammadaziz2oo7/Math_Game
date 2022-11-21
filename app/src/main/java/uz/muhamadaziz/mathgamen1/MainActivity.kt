package uz.muhamadaziz.mathgamen1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_asosiy.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var random = Random()
    private var n1 = 0
    private var n2 = 0
    private var score = 0
    var myResult: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game(NumberData.easy)
        javoblar()

        checking.setOnClickListener {
            if (center.text.isEmpty()) {
                Toast.makeText(this, "Javobni kiriting", Toast.LENGTH_SHORT).show()
            } else {
                javoblar()
                game(NumberData.easy)
                center.text = ""
            }
        }
        bir.setOnClickListener { raqamlar("1", true) }
        ikki.setOnClickListener { raqamlar("2", true) }
        uch.setOnClickListener { raqamlar("3", true) }
        tort.setOnClickListener { raqamlar("4", true) }
        besh.setOnClickListener { raqamlar("5", true) }
        olti.setOnClickListener { raqamlar("6", true) }
        yetti.setOnClickListener { raqamlar("7", true) }
        sakkiz.setOnClickListener { raqamlar("8", true) }
        toqqiz.setOnClickListener { raqamlar("9", true) }
        nol.setOnClickListener { raqamlar("0", true) }
        minus.setOnClickListener { raqamlar("-", true) }
        delete.setOnClickListener {
            val string = center.text.toString()
            if (string.isNotEmpty()) {
                center.text = string.substring(0, string.length - 1)
            }
        }

        backSpace.setOnClickListener {
            startActivity(Intent(this,Asosiy_Activity::class.java))
        }

    }

    private fun game(a: Int) {

        n1 = random.nextInt(a)
        n2 = random.nextInt(a)

        val amal = random.nextInt(4)

        when (amal) {
            0 -> {
                myResult = n1 + n2
                operator.text = "+"
                raqam1.text = n1.toString()
                raqam2.text = n2.toString()
            }
            1 -> {
                myResult = n1 - n2
                operator.text = "-"
                raqam1.text = n1.toString()
                raqam2.text = n2.toString()
            }
            2 -> {
                myResult = n1 * n2
                operator.text = "*"
                raqam1.text = n1.toString()
                raqam2.text = n2.toString()
            }
            3 -> {
                if (n1 == 0 || n2 == 0) {
                    random = Random()
                } else {
                    myResult = n1 / n2
                    operator.text = "/"
                    raqam1.text = n1.toString()
                    raqam2.text = n2.toString()
                }
            }
        }
    }

    fun raqamlar(string: String, canClear: Boolean) {
        if (canClear) {
            center.append(string)
        }
    }

    fun javoblar() {
        if (center.text.toString() == myResult.toString()) {
            score++
            barchaJavoblar.text = score.toString()
            Toast.makeText(this, "true", Toast.LENGTH_SHORT).show()
        }else if (center.text.isEmpty()){
            Toast.makeText(this, "Javobni kiriting", Toast.LENGTH_SHORT).show()
        }else if(center.text.toString() != myResult.toString()){
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
        }
        if (score == 10) {
            startActivity(Intent(this, YutuqActivity::class.java))
            score = 0
            barchaJavoblar.text = ""
        }
    }
}



