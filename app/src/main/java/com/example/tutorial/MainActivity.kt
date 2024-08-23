package com.example.tutorial

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceNumber: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        diceNumber = findViewById(R.id.diceView);
        val rollButton: Button = findViewById(R.id.roll_button);
        rollButton.setOnClickListener {
           rollDice();
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1;
        val drawableResource = when(randomInt)  {
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6;
        }
        diceNumber.setImageResource(drawableResource);
    }
}