package com.galaxysoft.aquaplannernetng.model

open class EnumCompanion<in T, out V>(private val valueMap: Map<T, V>) {
    fun fromInt(type: T) = valueMap[type]
}

enum class DataOffset constructor(var value: Int) {

    outputChannel(0),
    function(1),
    inputNumber(2),
    timeOnSec(3),
    timeOnMin(4),
    timeOnHrs(5),
    timeOnDow(6),
    timeOffSec(7),
    timeOffMin(8),
    timeOffHrs(9),
    timeOffDow(10),
    pwmBegin(11),
    pwmEnd(12),
    temperature(13);

    companion object : EnumCompanion<Int, DataOffset>(DataOffset.values().associateBy(DataOffset::value))
}


enum class OutputChannel constructor(var value: Int) {

    P1(0),
    P2(1),
    P3(2),
    P4(3),
    P5(4),
    P6(5),
    P7(6),
    P8(7),
    C1(9),
    C2(10),
    C3(11),
    C4(12),
    C5(13),
    C6(14),
    BP(15);

    companion object : EnumCompanion<Int, OutputChannel>(OutputChannel.values().associateBy(OutputChannel::value))
}

enum class Mode constructor(var value: Int) {
    TC(0),
    TM(1),
    TO(2),
    HT(3),
    OT(4),
    TH(5),

    CO(7),
    TK(8),
    UV(9);

    companion object : EnumCompanion<Int, Mode>(Mode.values().associateBy(Mode::value))
}
