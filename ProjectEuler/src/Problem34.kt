fun main(){
    val answer = factorialSumEqualsNum(10L..10000000L)
    println(answer)
    println(answer.sum())
}

//Top of range is 10^6.4 or 10^7

private fun factorialSumEqualsNum(range: LongRange):List<Long>{
    return range.filter { it == factorialSum(it) }
}

private fun factorialSum(num: Long): Long{
    var sum = 0L
    for (d in num.toString()){
        sum += factorial(d.toString().toLong())
    }
    return sum
}