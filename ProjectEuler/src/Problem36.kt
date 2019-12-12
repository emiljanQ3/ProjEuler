import kotlin.math.pow

fun main(){
    val palindromes = generatePalindromeNumbersToLength(6)
    println("1")
    val doublePalindromes = palindromes.filter { isPalindrome(it.toString(2)) }
    println(doublePalindromes.sum())
    println(palindromes.size)
    println(doublePalindromes.size)
}

private fun isBinaryPalindrome(num: Long): Boolean{ //Not used
    val binaryString = num.toString(2)
    return binaryString.take(binaryString.length/2) == binaryString.takeLast(binaryString.length/2)
}

fun isPalindrome(string: String): Boolean{
    return string.take(string.length/2) == string.takeLast(string.length/2).reversed()
}

private fun generatePalindromeNumbersToLength(length: Int): List<Long>{
    val coreList = (1 until 10.0.pow(((length+1)/2).toDouble()).toInt()).map { it.toString() }.toList()
    val returnList = coreList.map { it + it.reversed() }.filter { it.length <= length } + coreList.map { it + it.reversed().drop(1) }
    return returnList.map { it.toLong() }
}

