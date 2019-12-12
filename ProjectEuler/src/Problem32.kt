fun main(){
    val elements = listOf(1,2,3,4,5,6,7,8,9)
    val permutations = permutationsOf(elements)
    val products = findPandigitalProducts(permutations)
    println(products)
    val uniqueProducts = products.map { it.third }.distinct()
    println(uniqueProducts)
    println(uniqueProducts.sum())
}

/*
1*2345=6789
12*345=6789
123*45=6789
1234*5=6789
12345=6789
 */

fun findPandigitalProducts(permutations: List<List<Int>>): List<Triple<Int, Int, Int>> {
    val pandigitalProducts = mutableListOf<Triple<Int, Int, Int>>()
    for (permutation in permutations){

        for(multPos in 1..4){
            val first = permutation.take(multPos)               .fold(0, {x,y -> x*10 + y})
            val second = permutation.take(5).drop(multPos)  .fold(0, {x,y -> x*10 + y})
            val result = permutation.drop(5)                .fold(0, {x,y -> x*10 + y})
            if (first*second == result) pandigitalProducts.add(Triple(first, second, result))
        }


    }
    return pandigitalProducts
}