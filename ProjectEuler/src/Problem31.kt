fun main(){
    val parts = listOf(1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0).reversed()
    val whole = 200.0
    val answer = waysToCombineInto(parts, whole)
    println(answer)
    println(answer.count())
}

fun waysToCombineInto(parts: List<Double>, whole: Double): List<List<Long>> {

    return if (parts.count() == 1)
        when {
            whole % parts.first() == 0.0 -> listOf(listOf((whole / parts.first()).toLong()))
            else -> listOf(listOf(-1L))
        }
    else {
        var i = 0L
        var answer = listOf<List<Long>>()
        while (i * parts.first() <= whole) {
            answer += waysToCombineInto(parts.drop(1), whole - i * parts.first()).map { listOf(i) + it }
            i++
        }
        answer.filter { it.last() != -1L }
    }
}
