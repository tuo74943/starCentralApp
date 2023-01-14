package io.rosal.starcentral

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.navigation.Navigation


class WorkFormFragment : Fragment() {

    private lateinit var layout: View
    private lateinit var submitButton : Button
    lateinit var spinner : Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_work_form, container, false)
        submitButton = layout.findViewById(R.id.submitButton)
        spinner = layout.findViewById(R.id.spinner)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner()

        submitButton.setOnClickListener {
            //TODO add to list here
            Navigation.findNavController(layout).navigate(R.id.action_workFormFragment_to_dashboardFragment)
        }
    }

    private fun setupSpinner() {

        val propertyNames = arrayOf("Lincoln Square", "Arch Luxury Apartments", "The Commonwealth", "Sevilla Court")

        val arrayAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, propertyNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val currentValue = parent?.getItemAtPosition(p2)
                Log.d("WorkFormFrag", "$currentValue selected")

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Whenever nothing is selected
            }

        }
    }


}