package com.example.mytima



import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val numberList = mutableListOf<Int>()
    private val correctPassword = arrayListOf(1,2,3,4)
    private var attempts = 4

    private lateinit var sharedPreferences: SharedPreferences

    lateinit var text0: TextView
    lateinit var textList: TextView

    lateinit var password1: View
    lateinit var password2: View
    lateinit var password3: View
    lateinit var password4: View

    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var buttonOk: Button
    lateinit var buttonClean: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_for, BlankFragment.newInstance())
            .commit()

        sharedPreferences = getSharedPreferences("logPass", Context.MODE_PRIVATE)
        initAllViewInScreen()
        initButtonClicks()


    }

    private fun initAllViewInScreen() {
        text0 = findViewById<TextView>(R.id.listList)
        textList = findViewById<TextView>(R.id.textView)

        password1 = findViewById<View>(R.id.view_1)
        password2 = findViewById<View>(R.id.view_2)
        password3 = findViewById<View>(R.id.view_3)
        password4 = findViewById<View>(R.id.view_4)

        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonOk = findViewById(R.id.buttonOk)
        buttonClean = findViewById(R.id.clean)
    }
    private fun initButtonClicks(){
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
        buttonClean.setOnClickListener { сleanPass() }
    }

    fun changeTextView(textView: TextView) {
        textView.text = numberList.joinToString()
    }

    fun сleanPass() {
        password1.setBackgroundResource(R.drawable.bg_view_grey_oval)
        password2.setBackgroundResource(R.drawable.bg_view_grey_oval)
        password3.setBackgroundResource(R.drawable.bg_view_grey_oval)
        password4.setBackgroundResource(R.drawable.bg_view_grey_oval)
        numberList.removeAll(numberList)
        changeTextView(textList)
    }



    fun verifPass() {
        if (numberList == correctPassword) {
            navigateToCompleteScreen()
            editSharePreference(true)
        } else {
            Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show()
            сleanPass()
            editSharePreference(false)
            attempts--
            if (attempts == 0) {
                Toast.makeText(this, "Заблочен", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun Button.buttonClick() {
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

    private fun editSharePreference(value: Boolean) {

        val editor = sharedPreferences.edit()
        editor.putBoolean("correctPassword", value)
        editor.apply()
    }

    private fun navigateToCompleteScreen() {
        if (sharedPreferences.getBoolean("correctPassword", true)) {
            val intent = Intent(this, ListActivity2::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, BlankFragment::class.java)
            startActivity(intent)
            Toast.makeText(this, "false", Toast.LENGTH_SHORT).show()
        }
    }
}





