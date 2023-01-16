package io.rosal.starcentral.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.rosal.starcentral.R
import io.rosal.starcentral.WorkItemAdapter
import io.rosal.starcentral.data.ChargeList
import io.rosal.starcentral.data.WorkItemList
import io.rosal.starcentral.data.WorkItem

class WorkItemListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : WorkItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_work_item_list, container, false)

        recyclerView = layout.findViewById(R.id.recyclerView)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = WorkItemList()

        val chargeList = ChargeList()

        list.addWorkItem(WorkItem("The Commonwealth Apartments", "1/11/2023", "Fitness Room", chargeList))
        list.addWorkItem(WorkItem("The Wynnewood", "1/13/2023", "Apartment 23E One Bedroom", chargeList))
        list.addWorkItem(WorkItem("The Wynnewood", "1/13/2023", "Apartment 23K Two Bedrooms", chargeList))
        list.addWorkItem(WorkItem("Arch Luxury Apartments", "1/14/2023", "Apartment 901 One Bedroom", chargeList))
        list.addWorkItem(WorkItem("Arch Luxury Apartments", "1/14/2023", "Apartment 411 One Bedroom", chargeList))

        adapter = WorkItemAdapter(requireContext(), list) { workItem: WorkItem -> onClick(workItem) }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun onClick(workItem: WorkItem){
        Toast.makeText(requireContext(), "Property is ${workItem.propertyName}", Toast.LENGTH_SHORT).show()
    }
}