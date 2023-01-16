package io.rosal.starcentral.data

class ChargeList {
    private val list = ArrayList<Charge>()

    fun addCharge(charge: Charge){
        list.add(charge)
    }
}