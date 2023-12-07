package com.example.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val diceImage1 = binding.dice1
        val diceImage2 = binding.dice2

        binding.diceStartBtn.setOnClickListener {

            Log.d("MainActivity" , Random.nextInt(1, 6).toString())
            Log.d("MainActivity" , Random.nextInt(1, 6).toString())

            val dice1 = Random.nextInt(1, 6)
            val dice2 = Random.nextInt(1, 6)


            diceImage1.setImageResource(getDiceResource(dice1))
            diceImage2.setImageResource(getDiceResource(dice2))


            if (dice1 == dice2) {
                Toast.makeText(this, "똑같은 숫자가 나왔네요!", Toast.LENGTH_SHORT).show()
            }
            
        }


    }
}


private fun getDiceResource(number: Int): Int {
    return when (number) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

