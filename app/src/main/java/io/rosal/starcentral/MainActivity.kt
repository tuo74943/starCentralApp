package io.rosal.starcentral

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.MenuHost

class MainActivity : AppCompatActivity(), DashboardFragment.DashboardInterface{

    companion object{
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun addNewItem() {
        Log.d(TAG, "Adding a new item")
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

    private fun incomingFeatureToast(){
        Toast.makeText(applicationContext, "Incoming feature, TM", Toast.LENGTH_SHORT).show()
    }
}