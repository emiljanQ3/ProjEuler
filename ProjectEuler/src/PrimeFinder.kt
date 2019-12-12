import kotlin.math.sqrt

fun main(){
    val pf = PrimeFinder()
    println(pf.isPrime(1))
}

class PrimeFinder {
    private val knownPrimes = mutableListOf<Long>()
    private var largestCheckedNumber = 1L

    fun isPrime(n: Long): Boolean{
        if(n <= 1L) return false // Bad input

        if (knownPrimes.contains(n)) return true

        findPrimesTo(sqrt(n.toDouble()))

        for (p in knownPrimes.takeWhile { it <= sqrt(n.toDouble()) })
            if (n % p == 0L) return false

        return true
    }

    private fun findPrimesTo(n: Double) {
        while (largestCheckedNumber < n){
            largestCheckedNumber++
            if (isPrime(largestCheckedNumber))
                knownPrimes.add(largestCheckedNumber)
        }
    }

    fun getPrimesTo(n: Long): List<Long>{
        findPrimesTo(n.toDouble())
        return knownPrimes.takeWhile { it <= n }
    }

    fun getFirstNPrimes(n: Int): List<Long>{
        while (knownPrimes.count() < n){
            largestCheckedNumber++
            if (isPrime(largestCheckedNumber))
                knownPrimes.add(largestCheckedNumber)
        }
        return knownPrimes.take(n)
    }

    fun getNextPrime(): Long {
        while (true){
            largestCheckedNumber++
            if (isPrime(largestCheckedNumber))
                knownPrimes.add(largestCheckedNumber)
            return largestCheckedNumber
        }
    }

}