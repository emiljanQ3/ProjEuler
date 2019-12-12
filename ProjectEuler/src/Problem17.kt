fun main(){
    println(generateSequence(1) { it + 1 }.take(1000).map {
        println("$it -> ${intToWords(it)} -> ${intToWords(it).replace(" ", "")} -> ${intToWords(it).replace(" ", "").length}")
        intToWords(it).replace(" ", "").length }.sum())
}

fun intToWords(i: Int): String = intStringToWords(i.toString())

fun intStringToWords(cs: String): String{
    return if(cs.length == 1){
        when (cs) {
            "1" -> "one"
            "2" -> "two"
            "3" -> "three"
            "4" -> "four"
            "5" -> "five"
            "6" -> "six"
            "7" -> "seven"
            "8" -> "eight"
            "9" -> "nine"
            else -> ""
        }
    }else if (cs.length == 2){
        when{
            cs == "10"              -> "ten"
            cs == "11"              -> "eleven"
            cs == "12"              -> "twelve"
            cs == "13"              -> "thirteen"
            cs == "15"              -> "fifteen"
            cs == "18"              -> "eighteen"
            cs[0].toString() == "1" -> intStringToWords(cs[1].toString()) + "teen"
            cs[0].toString() == "2" -> "twenty" + intStringToWords(cs[1].toString())
            cs[0].toString() == "3" -> "thirty" + intStringToWords(cs[1].toString())
            cs[0].toString() == "4" -> "forty" + intStringToWords(cs[1].toString())
            cs[0].toString() == "5" -> "fifty" + intStringToWords(cs[1].toString())
            cs[0].toString() == "6" -> "sixty" + intStringToWords(cs[1].toString())
            cs[0].toString() == "7" -> "seventy" + intStringToWords(cs[1].toString())
            cs[0].toString() == "8" -> "eighty" + intStringToWords(cs[1].toString())
            cs[0].toString() == "9" -> "ninety" + intStringToWords(cs[1].toString())
            else -> intStringToWords(cs[1].toString())
        }
    }else if (cs.length == 3){
        when{
            cs.slice(1..2) == "00" -> intStringToWords(cs[0].toString()) + " hundred"
            else -> intStringToWords(cs[0].toString()) + " hundred and " + intStringToWords(cs.slice(1..2))
        }
    }else if (cs == "1000"){
        "one thousand"
    }else{
        "undefined"
    }
}