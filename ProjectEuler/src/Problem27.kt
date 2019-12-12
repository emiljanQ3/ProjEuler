import kotlin.math.pow

fun main(){
    val primeFinder = PrimeFinder()
    val ar = -999L..999L
    val br = -1000L..1000L
    var longestSequence = 0L
    for (a in ar) for (b in br){
        val n = consecutivePrimes(a, b, primeFinder)
        if( n > longestSequence){
            longestSequence = n
            println("a = $a & b = $b -> n^2 + ${a}n + $b -> $longestSequence consecutive primes")
        }
    }
}

fun consecutivePrimes(a: Long, b: Long, pf: PrimeFinder): Long{
    var n = 1.0
    while (pf.isPrime(n.pow(2).toLong() + a * n.toLong() + b)){
        n++
    }
    return n.toLong()-1
}

