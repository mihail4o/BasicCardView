package com.balivo.basiccardview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var cars: ArrayList<Car>
    private lateinit var carsAdapter: CarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCars()
        carsAdapter = CarsAdapter(this, cars)
// Set-Up RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 is number of coloumns in single row
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.adapter = carsAdapter
    }
    /**
     * Initialize the cars list
     */
    private fun initCars() {
        cars = ArrayList()
        cars.add(Car(R.drawable.audi, "Audi", "Sports Car - Audi"))
        cars.add(Car(R.drawable.cars_img, "Cars", "Common Cars - Street"))
        cars.add(Car(R.drawable.merc_img, "Mercedes", "Luxury Car - Merc"))
        cars.add(Car(R.drawable.mits_img, "Mits", "Sports Car - Mits"))
        cars.add(Car(R.drawable.must_img, "Ford", "Muscle Car - Ford"))
        cars.add(Car(R.drawable.mustang_img, "Ford", "Muscle Car - Ford"))
        cars.add(Car(R.drawable.porsche, "Porsche", "Sports Car - Porsche"))
        cars.add(Car(R.drawable.tire_img, "Tires", "Car tires - Race"))
        cars.add(Car(R.drawable.volvo_img, "Volvo", "Sports Car - Volvo"))
    }
}