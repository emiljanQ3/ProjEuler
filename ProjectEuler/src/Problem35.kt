fun main(){
    val pFinder = PrimeFinder()
    val primes = pFinder.getPrimesTo(1000000)
    val cPrimes = circularNumbersIn(primes)
    println(cPrimes)
    println(cPrimes.count())
}

//Answer = 55

private fun circularNumbersIn(nums: List<Long>): List<Long>{
    return nums.filter { isCircularIn(it, nums) }
}

private fun isCircularIn(num: Long, nums: List<Long>): Boolean{
    val numString = num.toString()
    for (i in 0 until numString.length){
        val tempString = numString.drop(i) + numString.take(i)
        if (!nums.contains(tempString.toLong()))
            return false
    }
    return true
}

