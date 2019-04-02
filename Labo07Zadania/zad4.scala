object Main extends App {
    def remElems[A](seq: Seq[A], k: Int): Seq[A] = {
        seq.zipWithIndex.filter(_._2 != k).map(_._1)
    }
    println(remElems(Seq(1,2,3,4,5,6,7), 4))
}