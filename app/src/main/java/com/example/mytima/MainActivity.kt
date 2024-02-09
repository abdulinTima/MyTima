package com.example.mytima


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberList = mutableListOf<Int>()
        val correctPassword = arrayListOf(1,2,3,4)

        var attempts = 5

        val text0 = findViewById<TextView>(R.id.listList)
        val textList = findViewById<TextView>(R.id.textView)
        val password1 = findViewById<View>(R.id.view_1)
        val password2 = findViewById<View>(R.id.view_2)
        val password3 = findViewById<View>(R.id.view_3)
        val password4 = findViewById<View>(R.id.view_4)
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonOk: Button = findViewById(R.id.buttonOk)
        val buttonClean: Button = findViewById(R.id.clean)

        fun pass1BgW() { password1.setBackgroundResource(R.drawable.bg_view_white_oval) }
        fun pass2BgW() { password2.setBackgroundResource(R.drawable.bg_view_white_oval) }
        fun pass3BgW() { password3.setBackgroundResource(R.drawable.bg_view_white_oval) }
        fun pass4BgW() { password4.setBackgroundResource(R.drawable.bg_view_white_oval) }
        fun pass4BgG() { password4.setBackgroundResource(R.drawable.bg_view_grey_oval) }

        fun changeTextView(textView: TextView) {
            textView.text = numberList.joinToString()
        }
        fun сleanPass(){
            password1.setBackgroundResource(R.drawable.bg_view_grey_oval)
            password2.setBackgroundResource(R.drawable.bg_view_grey_oval)
            password3.setBackgroundResource(R.drawable.bg_view_grey_oval)
            password4.setBackgroundResource(R.drawable.bg_view_grey_oval)
            numberList.removeAll(numberList)
            changeTextView(textList)
        }

        val sharedPreferences = getSharedPreferences("logPass", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply()

        if (sharedPreferences.getBoolean("correctPassword", true) == true) {
            val intent = Intent(this, ListActivity2::class.java)
            startActivity(intent)
        }


        fun verifPass(){
            if (numberList == correctPassword) {
                val intent = Intent(this, ListActivity2::class.java)
                startActivity(intent)
                editor.putBoolean("correctPassword", true)

            } else {
                Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show()
                сleanPass()
                editor.putBoolean("correctPassword", false)
                attempts--
                if (attempts == 0){
                        Toast.makeText(this, "Заблочен", Toast.LENGTH_SHORT).show()
                }
            }
            editor.apply()
        }

        button0.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(0)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(0)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(0)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(0)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button1.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(1)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(1)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(1)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(1)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button2.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(2)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(2)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(2)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(2)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button3.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(3)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(3)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(3)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(3)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button4.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(4)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(4)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(4)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(4)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button5.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(5)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(5)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(5)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(5)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button6.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(6)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(6)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(6)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(6)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button7.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(7)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(7)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(7)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(7)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button8.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(8)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(8)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(8)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(8)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        button9.setOnClickListener {
            when (numberList.size) {
                0 -> {
                    numberList.add(9)
                    pass1BgW()
                }
                1 -> {
                    numberList.add(9)
                    pass2BgW()
                }
                2 -> {
                    numberList.add(9)
                    pass3BgW()
                }
                3 -> {
                    numberList.add(9)
                    pass4BgW()
                    verifPass()
                }
            }
            changeTextView(textList)
        }
        buttonClean.setOnClickListener {
            сleanPass()
        }



//        buttonOk.setOnClickListener {
//            verifPass()
//            if (numberList == correctPassword) {
//                val intent = Intent(this, ListActivity2::class.java)
//                startActivity(intent)
//
//            } else {
//                attempts--
//                if (attempts == 0){
//                    Toast.makeText(this, "Заблочен", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show()
//                    сleanPass()
//                }
//            }
//        }
    }
}



