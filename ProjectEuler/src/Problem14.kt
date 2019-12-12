fun main(){
    println(longestCollatz(1000000))
}

fun longestCollatz(maxNum: Int): Int {
    return generateSequence(1) {it + 1}.take(maxNum).map { Pair(it, collatzLength(it)) }.maxBy { it.second }!!.first
}

fun collatzLength(n: Int): Int {
    return collatzLengthInner(n.toLong(), 1L).toInt()
}

tailrec fun collatzLengthInner(n: Long, i: Long): Long {
    return when {
        n == 1L -> i
        n % 2 == 0L -> collatzLengthInner(n/2, i+1)
        else -> collatzLengthInner(3*n+1, i+1)
    }
}
