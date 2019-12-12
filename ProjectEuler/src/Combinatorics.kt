import java.math.BigInteger

fun factorial(num: Long): Long{
    return if(num == 0L){
        1L
    }else if(num > 0L){
        num * factorial(num - 1)
    }else{
        println("Undefined argument $num for function factorial.")
        0L
    }
}

fun bigFactorial(num: Long): BigInteger{
    return if(num == 0L){
        BigInteger.ONE
    }else if(num > 0L){
        BigInteger.valueOf(num).multiply(bigFactorial(num - 1))
    }else{
        println("Undefined argument $num for function factorial.")
        BigInteger.ZERO
    }
}

fun nCk(n: Long, k: Long): Long{
    return factorial(n)/(factorial(k)*factorial(n-k))
}

fun <T> permutationsOf(elements: List<T>): List<List<T>>{
    return if (elements.count() <= 1) {
        listOf(elements)
    } else {
        var returnList = listOf<List<T>>()
        for (e in elements){
            returnList += permutationsOf(elements.minus(e)).map { listOf(e) + it }
        }
        returnList.distinct() //Does distinct work here?
    }
}

fun numUniqueCombinationsOf(elements: List<Any>): Long{
    return uniqueCombinations2(countGroups(elements))
}

fun countGroups(elements: List<Any>): List<Long> {
    return if (elements.isEmpty()){
        emptyList()
    }else{
        countGroups(elements.filter { elements[0] != it }) + elements.count { elements[0] == it }.toLong()
    }
}

fun uniqueCombinations2(groupSizes: List<Long>): Long{
    return groupSizes.map { it + 1L }.fold(1L, {x,y -> x*y})
}

fun main(){
    //val elements = listOf('A','A','B')
    //println(elements.filter { elements[0] == it })
    println(nonexhaustivePermutations(4, listOf(1,0)))
}

fun <T> nonexhaustivePermutations(length: Int, elements: List<T>): List<List<T>> =
    if (elements.isEmpty() || length <= 0) listOf(emptyList())
    else nonexhaustivePermutations(length - 1, elements)
        .flatMap { sub -> elements.map { sub + it } }
