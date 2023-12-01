import java.io.InputStream
import java.io.OutputStream
import java.lang.StringBuilder

public fun Day1(inp: InputStream, out: OutputStream) {
    val input = generateSequence(::readLine)
    val lines = input.toList()

    inp.reader().forEachLine { lines.plus(it) }

    val ints = lines.map { it: String ->
        val str = StringBuilder("")
        var index = 0;
        while (index < it.length) {
            val c = it[index]
            if (c.isDigit() && c != '0') {
                str.append(c)

            } else when (c) {
                'o' -> {
                    if (it.length - index >= 2) {
                        if (it[index + 1] == 'n' && it[index + 2] == 'e') {
                            str.append("1")
                        }
                    }
                }

                't' -> {
                    if (it.length - index >= 2) {
                        if (it[index + 1] == 'w' && it[index + 2] == 'o') {
                            str.append("2")

                        }
                    }
                    if (it.length - index >= 4) {
                        if (it[index + 1] == 'h' && it[index + 2] == 'r' && it[index + 3] == 'e' && it[index + 4] == 'e') {
                            str.append("3")

                        }
                    }

                }

                'f' -> {
                    if (it.length - index >= 3) {
                        if (it[index + 1] == 'o' && it[index + 2] == 'u' && it[index + 3] == 'r') {
                            str.append("4")

                        }
                        if (it[index + 1] == 'i' && it[index + 2] == 'v' && it[index + 3] == 'e') {
                            str.append("5")

                        }
                    }

                }

                's' -> {
                    if (it.length - index >= 2) {
                        if (it[index + 1] == 'i' && it[index + 2] == 'x') {
                            str.append("6")

                        }

                    }
                    if (it.length - index >= 4) {
                        if (it[index + 1] == 'e' && it[index + 2] == 'v' && it[index + 3] == 'e' && it[index + 4] == 'n') {
                            str.append("7")

                        }
                    }
                }

                'e' -> {
                    if (it.length - index >= 4) {
                        if (it[index + 1] == 'i' && it[index + 2] == 'g' && it[index + 3] == 'h' && it[index + 4] == 't') {
                            str.append("8")

                        }
                    }
                }

                'n' -> {
                    if (it.length - index >= 3) {
                        if (it[index + 1] == 'i' && it[index + 2] == 'n' && it[index + 3] == 'e') {
                            str.append("9")

                        }
                    }
                }

                else -> {
                    str.append(c)
                }
            }
            index++
        }

        str.toString()


    }

    var sum = 0;
    ints.mapIndexed inn@{ id: Int, it: String ->
        var start = 0
        var end = it.length - 1

        while (start <= end) {
            if (!it[start].isDigit()) {
                start++
            }
            if (!it[end].isDigit()) {
                end--
            }
            if (it[start].isDigit() && it[end].isDigit() && it[start] != '0' && it[end] != '0') {
                val combined = "${it[start]}${it[end]}".toInt()
                println("$id. ${lines[id]} -> ${ints[id]} -> $it -> $combined")
                return@inn combined
            }
        }

    }.filterIsInstance<Number>().forEach { sum = sum + it.toInt() }
    println(sum)
    return
}
