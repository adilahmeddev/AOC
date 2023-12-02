package day2

import java.io.InputStream
import java.io.OutputStream
import kotlin.math.max

fun Day2(inp: InputStream, out: OutputStream) {
    val lines =  inp.reader().readLines()


    var c = 0
    val s = lines.map {
        var first = Regex("^Game ([0-9]+):\\s").find(it)
        var rest =  Regex("^Game ([0-9]+):\\s").replaceFirst(it,"")
        val rounds = rest.split(';')
        var power = Integer.MAX_VALUE
        rounds.forEach{ round ->
            var res  = Regex("(([0-9]{1,3}) ([a-z]{3,5})[^a-z]{0,1})").findAll(rest)
            var m = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)
            var o =  res.toList()
            o.forEach{z->
                m[z.groupValues[3]] = max(Integer.parseInt(z.groups.get(2)!!.value), m[z.groups.get(3)!!.value]!!)
            }
            if (power>max(m["red"]!!, 1)*max(m["blue"]!!, 1)*max(m["green"]!!, 1)){
                power = max(m["red"]!!, 1)*max(m["blue"]!!, 1)*max(m["green"]!!, 1)
            }
        }
        power
    }.sum()

    out.write(s.toString().plus('\n').toByteArray())

    return
}
