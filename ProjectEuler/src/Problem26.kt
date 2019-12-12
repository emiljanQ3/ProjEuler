fun main(){
    println((1 until 1000).map { lengthOfReciprocal(it) }.withIndex().toList())//.maxBy { it.value })
}

fun lengthOfReciprocal(d: Int): Int{
    val digits = mutableListOf<Int>(0)
    val carryHistory = mutableListOf<Int>(10)
    var carry = 10
    while (carry != 0){
        digits.add(carry / d)
        carry = (carry % d) * 10
        if(carryHistory.contains(carry)){
            //println(digits)
            return carryHistory.dropWhile { it != carry }.count()
        }
        carryHistory.add(carry)
    }
    //println(digits)
    return -1
}