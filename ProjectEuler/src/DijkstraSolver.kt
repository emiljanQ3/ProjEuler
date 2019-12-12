fun dijkstraShortestPathSum(startIndex: Int, endIndex: Int, transitionMatrix: List<List<Double>>, startValue: Double, nodeDistance: MutableList<Double> = sequenceOf(Double.POSITIVE_INFINITY, ::identity).take(80).toMutableList()):Double{
    return if(startValue == Double.POSITIVE_INFINITY || startIndex == endIndex){
        startValue
    }else{
        nodeDistance[startIndex] = startValue
        transitionMatrix[startIndex].mapIndexed { index, it -> dijkstraShortestPathSum(index, endIndex, transitionMatrix, startValue + it) }.min()!!
    }
}

private fun <T> identity(x: T): T = x
