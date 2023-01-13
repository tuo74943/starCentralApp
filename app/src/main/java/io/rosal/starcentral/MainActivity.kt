package io.rosal.starcentral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), DashboardFragment.DashboardInterface{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun addNewItem() {
        Toast.makeText(applicationContext, "Adding adding something!", Toast.LENGTH_SHORT).show()
    }

    override fun logout() {
        incomingFeatureToast()
    }

    override fun loadAbout() {
        incomingFeatureToast()
    }

    override fun loadProfile() {
        incomingFeatureToast()
    }

    fun incomingFeatureToast(){
        Toast.makeText(applicationContext, "Incoming feature, TM", Toast.LENGTH_SHORT).show()
    }
}