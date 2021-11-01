package com.example.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
/*
this is a simple dice roller program
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //the button in my layout view is being brought into my activity
        val Button=findViewById<Button>(R.id.button)

        //the image container in my layout view is being brought into my activity
        val image=findViewById<ImageView>(R.id.imageView2)

        //my button is given functionality
        Button.setOnClickListener{
            //generate a random number with the roll dice function in the Dice object
           val roll=Dice.rollDice()

            //selecting the image for the image container based on the previously  selected number
            when(roll) {
                1->image.setImageResource(R.drawable.dice_1)
                2->image.setImageResource(R.drawable.dice_2)
                3->image.setImageResource(R.drawable.dice_3)
                4->image.setImageResource(R.drawable.dice_4)
                5->image.setImageResource(R.drawable.dice_5)
                else-> image.setImageResource(R.drawable.dice_6)
            }
            //a toast to indicate that my button was clicked
            Toast.makeText(this,"dice rolled",Toast.LENGTH_SHORT).show()

            //set the description of the image
            image.contentDescription= roll.toString()
        }
    }


}
//this is my dice object
object Dice{
    //this is my roll dice function which generates a random number between 1 and 6 and returns it as output
    fun  rollDice():Int= (1..6).random()

}