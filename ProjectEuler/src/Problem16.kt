import java.math.BigInteger

fun main(){
    println(BigInteger.valueOf(2).pow(1000).toString().map { it.toString().toInt() }.sum())
}