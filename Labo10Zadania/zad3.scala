import scala.io.Source

object Main extends App {
    val input: Seq[String] = Source.fromFile("liczby.txt").getLines.toList
    val result = input.map(_.toInt).partition(n => n%2 == 0)
    println(result)
}