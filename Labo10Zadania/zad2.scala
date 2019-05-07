import scala.io.Source

object Main extends App {
    val input: Seq[String] = Source.fromFile("osoby.txt").getLines.toList
    val mirror = input.groupBy(_.size).mapValues(_.size).map(pair => (pair._1-1, pair._2))
    println(mirror)
}