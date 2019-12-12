import java.math.BigInteger

fun getFibonacciSequence(): Sequence<BigInteger>{
    return generateSequence(Pair(1.toBigInteger(), 1.toBigInteger()), { Pair(it.second, it.first + it.second) }).map { it.first }
}

fun main(){
    println(getFibonacciSequence().indexOfFirst { it.toString().length >= 1000 })
}