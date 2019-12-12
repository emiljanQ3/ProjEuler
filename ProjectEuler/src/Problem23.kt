import java.lang.Math.pow

fun main(){
    val answer = getIsNotSumTo(28123)
    println(answer)
    println(answer.sum())
}

fun getAbundantNumbersTo(n: Int): List<Int>{
    return (1..n).filter { isAbundant(it) }
}

fun isAbundant(n: Int): Boolean{
    return uniqueDividersOf(n).sum() > n
}

private fun getIsNotSumTo(n: Int): List<Int>{
    val abundantNumbers = getAbundantNumbersTo(n)
    return (1..n).filter { !sumOfTwoPositiveNumbersFromOrderedListIsN(it, abundantNumbers) }
}

fun sumOfTwoPositiveNumbersFromOrderedListIsN(n: Int, ms: List<Int>): Boolean{
    val ls = ms.takeWhile { it < n }

    var j = 0
    for(i in 0 until ls.count()){
        val isAcending = ls[i] + ls[j] < n
        while (true){
            val x = ls[i] + ls[j]
            if ( x == n) return true

            if (isAcending){
                if (x > n){
                    break
                }
                j++
            }else if (!isAcending){
                if (x < n || j == 0){
                    break
                }
                j--
            }
        }
    }

    return false
}