package com.balivo.basiccardview

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_car_detail.*
class CarDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setTitleAndImage()
    }
    private fun setTitleAndImage() {
        val intent = intent
        // Get the car title that was passed and set it as
        // the title for the toolbar
        val carTitle = intent.getStringExtra("CAR_TITLE")
        supportActionBar!!.title = carTitle
// Set the Image to the ImageView that we added
        val carImage = ContextCompat
                .getDrawable(this, intent.getIntExtra("CAR_IMAGE", 0))
        img_car_expanded.setImageDrawable(carImage)
    }
}