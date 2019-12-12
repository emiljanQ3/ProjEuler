/*
fun isCurious(tal: Long, denominator: Long): Boolean{
    val commonPrimes = commonPrimes(tal, denominator)

}

fun commonPrimes(first: Long, second: Long): List<Long>{
    val pBs = primeFactorsOf(second).toMutableList()
    val commons = mutableListOf<Long>()

    for (pA in primeFactorsOf(first)){
        for (pB in pBs){
            if(pB == pA){
                commons.add(pA)
                pBs.remove(pA)
                break
            }
        }
    }

    return commons
}
*/