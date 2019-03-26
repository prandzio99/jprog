object Main extends App {
    def divide[A](seq: Seq[A]): (Seq[A], Seq[A]) = {
        def divHelp(seq: Seq[A], isEven: Boolean, output1: Seq[A], output2: Seq[A]): (Seq[A], Seq[A]) = {
            seq match {
                case Seq() => (output1, output2)
                case _ => isEven match{
                    case true => divHelp(seq.tail, false, output1 :+ seq.head, output2)
                    case false => divHelp(seq.tail, true, output1, output2 :+ seq.head)
                }
            }
        }
        divHelp(seq, true, Seq.empty[A], Seq.empty[A])
    }


    val a = Seq(0, 1, 2, 3, 4, 5)
    println(divide(a))
}