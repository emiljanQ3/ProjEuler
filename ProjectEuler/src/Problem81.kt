import java.io.File

fun main(){
    val input = File("""C:\Users\Emil Jansson\Desktop\ProjectEuler\src\Problem81_matrix.txt""").readText()
    val transitionMatrix = parseNetwork(input)
    val shortestPathSum = dijkstraShortestPathSum(0,79,transitionMatrix, 4445.0)
    println(shortestPathSum)
}
private fun parseNetwork(matrix: String): List<List<Double>>{
    val rows = matrix.split('\n')
    val nodes = rows.flatMap { it.split(",") }.map { it.toDouble() }
    return nodes.mapIndexed { i, node ->
        generateSequence(Double.POSITIVE_INFINITY, { x -> x}).take(80).mapIndexed { j, trans ->
            if (i + 1 == j || i + 80 == j) nodes[j] else trans
        }.toList()}
}