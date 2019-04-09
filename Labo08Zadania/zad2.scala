object Main extends App {
    def position[A](seq: Seq[A], el: A): Option[Int] = {
        seq.zipWithIndex.find(n => (n._1 == el)).map(n => n._2)
    }
    println(position(Seq(2,1,1,5),1))
}