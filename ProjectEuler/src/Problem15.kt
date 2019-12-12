import java.math.BigInteger

fun main(){
    println(numWaysToWalkInGrid(20L,20L))
}

fun numWaysToWalkInGrid(i: Long, j: Long): BigInteger {
    return bigFactorial(i+j).divide(bigFactorial(i).multiply(bigFactorial(j)))
}

