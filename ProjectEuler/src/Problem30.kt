import kotlin.math.pow

fun main(){ //Really ugly
    val answers = mutableListOf<Long>()
    for (i in 10..1000000L){
        if (i == longToDigits(i).map { it.toDouble().pow(5).toLong() }.sum()) answers.add(i)
        if (i % 100000 == 0L) println(i)
    }

    println(answers.sum())
}

fun longToDigits(n: Long): List<Long>{
    return n.toString().map { it.toString().toLong() }
}