import kotlin.math.pow

fun main(){
    val ar = generateSequence(2.0) { it + 1 }.takeWhile { it <= 100 }
    val results = mutableListOf<Double>()

    for (a in ar) for (b in ar){
       results.add(a.pow(b))
    }

    println(results.count())
    println(results.distinct().count())
}