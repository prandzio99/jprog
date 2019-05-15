import scala.io.Source

object Main extends App {
    def histogram(max: Int): Unit = {
        val source: Seq[String] = Source.fromFile("ogniem_i_mieczem.txt").getLines.toList
        val chars = source.foldLeft(Seq.empty[Seq[Char]])((acc:Seq[Seq[Char]], curr: String) => acc:+curr.toVector.filter(_.isLetter).filter(_ != ' '))
    }
}