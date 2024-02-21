package com.example.mytima

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mytima.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding

    private val numberList = mutableListOf<Int>()
    private val correctPassword = arrayListOf(1,2,3,4)
    private var attempts = 4


    private lateinit var sharedPreferences: SharedPreferences



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(layoutInflater, container, false)

        sharedPreferences = requireActivity().getSharedPreferences("logPass", Context.MODE_PRIVATE)
        initButtonClicks()


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initButtonClicks(){
        binding.button0.buttonClick()
        binding.button1.buttonClick()
        binding.button2.buttonClick()
        binding.button3.buttonClick()
        binding.button4.buttonClick()
        binding.button5.buttonClick()
        binding.button6.buttonClick()
        binding.button7.buttonClick()
        binding.button8.buttonClick()
        binding.button9.buttonClick()
        binding.clean.setOnClickListener { сleanPass() }
    }

    fun changeTextView(textView: TextView) {
        textView.text = numberList.joinToString()
    }

    fun сleanPass() {
        binding.view1.setBackgroundResource(R.drawable.bg_view_grey_oval)
        binding.view2.setBackgroundResource(R.drawable.bg_view_grey_oval)
        binding.view3.setBackgroundResource(R.drawable.bg_view_grey_oval)
        binding.view4.setBackgroundResource(R.drawable.bg_view_grey_oval)
        numberList.removeAll(numberList)
        changeTextView(binding.textView)
    }



    fun verifPass() {
        if (numberList == correctPassword) {
            navigateToCompleteScreen()
            editSharePreference(true)
        } else {
            Toast.makeText(requireContext(),"Неверный пароль", Toast.LENGTH_SHORT).show()
            сleanPass()
            editSharePreference(false)
            attempts--
            if (attempts == 0) {
                Toast.makeText(requireContext(), "Заблочен", Toast.LENGTH_SHORT).show()
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
                    binding.view1.setBackgroundResource(R.drawable.bg_view_white_oval)
                }

                1 -> {
                    numberList.add(numberInt)
                    binding.view2.setBackgroundResource(R.drawable.bg_view_white_oval)
                }

                2 -> {
                    numberList.add(numberInt)
                    binding.view3.setBackgroundResource(R.drawable.bg_view_white_oval)
                }

                3 -> {
                    numberList.add(numberInt)
                    binding.view4.setBackgroundResource(R.drawable.bg_view_white_oval)
                    verifPass()

                }

            }
            changeTextView(binding.textView)
        }
    }

    private fun editSharePreference(value: Boolean) {

        val editor = sharedPreferences.edit()
        editor.putBoolean("correctPassword", value)
        editor.apply()
    }

    private fun navigateToCompleteScreen() {
        if (sharedPreferences.getBoolean("correctPassword", true)) {
            val intent = Intent(requireActivity(), ListActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        } else {
            Toast.makeText(requireContext(), "false", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}