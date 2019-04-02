object Main extends App {
    def freq[A](seq: Seq[A]): Map[A, Int] = {
        seq.groupBy(identity).mapValues(_.size).toMap
    }

    println(freq(Seq('a','b','a','c','c','a')))
}