package com.galaxysoft.aquaplannernetng.net.requests.tasklist

import com.android.volley.RequestQueue
import com.android.volley.Response
import com.galaxysoft.aquaplannernetng.model.Task
import com.galaxysoft.aquaplannernetng.net.requests.base.BaseImpl

class TaskList(queue: RequestQueue,
               baseUrl: String,
               listener: Response.Listener<List<Task>>,
               errorListener: Response.ErrorListener)
    : BaseImpl<List<Task>>(queue, listener) {
    private val taskListRequest: TaskListRequest = TaskListRequest(baseUrl, listener, errorListener)

    override fun get() {
        queue.add(taskListRequest)
    }
}
