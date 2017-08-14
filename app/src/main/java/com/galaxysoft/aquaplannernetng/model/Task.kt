package com.galaxysoft.aquaplannernetng.model

import org.joda.time.LocalTime

data class Task(var order: Int,
                var mode: Mode?,
                var startTime: LocalTime?,
                var startPwm: Int?,
                var endTime: LocalTime?,
                var endPwm: Int?,
                var outputChannel: OutputChannel?)
