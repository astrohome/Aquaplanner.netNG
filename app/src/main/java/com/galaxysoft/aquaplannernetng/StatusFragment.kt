package com.galaxysoft.aquaplannernetng

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.galaxysoft.aquaplannernetng.model.Task
import com.galaxysoft.aquaplannernetng.model.TaskAdapter
import com.galaxysoft.aquaplannernetng.net.requests.tasklist.TaskList


class StatusFragment : Fragment() {

    lateinit var taskListAdapter: ArrayAdapter<Task>
    lateinit var lvMain: ListView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        taskListAdapter = TaskAdapter(context)
        val view = inflater!!.inflate(R.layout.fragment_status, container, false)
        lvMain = view.findViewById(R.id.lvMain)
        lvMain.adapter = taskListAdapter

        val queue = Volley.newRequestQueue(this.context)
        val a = TaskList(queue, "http://astrohome.ddns.net:314", success, Response.ErrorListener {
            error -> System.out.println("error" + error.localizedMessage)
        })
        a.get()

        return view
    }

    private val success = Response.Listener<List<Task>> {
        response ->
            taskListAdapter.addAll(response)
            taskListAdapter.notifyDataSetChanged()
            Toast.makeText(this.context, response.size.toString(), Toast.LENGTH_LONG).show() }
}
