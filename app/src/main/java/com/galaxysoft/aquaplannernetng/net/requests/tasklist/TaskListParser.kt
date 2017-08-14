package com.galaxysoft.aquaplannernetng.net.requests.tasklist

import com.galaxysoft.aquaplannernetng.model.DataOffset
import com.galaxysoft.aquaplannernetng.model.Mode
import com.galaxysoft.aquaplannernetng.model.OutputChannel
import com.galaxysoft.aquaplannernetng.model.Task
import org.joda.time.LocalTime
import java.util.*
import kotlin.coroutines.experimental.buildSequence

class TaskListParser {

    private val deviceTaskStructByteCount = 15

    fun parse(data: ByteArray): List<Task> {
        val lines = data.size / deviceTaskStructByteCount
        val result = buildSequence {

            for (i in 0..lines - 1) {
                val taskData = Arrays.copyOfRange(data, i * deviceTaskStructByteCount, (i + 1) * deviceTaskStructByteCount)
                val outputChannel = OutputChannel.fromInt(taskData[DataOffset.outputChannel.value].toInt())
                val mode = Mode.fromInt(taskData[DataOffset.function.value].toInt())

                val startHour = taskData[DataOffset.timeOnHrs.value].toInt()
                val startMin = taskData[DataOffset.timeOnMin.value].toInt()
                val startTime = LocalTime(startHour, startMin)

                val startPwm = taskData[DataOffset.pwmBegin.value].toInt()

                val endHour = taskData[DataOffset.timeOffHrs.value].toInt()
                val endMin = taskData[DataOffset.timeOffMin.value].toInt()
                val endTime = LocalTime(endHour, endMin)

                val endPwm = taskData[DataOffset.pwmEnd.value].toInt()


                yield(Task(i + 1, mode, startTime, startPwm,
                        endTime, endPwm, outputChannel))
            }
        }
        return result.toList()
    }
}