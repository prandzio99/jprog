object Main extends App {
    def indices[A](seq: Seq[A], el: A): Set[Int] = {
        seq.zipWithIndex.filter(n => n._1 == el).map(n => n._2).toSet
    }
    println(indices(Seq(1,2,1,1,5),1))
    println(indices(Seq(1,2,1,1,5),7))
}