package day5

import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception

enum class StrState(s: String) {
    Init("init"),
    seedtosoil("seed-to-soil"),
    soiltofertilizer("soil-to-fertilizer"),
    fertilizertowater("fertilizer-to-water"),
    watertolight("water-to-light"),
    lighttotemperature("light-to-temperature"),
    temperaturetohumidity("temperature-to-humidity"),
    humiditytolocation("humidity-to-location")
}
fun Day5(inp : InputStream, out: OutputStream) {
    var lines =  inp.reader().readLines().toMutableList()

    val x = lines.get(0).removePrefix("seeds: ").split(" ").windowed(2,2).map{
        val start = it.get(0).toLong()
        val mod = it.get(1).toLong()

        var z = LongRange(start, start+mod-1)
        z.step(500)

    }


    lines = lines.subList(1,lines.size)
    var curState = StrState.Init;
    val mappings = mutableMapOf<StrState,MutableMap<LongRange,LongRange>>()

    lines.forEach {
        val z = it.split(" ").get(0).removeSuffix(":")
        val isHeader = safeValueOf<StrState>(z)?.let {

            curState = it
            mappings[curState] = mutableMapOf<LongRange,LongRange>()
            true
        }
        val split = it.split(" ")
        if (isHeader != true){
            if(curState != StrState.Init && split.getOrNull(0)?.getOrNull(0)?.isDigit() == true){

                    mappings[curState]?.let {  it[split[1].toLong().rangeTo(split[1].toLong().plus(split[2].toLong()))] =split[0].toLong().rangeTo(split[0].toLong().plus(split[2].toLong()))

            }}


        }
    }
    var min = Long.MAX_VALUE

   val o =  x.asSequence().forEach{it.asSequence().forEachIndexed {index,it->
       it


//           println("${it.toLong()} in ${StrState.seedtosoil}")
           var zzz = mappings[StrState.seedtosoil]!!.filter { e ->
               e.key.contains(it.toLong())
           }
           var curr = it.toLong()
           var step = (0).toLong()

           if (zzz.size > 0) {

               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }


           // println("${ curr } in ${StrState.soiltofertilizer}")

           zzz = mappings[StrState.soiltofertilizer]!!.filter { e ->
               e.key.contains(curr)
           }



           if (zzz.size > 0) {
               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }


           // println("${curr} in ${StrState.fertilizertowater}")

           zzz = mappings[StrState.fertilizertowater]!!.filter { e ->
               e.key.contains(curr)
           }

           if (zzz.size > 0) {
               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }


           // println("$curr in ${StrState.watertolight}")

           zzz = mappings[StrState.watertolight]!!.filter { e ->
               e.key.contains(curr)
           }

           if (zzz.size > 0) {
               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }
           // println("$curr in ${StrState.lighttotemperature}")


           zzz = mappings[StrState.lighttotemperature]!!.filter { e ->
               e.key.contains(curr)
           }

           if (zzz.size > 0) {
               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }

           // println("$curr in ${StrState.temperaturetohumidity}")

           zzz = mappings[StrState.temperaturetohumidity]!!.filter { e ->
               e.key.contains(curr)
           }

           if (zzz.size > 0) {
               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }


           // println("$curr in ${StrState.humiditytolocation}")

           zzz = mappings[StrState.humiditytolocation]!!.filter { e ->
               e.key.contains(curr)
           }


           if (zzz.size > 0) {
               step = zzz.values.toList().get(0).first - zzz.keys.toList().get(0).first
               curr += step
           }

           if (curr < min) {
               println("$it -> $curr")
               min = curr
           }


       }
   }

    out.write(min.toString().plus('\n').toByteArray())

}

inline fun <reified T : kotlin.Enum<T>> safeValueOf(type: String?): T? {

    return try{

        java.lang.Enum.valueOf(T::class.java, type?.split('-')?.joinToString(""))
    } catch (e:Exception){
        null
    }
}