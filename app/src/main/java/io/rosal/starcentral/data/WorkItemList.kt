package io.rosal.starcentral.data

class WorkItemList {
    private val workItemList = ArrayList<WorkItem>()

    val size : Int get() = workItemList.size

    fun replaceList(newList : WorkItemList){
        workItemList.clear()
        workItemList.addAll(newList.workItemList)
    }

    fun getWorkItem(index : Int) : WorkItem {
        return workItemList[index]
    }

    fun addWorkItem(workItem: WorkItem){
        workItemList.add(workItem)
    }

    fun clearList(){
        workItemList.clear()
    }
}
