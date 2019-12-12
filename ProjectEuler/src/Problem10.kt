import java.lang.Exception

fun main() {
    val primes = mutableListOf<Long>()

    for (i in 2L..2000000L){
        if(isPrime(i, primes)) primes.add(i)
    }
    println(primes.fold(0L, {a,b -> a+b}))
}

private fun isPrime(x: Long, primes: List<Long>): Boolean{
    for(p in primes){
        if (x % p == 0L) return false
    }
    return true
}
