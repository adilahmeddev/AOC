import day1.Day1
import day2.Day2
import java.io.File

fun main(args: Array<String>) {
    println("Hello World!")


    Day1(File("./day1/input.txt").inputStream(),System.`out`)
    Day2(File("./day2/input.txt").inputStream(),System.`out`)
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}