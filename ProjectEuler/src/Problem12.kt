fun main(){
    var triangleNumber = 1L
    var i = 1L
    while(numDividers(triangleNumber) <= 500L){
        i++
        triangleNumber += i
        println(i)
    }
    println(triangleNumber)
}

fun numDividers(number: Long): Long {
    return numUniqueCombinationsOf(primeFactorsOf(number))
}

fun primeFactorsOf(number: Long): List<Long>{
    val primeFactors = mutableListOf<Long>()
    var num = number
    var divider = 2L
    while (num != 1L){
        if(num % divider == 0L){
            primeFactors.add(divider)
            num /= divider;
        }else{
            divider++
        }
    }

    return primeFactors
}
