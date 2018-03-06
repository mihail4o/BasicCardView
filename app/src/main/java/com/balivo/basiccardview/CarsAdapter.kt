package com.balivo.basiccardview

/**
 * Created by balivo on 3/4/18.
 */
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import java.util.*

class CarsAdapter(private val context: Context, private val carsList: ArrayList<Car>) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_layout, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carsList[position]
        val carImage = ContextCompat.getDrawable(context, car.carImage)
        holder.imgCar.setImageDrawable(carImage)
        holder.carTitle.text = car.carTitle
        holder.carDesc.text = car.carDesc
        holder.imgOverFlow.setOnClickListener { view -> showPopMenu(view) }
        holder.imgCar.setOnClickListener { startCarDetailActivity(car) }
    }
    // This method will start the CarDetailActivity
    private fun startCarDetailActivity(car: Car) {
        val i = Intent(context, CarDetailActivity::class.java)
        i.putExtra("CAR_IMAGE", car.carImage)
        i.putExtra("CAR_TITLE", car.carTitle)
        context.startActivity(i)
    }
    // This method will show the popup menu when the
// user presses the Overflow image view
    private fun showPopMenu(view: View) {
        val popupMenu = PopupMenu(context, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu_car_detail, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(MenuItemClickListener())
        popupMenu.show()
    }
    internal inner class MenuItemClickListener : PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(menuItem: MenuItem): Boolean {
            when (menuItem.itemId) {
                R.id.menu_action_info -> {
                    Toast.makeText(context, "Info clicked", Toast.LENGTH_SHORT).show()
                    return true
                }
                R.id.menu_action_settings -> {
                    Toast.makeText(context, "Settings clicked", Toast.LENGTH_SHORT).show()
                    return true
                }
            }
            return false
        }
    }
    override fun getItemCount(): Int {
        return carsList.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCar: ImageView = itemView.findViewById(R.id.img_car)
        val imgOverFlow: ImageView = itemView.findViewById(R.id.img_overflow)
        val carTitle: TextView = itemView.findViewById(R.id.text_car_title)
        val carDesc: TextView = itemView.findViewById(R.id.text__car_desc)
    }
}
