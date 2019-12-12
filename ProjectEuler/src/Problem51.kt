fun main(){
    val pf = PrimeFinder()
    println(smallestPrimeValueFamily(8, pf))
    //println(largestFamilyOfPattern("d".toList(), pf))
    //println(familyFromPermPattern(listOf(-1)))
}

private fun smallestPrimeValueFamily(familySize: Int, pf: PrimeFinder): List<Long> {
    var i = 1
    while (true){
        val patterns = nonexhaustivePermutations(i, listOf('s', 'd'))
        for (pattern in patterns){
            val largeFam = largestFamilyOfPattern(pattern, pf)
            if (largeFam.size >= familySize){
                return largeFam //TODO problem that it might not be the smallest, just one
            }
        }
        i++
    }
}

private fun largestFamilyOfPattern(pattern: List<Char>, pf: PrimeFinder): List<Long> {
    var returnFamily = emptyList<Long>()
    val numDif = pattern.filter { it == 'd' }.size
    val difPerms = nonexhaustivePermutations(numDif, (0..9).toList())
    for (perm in difPerms){
        val permPattern = insertPermInPattern(perm, pattern)
        val primeFamily = familyFromPermPattern(permPattern).filter { pf.isPrime(it) }.distinct()

        if (primeFamily.size > returnFamily.size){
            returnFamily = primeFamily
        }else if (primeFamily.size == returnFamily.size){
            println("Ignored alternative prime family :( Might need to deal with this")
        }
    }

    return returnFamily
}

fun familyFromPermPattern(permPattern: List<Int>): List<Long> =
    (0..9).map { s -> permPattern.map { c -> if (c == -1) s else c }.map { it.toString() }.fold("", {x, y -> x + y}) }.filter { it.first() != '0' }.map { it.toLong() }

private fun insertPermInPattern(perm: List<Int>, pattern: List<Char>): List<Int> =
    when {
        pattern.isEmpty() -> emptyList()
        pattern.first() == 's' -> listOf(-1) + insertPermInPattern(perm, pattern.drop(1))
        else -> listOf(perm.first()) + insertPermInPattern(perm.drop(1), pattern.drop(1))
    }

