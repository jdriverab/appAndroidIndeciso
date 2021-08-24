package com.example.decideteome

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // coinToss()
        val coinButton: Button = findViewById(R.id.button)
        coinButton.setOnClickListener {
            coinToss()
        }
    }

    private fun coinToss(){
        val coin = RandomChoise(2)
        val coinRoll = coin.roll()
        val coinImage: ImageView = findViewById(R.id.imageView)
        val resultCoin: TextView = findViewById(R.id.textView2)

        val drawableResource = when(coinRoll){
            1 -> R.drawable.dogecoincara
            else -> R.drawable.dogecoinsello
        }
        val descriptionResource = when(coinRoll){
            1 -> "Cara"
            else -> "Sello"
        }
        coinImage.setImageResource(drawableResource)
        coinImage.contentDescription = descriptionResource
        resultCoin.setText(descriptionResource)
    }
}

class RandomChoise(val numOptions: Int){
    fun roll():Int {
        return (1..numOptions).random()
    }
}

