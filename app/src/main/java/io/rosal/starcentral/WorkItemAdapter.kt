package io.rosal.starcentral

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.rosal.starcentral.data.WorkItem
import io.rosal.starcentral.data.WorkItemList

class WorkItemAdapter(_context : Context, _list : WorkItemList, _ocl : (WorkItem) -> Unit) : RecyclerView.Adapter<WorkItemAdapter.WorkItemViewHolder>(){

    class WorkItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindWorkItem(workItem : WorkItem, onClick : (WorkItem) -> Unit){
            val heading = "${workItem.date} - ${workItem.propertyName}"
            itemView.findViewById<TextView>(R.id.dateTextView).text = heading
            itemView.findViewById<TextView>(R.id.descriptionTextView).text = workItem.descriptor

            itemView.setOnClickListener{
                onClick(workItem)
            }
        }
    }

    //class properties
    private val context = _context
    private val list = _list
    private val ocl = _ocl

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkItemViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.work_item_layout, parent, false)
        return WorkItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkItemViewHolder, position: Int) {
        holder.bindWorkItem(list.getWorkItem(position), ocl)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}