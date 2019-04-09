object Main2 extends App {
    def position[A](seq: Seq[A], el: A): Option[Int] = {
        seq.zipWithIndex.filter(n => (n._1 == el)).headOption.map(n => n._2)
    }
    println(position(Seq(2,1,1,5),1))
}