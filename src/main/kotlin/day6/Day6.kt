package day5

import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception


fun Day6(inp : InputStream, out: OutputStream) {
    var lines =  inp.reader().readLines().toMutableList()


    val numbers = lines.reduce{acc,s-> acc + " " +s.split(":").get(1)}.split(" ").map { it.toInt() }


    val times =    numbers.subList(0,3)
    val distances =    numbers.subList(3,numbers.size)
    val mappings = times.mapIndexed{index,s-> s to distances.get(index) }

    mappings.forEach {
        val time = it.first
        val distance = it.second


    }
//    out.write(o.toString().plus('\n').toByteArray())

}

