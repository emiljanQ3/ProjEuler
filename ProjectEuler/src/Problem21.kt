import kotlin.math.ceil
import kotlin.math.sqrt

fun main(){
    val answer = generateSequence(1) { it + 1 }.take(10000)
        .filter { isAmicableNumber(it) }.toList()
    println(answer.map { Triple(it, uniqueDividersOf(it), uniqueDividersOf(it).sum()) })
    println(answer.sum())
}

fun isAmicableNumber(num: Int): Boolean{
    return uniqueDividersOf(uniqueDividersOf(num).sum()).sum() == num && uniqueDividersOf(num).sum() != num
}

fun uniqueDividersOf(n: Int): List<Int>{
    val lowDividers = (1..(sqrt(n.toDouble()).toInt())).toList()
        .filter { n % it == 0 }
    return when {
        lowDividers.count() == 0 -> emptyList()
        else -> lowDividers + lowDividers.map { n / it }
    }.distinct().filter { it != n } //Why do i need this? :(
}