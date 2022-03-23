package com.example.grawkostki

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var SumP1: Int = 0
    private var SumP2: Int = 0
    private var ilosc: Int = 0

    private var guzik:Int=0
    private var guzik2:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.rollbutton1)
        val button2 = findViewById<Button>(R.id.rollbutton2)

        button.setOnClickListener {
            guzik+=1
                if(guzik==ilosc) {
                    result()
                }
            else{
                    rollDiceplayer1()
                }
        }
        button2.setOnClickListener {
            rollDiceplayer2()
            guzik2+=1
        }

        val img1p1 = findViewById<ImageView>(R.id.p1dice1)
        val img2p1 = findViewById<ImageView>(R.id.p1dice2)
        val img3p1 = findViewById<ImageView>(R.id.p1dice3)
        val img1p2 = findViewById<ImageView>(R.id.p2dice1)
        val img2p2 = findViewById<ImageView>(R.id.p2dice2)
        val img3p2 = findViewById<ImageView>(R.id.p2dice3)

        img1p1.setOnClickListener {

        }
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


                when (p2) {

                    0 -> {
                        ilosc = 1
                    }
                    1 -> {
                        ilosc = 2
                    }
                    2 -> {
                        ilosc = 3
                    }
                    else -> {
                        ilosc = 1
                    }
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }


    private fun rollDiceplayer1() {

        val kostka = Kostka()

                val roll = kostka.roll()

                val roll2 = kostka.roll()
                val roll3 = kostka.roll()
                updateTextplayer1(roll, roll2, roll3)
                UpdateImgplayer1(roll, roll2, roll3)
            }



    private fun rollDiceplayer2() {
        val kostka2 = Kostka()
        val roll4 = kostka2.roll()
        val roll5 = kostka2.roll()
        val roll6 = kostka2.roll()
        updateTextplayer2(roll4, roll5, roll6)
        UpdateImgplayer2(roll4, roll5, roll6)

    }

    private fun UpdateImgplayer1(roll: Int, roll2: Int, roll3: Int) {
        val dice1Img: ImageView = findViewById(R.id.p1dice1)
        val dice2Img: ImageView = findViewById(R.id.p1dice2)
        val dice3Img: ImageView = findViewById(R.id.p1dice3)
        dice1Img.setImageResource(resolveDrawable(roll))
        dice2Img.setImageResource(resolveDrawable(roll2))
        dice3Img.setImageResource(resolveDrawable(roll3))
    }

    private fun UpdateImgplayer2(roll4: Int, roll5: Int, roll6: Int) {
        val dice4Img: ImageView = findViewById(R.id.p2dice1)
        val dice5Img: ImageView = findViewById(R.id.p2dice2)
        val dice6Img: ImageView = findViewById(R.id.p2dice3)
        dice4Img.setImageResource(resolveDrawable(roll4))
        dice5Img.setImageResource(resolveDrawable(roll5))
        dice6Img.setImageResource(resolveDrawable(roll6))
    }

    fun resolveDrawable(value: Int): Int {
        return when (value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1

        }
    }

    fun updateTextplayer1(roll: Int, roll2: Int, roll3: Int) {
        val rollResultTxt = findViewById<TextView>(R.id.result)
        val wynik: Int
        val wynik2: Int
        SumP1 = roll + roll2 + roll3
        result()


    }

    fun updateTextplayer2(roll4: Int, roll5: Int, roll6: Int) {
        val rollResultTxt = findViewById<TextView>(R.id.result)
        val wynik: Int
        SumP2 = roll4 + roll5 + roll6
        result()

    }

    fun result() {
        val ResultTxt = findViewById<TextView>(R.id.result)
        if (SumP1 > SumP2) {
            ResultTxt.text = "Wygrał gracz 1"
        } else if (SumP1 < SumP2) {
            ResultTxt.text = "Wygrał gracz 2"
        } else if (SumP1 == SumP2) {
            ResultTxt.text = "Remis"
        }

    }

    fun howmany() {

    }
}
