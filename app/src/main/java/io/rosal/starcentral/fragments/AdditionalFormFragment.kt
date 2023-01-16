package io.rosal.starcentral.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.core.view.isGone
import com.google.android.material.textfield.TextInputLayout
import io.rosal.starcentral.R
import io.rosal.starcentral.data.Charge
import io.rosal.starcentral.data.ChargeList

class AdditionalFormFragment : Fragment() {
    private lateinit var layout : View
    private lateinit var spinner : Spinner
    private lateinit var priceTextInputLayout: TextInputLayout
    private lateinit var customTextInputLayout: TextInputLayout
    private lateinit var detailsTextInputLayout: TextInputLayout
    private lateinit var addButton : Button

    private lateinit var selection : String

    private val chargeList = ChargeList()

    private val testData = arrayOf(
        "General Painting",
        "General Cleaning",
        "Extra Cleaning",
        "Additional Den Painted",
        "Additional Bathroom Painted",
        "Repair",
        "Second Coat",
        "Occupied Unit Charge",
        "High Ceilings Charge",
        "Primer Coat",
        "Ceilings Painted",
        "Custom"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_addtional_form, container, false)
        spinner = layout.findViewById(R.id.spinner2)
        priceTextInputLayout = layout.findViewById(R.id.priceTextInputLayout)
        customTextInputLayout = layout.findViewById(R.id.customTextInputLayout)
        detailsTextInputLayout = layout.findViewById(R.id.detailTextInputLayout)
        addButton = layout.findViewById(R.id.submitAdditiveButton)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arrayAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, testData)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selection = p0?.getItemAtPosition(p2).toString()
                customTextInputLayout.isGone = selection != "Custom"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                selection = p0!!.getItemAtPosition(0).toString()
            }

        }

        addButton.setOnClickListener {
            val priceInput = priceTextInputLayout.editText!!
            val detailsInput = detailsTextInputLayout.editText!!
            val spinnerChoice = spinner.selectedItem.toString()
            val price = priceInput.text.toString()
            val details = detailsInput.text.toString()
            var custom : String? = null
            val customInput : EditText

            if(selection == "Custom"){
                customInput = customTextInputLayout.editText!!
                custom = customInput.text.toString()
                customInput.text.clear()

                customTextInputLayout.isGone = true

            }

            spinner.setSelection(0)
            priceInput.text.clear()
            detailsInput.text.clear()

            //Send information where needed! Depending if it was a custom choice
            val charge : Charge = if(custom.isNullOrEmpty()){
                Log.d("TEST", "Spinner Choice : ${spinnerChoice}\nPrice : ${price}\nDetails : ${details}\n" )
                Charge(spinnerChoice, price, details)

            } else{
                Log.d("TEST", "Custom Choice : ${custom}\nPrice : ${price}\nDetails : ${details}\n" )
                Charge(custom, price, details)
            }

            chargeList.addCharge(charge)
        }
    }
}