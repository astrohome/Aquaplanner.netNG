package com.galaxysoft.aquaplannernetng.net.requests.tasklist

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.galaxysoft.aquaplannernetng.model.Task

class TaskListRequest(baseUrl: String,
                               private val mListener: Response.Listener<List<Task>>,
                               errorListener: Response.ErrorListener?) : Request<List<Task>>(Request.Method.GET, baseUrl + "/gtts/", errorListener) {

    val parser = TaskListParser()

    override fun parseNetworkResponse(response: NetworkResponse): Response<List<Task>>? {
        val data = response.data

        return Response.success(parser.parse(data), null)
    }

    override fun deliverResponse(response: List<Task>) {
        mListener.onResponse(response)
    }
}
