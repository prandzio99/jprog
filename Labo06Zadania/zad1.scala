object Main extends App {
    def applyForAll[A,B](seq: Seq[A])( f: A => B): Seq[B] = {
        def applyHelp(seq: Seq[A], output: Seq[B]): Seq[B] = {
            (seq) match {
                case Seq() => output
                case _ => applyHelp(seq.tail, output :+ f(seq.head))
            }
        }
        applyHelp(seq, Seq.empty[B])
    }

    val a = Seq(1, 3, 5)
    println(applyForAll(a)((n) => n+3))
}