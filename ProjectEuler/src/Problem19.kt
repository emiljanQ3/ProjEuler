import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

fun main(){
    println(sundaysTheFirstsBetween(LocalDate.of(1901, Month.JANUARY, 1), LocalDate.of(2000, Month.DECEMBER, 31)))
}

//tailrec fun sundaysTheFirstsBetween(start: LocalDate, finish: LocalDate): Long{
//    println("$start to $finish")
//    return when {
//        start == finish -> isSundayTheFirst(start)
//        start < finish -> isSundayTheFirst(start) + sundaysTheFirstsBetween(start.plusDays(1), finish)
//        else -> {
//            println("Undefined")
//            0L
//        }
//    }
//}

fun sundaysTheFirstsBetween(start: LocalDate, finish: LocalDate): Long{
    println("$start to $finish")
    var counter = 0L
    var date = start
    while (date <= finish){
        if (isSundayTheFirst(date)) counter++
        date = date.plusMonths(1)
    }
    return counter
}


fun isSundayTheFirst(date: LocalDate): Boolean = date.dayOfWeek == DayOfWeek.SUNDAY && date.dayOfMonth == 1