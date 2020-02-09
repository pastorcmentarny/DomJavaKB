package examples

interface Time {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
    fun setTime(time: KelvinTime) = setTime(time.hours)// default implemantion so all classes do not have implementation will use default implementaion
}

interface EndOfTheWorld {
    fun setTime(time: KelvinTime) {}
}

//example to deal with interfaces share the same function
class YetiTime : Time, EndOfTheWorld { // : is replacement for implements , extends
    override fun setTime(time: KelvinTime) {
        super<Time>.setTime(time)
        super<EndOfTheWorld>.setTime(time)
    }

    override fun setTime(hours: Int, mins: Int, secs: Int) {}

}

class KelvinTime { // : is replacement for implements , extends
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0

}
