package io.rosal.starcentral

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardFragment : Fragment() {

    private lateinit var fab : FloatingActionButton
    private lateinit var menuProvider : MenuProvider


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_dashboard, container, false)
        fab = layout.findViewById(R.id.floatingActionButton)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        fab.setOnClickListener {
            (activity as DashboardInterface).addNewItem()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MenuHost).removeMenuProvider(menuProvider)
    }

    private fun setupMenu() {
        menuProvider = object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.dashboad_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.action_logout -> {
                        (activity as DashboardInterface).logout()
                        return true
                    }
                    R.id.action_about -> {
                        (activity as DashboardInterface).loadAbout()
                        return true
                    }
                    R.id.action_profile -> {
                        (activity as DashboardInterface).loadProfile()
                        return true
                    }
                }
                return false
            }
        }
        (activity as MenuHost).addMenuProvider(menuProvider)
    }


    interface DashboardInterface{
        fun addNewItem()
        fun logout()
        fun loadAbout()
        fun loadProfile()
    }
}