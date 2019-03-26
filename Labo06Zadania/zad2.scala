object Main extends App {
    def applyForAll2[A,B,C](seq1: Seq[A], seq2: Seq[B])(f: (A, B) => C): Seq[C] = {
        def applyHelp2(seq1: Seq[A], seq2: Seq[B], output: Seq[C]): Seq[C] = {
            seq1 match {
                case Seq() => output
                case _ => seq2 match {
                    case Seq() => applyHelp2(seq1.tail, Seq.empty, output :+)
                    case _ => applyHelp2(seq1.tail, seq2.tail, output :+ f(seq1.head, seq2.head))
                }
            }
        }
        applyHelp2(seq1, seq2, Seq.empty[C])
    }

    var a = Seq(1, 3, 5, 6, 7)
    var b = Seq(2, 3, 4)

    println(applyForAll2(a,b)((n,m) => n+m))
}