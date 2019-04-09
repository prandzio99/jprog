object Main extends App {
    def sum(seq: Seq[Option[Double]]): Double = {
        seq.foldLeft(0.0)((acc: Double, curr: Option[Double]) => curr match {
            case Some(i) => acc + i
            case None => acc
        })
    }

    println(sum(Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))))
}