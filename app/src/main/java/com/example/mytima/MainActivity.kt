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

    override fun onStart() {
        super.onStart()

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

        if (!sharedPreferences.getBoolean("correctPassword", true)) {
            val intent = Intent(this, ListActivity2::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
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

        fun Button.buttonClick(){
            setOnClickListener {
                val buttonText = (it as Button).text.toString()
                val numberInt = buttonText.toInt()
                when (numberList.size) {
                    0 -> {
                        numberList.add(numberInt)
                        password1.setBackgroundResource(R.drawable.bg_view_white_oval)
                    }
                    1 -> {
                        numberList.add(numberInt)
                        password2.setBackgroundResource(R.drawable.bg_view_white_oval)
                    }
                    2 -> {
                        numberList.add(numberInt)
                        password3.setBackgroundResource(R.drawable.bg_view_white_oval)
                    }
                    3 -> {
                        numberList.add(numberInt)
                        password4.setBackgroundResource(R.drawable.bg_view_white_oval)
                        verifPass()
                    }
                }
                changeTextView(textList)
            }
        }


        button0.buttonClick()
        button1.buttonClick()
        button2.buttonClick()
        button3.buttonClick()
        button4.buttonClick()
        button5.buttonClick()
        button6.buttonClick()
        button7.buttonClick()
        button8.buttonClick()
        button9.buttonClick()
        buttonClean.setOnClickListener {
            сleanPass()

        }
    }
}



