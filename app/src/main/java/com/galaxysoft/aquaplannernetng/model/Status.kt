package com.galaxysoft.aquaplannernetng.model

import org.joda.time.LocalDateTime

data class Status(var temp1: Float?,
                  var temp2: Float?,
                  var pH: Float?,
                  var dateTime: LocalDateTime,
                  var led1: Int,
                  var led2: Int,
                  var led3: Int,
                  var led4: Int,
                  var led5: Int,
                  var led6: Int,
                  var relay1: RelayState,
                  var relay2: RelayState,
                  var relay3: RelayState,
                  var relay4: RelayState,
                  var relay5: RelayState,
                  var relay6: RelayState,
                  var relay7: RelayState,
                  var relay8: RelayState,
                  val fan: Boolean
)
