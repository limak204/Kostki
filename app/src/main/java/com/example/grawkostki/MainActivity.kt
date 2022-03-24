package com.example.grawkostki

import android.content.Context
import android.graphics.Color
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    var flashLightStatus: Boolean = false
    private var SumP1: Int = 0
    private var SumP2: Int = 0
    private var ilosc: Int = 0
    private var sum:Int=0
    private var guzik:Int=0
    private var guzik2:Int=0
    @RequiresApi(Build.VERSION_CODES.M)
    private fun openFlashLight() {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]

        if (!flashLightStatus) {
            try {
                cameraManager.setTorchMode(cameraId, true)
                var flashLightStatus = true

            } catch (e: CameraAccessException) {
            }
        } else {
            try {
                cameraManager.setTorchMode(cameraId, false)
                var flashLightStatus = false
            } catch (e: CameraAccessException) {
            }
        }

    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFlashLight()

        val button = findViewById<Button>(R.id.rollbutton1)
        val button2 = findViewById<Button>(R.id.rollbutton2)

        button.setOnClickListener {
            rollDiceplayer1()
            guzik += 1
            result()

        }
        button2.setOnClickListener {
            rollDiceplayer2()
            guzik2 += 1
            result()
        }

        val img1p1 = findViewById<ImageView>(R.id.p1dice1)
        val img2p1 = findViewById<ImageView>(R.id.p1dice2)
        val img3p1 = findViewById<ImageView>(R.id.p1dice3)
        val img1p2 = findViewById<ImageView>(R.id.p2dice1)
        val img2p2 = findViewById<ImageView>(R.id.p2dice2)
        val img3p2 = findViewById<ImageView>(R.id.p2dice3)


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
                if(ilosc!=guzik&&guzik<ilosc) {


                        updateTextplayer1(roll, roll2, roll3)
                        UpdateImgplayer1(roll, roll2, roll3)
                     //   result()

                }
            }



    private fun rollDiceplayer2() {
        val kostka2 = Kostka()
        val roll4 = kostka2.roll()
        val roll5 = kostka2.roll()
        val roll6 = kostka2.roll()
        if(ilosc!=guzik2&&guzik2<ilosc) {
            updateTextplayer2(roll4, roll5, roll6)
            UpdateImgplayer2(roll4, roll5, roll6)
           // result()
        }
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


            SumP1 += (roll + roll2 + roll3)


       // rollResultTxt.text= SumP1.toString()
        //result()

    }

    fun updateTextplayer2(roll4: Int, roll5: Int, roll6: Int) {
        val rollResultTxt = findViewById<TextView>(R.id.result)
        val wynik: Int

            SumP2 += roll4 + roll5 + roll6


      //  rollResultTxt.text= SumP2.toString()


    }

    fun result() {
        val ResultTxt = findViewById<TextView>(R.id.result)
        if(ilosc==guzik&&ilosc==guzik2) {

            if (SumP1 > SumP2) {
                ResultTxt.text = "Wygrał gracz 1"
            } else if (SumP1 < SumP2) {
                ResultTxt.text = "Wygrał gracz 2"
            } else if (SumP1 == SumP2) {
                ResultTxt.text = "Remis"
            }
        }
    }

       /* fun suma(){
        val ResultTxt = findViewById<TextView>(R.id.result)
        if(ilosc!=guzik&&guzik<ilosc) {
            SumP1+=SumP1

        }
        ResultTxt.text=SumP1.toString()
        }*/
        fun compare(){


        }
}
