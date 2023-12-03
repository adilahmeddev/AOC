package day3

import java.io.InputStream
import java.io.OutputStream
import java.lang.StringBuilder
import kotlin.math.max

fun Day3(inp: InputStream, out: OutputStream) {
    val linesRaw =  inp.reader().readLines()

    val padding = StringBuilder().padStart(140, '.').toString()
    val lines = listOf(padding).plus(linesRaw).plus(padding)

    var sum = 0
    val added = mutableListOf<Int>()

    lines.windowed(3,1).forEach { window ->
        val prev = window[0]
        val cur = window[1]
        val next = window[2]
        println( cur)
        fun checkLeft(index: Int):Boolean {
            return index>0 && (isSymbol(prev[index-1]) || isSymbol(cur[index-1]) || isSymbol(next[index-1]))
        }
        fun checkVert(index: Int):Boolean{
            return isSymbol(next[index]) || isSymbol(prev[index])
        }
        fun checkRight(index: Int):Boolean {
            return index<140-1 && (isSymbol(prev[index+1]) || isSymbol(cur[index+1]) || isSymbol(next[index+1]))
        }

        var onNum = false
        var recordNum = false
        var numStart = 0


        for ((i, c) in cur.withIndex()){
            if (!onNum){
                if (c.isDigit()){
                    onNum = true
                    numStart = i
                }
            }

            if (onNum){
                if(!c.isDigit() || i==139){
                    var ind = i
                    if( i==139 && c.isDigit()){
                        ind++
                    }
                    onNum=false
                    if (recordNum){
                        recordNum = false

                        sum += Integer.parseInt(cur.substring(numStart,ind))
                        added.add(Integer.parseInt(cur.substring(numStart,ind)))
                    }
                } else if(checkLeft(i) || checkVert(i) || checkRight(i)){
                    recordNum = true
                }

            }
        }
    }
    println(added)
    out.write(sum.toString().plus('\n').toByteArray())

    return
}


fun isSymbol(c: Char):Boolean{
    if (c.isDigit()){
        return false
    }
    if (c == '.'){
        return false
    }
    return true
}