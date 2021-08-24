package com.ubaya.adv160418133week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class MainFragment : Fragment() {

    var number1: Int = Random.nextInt(0, 100)
    var number2: Int = Random.nextInt(0, 100)
    var result: Int = number1 + number2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtNumber1.text = number1.toString()
        txtNumber2.text = number2.toString()

        var score = 0;

        btnSubmit.setOnClickListener {
            if (txtInput.text.toString() == result.toString()) {
                score += 1
                txtScore.text = score.toString()
                txtInput.setText("")

                number1 = Random.nextInt(0, 100)
                number2 = Random.nextInt(0, 100)

                result = number1 + number2

                txtNumber1.text = number1.toString()
                txtNumber2.text = number2.toString()
            } else {
                val score = txtScore.text.toString()
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}