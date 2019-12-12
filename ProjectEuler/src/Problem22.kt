import java.io.File

fun main(){
    val inputTwentyTwo = File("""C:\Users\Emil Jansson\Desktop\ProjectEuler\src\Problem22_names.txt""").readText()
    val nameList = parseProblem(inputTwentyTwo).sorted()
    val answer = nameList.map { nameValue(it) }.withIndex().map { (it.index + 1) * it.value }
//    println(nameList.zip(answer).map { Triple(it.first, it.second, it.first.map { (it.toInt() % 32).toLong() }) })
    println(answer.sum())
}

fun nameValue(name: String): Long {
    return name.map { (it.toInt() % 32).toLong() }.sum()
}

private fun parseProblem(input: String): List<String> {
    val names = mutableListOf<String>()
    var start = -1
    for ( i in 0 until input.length){
        val c = input[i]
        if (c != '"') continue
        if (start == -1){
            start = i;
        }else{
            names.add(input.slice(start+1 until i))
            start = -1
        }
    }
    return names
}
