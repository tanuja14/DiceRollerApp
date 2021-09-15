package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice() //rolls the dice when the app starts
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice() {
        val dice = Dice(6)   // Create new Dice object with 6 sides and roll the dice
        val diceRoll = dice.roll()
        val luckyNumber = 4
        val diceImage: ImageView = findViewById(R.id.imageView)  // Find the ImageView in the layout

        val drawableResource = when (diceRoll) {   // Determine which drawable resource ID to use based on the dice roll
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}