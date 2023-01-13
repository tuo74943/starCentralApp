package io.rosal.starcentral

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkItemListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : WorkItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_work_item_list, container, false)

        recyclerView = layout.findViewById(R.id.recyclerView)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = WorkItemList()
        list.addWorkItem(WorkItem("The Commonwealth Apartments", "1/11/2023", "Fitness Room", null))
        list.addWorkItem(WorkItem("The Wynnewood", "1/13/2023", "Apartment 23E One Bedroom", null))
        list.addWorkItem(WorkItem("The Wynnewood", "1/13/2023", "Apartment 23K Two Bedrooms", null))


        adapter = WorkItemAdapter(requireContext(), list) { workItem: WorkItem -> onClick(workItem) }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun onClick(workItem: WorkItem){
        Toast.makeText(requireContext(), "Property is ${workItem.propertyName}", Toast.LENGTH_SHORT).show()
    }
}