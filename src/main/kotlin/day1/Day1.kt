import java.io.InputStream
import java.io.OutputStream

public fun Day1(inp: InputStream, out: OutputStream){
    val i = inp.reader().readLines()
    val ints = i.mapNotNull inn@{
        var start = 0
        var end = it.length-1

        while (start<end){
            if (!it[start].isDigit()){
                start++
            }
            if (!it[end].isDigit()){
                end--
            }
            if (it[start].isDigit() && it[end].isDigit()){
                val combined = it[start].digitToInt()*10 + it[end].digitToInt()
                 return@inn combined
            }
        }

    }.filterIsInstance<Int>().reduce{acc, it ->
        acc+it
    }
   println(ints)
    return
}