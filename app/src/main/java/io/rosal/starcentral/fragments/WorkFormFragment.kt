package io.rosal.starcentral.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputLayout
import io.rosal.starcentral.R
import io.rosal.starcentral.data.ChargeList
import io.rosal.starcentral.data.WorkItem
import java.util.*


class WorkFormFragment : Fragment() {

    companion object {
        private const val TAG = "WorkFormFragment"
    }

    private  val testData = arrayOf(
        "Lincoln Square",
        "Arch Luxury Apartments",
        "The Commonwealth",
        "Sevilla Court"
    )

    private lateinit var layout: View
    private lateinit var continueButton : Button
    private lateinit var calendarButton: ImageButton
    private lateinit var dateInputLayout : TextInputLayout
    private lateinit var descriptorInputLayout: TextInputLayout
    private lateinit var spinner : Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_work_form, container, false)
        continueButton = layout.findViewById(R.id.submitButton)
        spinner = layout.findViewById(R.id.spinner)
        calendarButton = layout.findViewById(R.id.calendarImageButton)
        dateInputLayout = layout.findViewById(R.id.dateInputLayout)
        descriptorInputLayout = layout.findViewById(R.id.descriptorInputLayout)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner()
        setupCalendarButton()

        continueButton.setOnClickListener {
            val workItem = WorkItem(
                spinner.selectedItem.toString(),
                dateInputLayout.editText?.text.toString(),
                descriptorInputLayout.editText?.text.toString(),
                ChargeList()
            )
            //TODO pass this workItem to the next fragment and perform actions on the charge list
            Navigation.findNavController(layout).navigate(R.id.action_workFormFragment_to_additionFragment)
        }
    }

    private fun setupCalendarButton() {
        val cal = Calendar.getInstance()
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        calendarButton.setOnClickListener {

        }
    }

    private fun setupSpinner() {
        val arrayAdapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, testData)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //No need to do anything
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Whenever nothing is selected
            }

        }
    }


}