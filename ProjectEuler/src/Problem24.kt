//fun main(){
//    val firstBit = "01"
//    val perm = generatePermutationsOf("23456789".toList())
//        .map { it.toCharArray().toString() }
//        .sorted()
//    val answer = perm[1000000-1]
//}
//
//private fun <T>generatePermutationsOf(xs: List<T>): List<List<T>>{ // broken
//    println(xs)
//    return when{
//        xs.isEmpty() -> emptyList()
//        else         -> oneLevelFlatten(xs.map { x ->  generatePermutationsOf(xs.filter { it != x }).map { listOf(x) + it } })
//    }
//}
//
//fun <T : Comparable<*>> incrementPerm(xs: Array<T>): Array<T>{
//    val backwards = xs.reversed()
//    val answer = when{
//        xs.count() < 2 -> backwards
//        else -> switchAt(backwards, generateSequence(0) { it + 1 }.first { backwards[it] > backwards[it + 1] })
//    }
//    //return answer
//}
//
//fun <T> switchAt(backwards: List<T>, first: Int): Array<T> {
//
//}
//
//fun <T>oneLevelFlatten(xs: List<List<T>>): List<T>{
//    return xs.fold(emptyList(), {x, y -> x + y})
//}