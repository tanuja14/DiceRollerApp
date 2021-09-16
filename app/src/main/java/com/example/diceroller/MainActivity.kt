package com.example.diceroller

import android.os.Bundle

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val rollButton2: Button = findViewById(R.id.button2)
        val score1: TextView = findViewById(R.id.player1Score)
        val score2: TextView = findViewById(R.id.player2Score)
        val turns1: TextView = findViewById(R.id.turns)
        val turns2: TextView = findViewById(R.id.turns2)


        rollButton.setOnClickListener { player1(turns1, score1, rollButton) }
        rollButton2.setOnClickListener { player2(turns2, score2, rollButton2) }
        player1(
            turns1,
            score1,
            rollButton
        )  //rolls the dice when the app starts with initial score and turns
        player2(
            turns2,
            score2,
            rollButton2
        )  //rolls the dice when the app starts with initial score and turns

    }


    /**
     * Roll the dice and update the screen with the result.
     */

    private fun player1(turns: TextView, score: TextView, button: Button) {
        val dice = Dice(6)   // Create new Dice object with 6 sides and roll the dice
        val diceRoll = dice.roll()
        dice.turnsleft(turns, button)

        val TotalScore = diceRoll + score.text.toString().toInt()
        score.text = Integer.toString(TotalScore)


        val diceImage: ImageView = findViewById(R.id.imageView)  // Find the ImageView in the layout
        val drawableResource =
            when (diceRoll) {   // Determine which drawable resource ID to use based on the dice roll
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


    private fun player2(turns: TextView, score: TextView, button: Button) {
        val dice = Dice(6)   // Create new Dice object with 6 sides and roll the dice
        val diceRoll = dice.roll()
        val TotalScore = diceRoll + score.text.toString().toInt()
        score.text = Integer.toString(TotalScore)
        dice.turnsleft(turns, button)


        val diceImage: ImageView =
            findViewById(R.id.imageView2)  // Find the ImageView in the layout
        val drawableResource =
            when (diceRoll) {   // Determine which drawable resource ID to use based on the dice roll
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

    fun turnsleft(turns: TextView, rollButton2: Button) {
        var turnsLeft = turns.text.toString().toInt()
        turnsLeft--
        turns.text = Integer.toString(turnsLeft)
        if (turnsLeft == 0) {
            rollButton2.isEnabled = false
            rollButton2.isClickable = false
        }

    }


}