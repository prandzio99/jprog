object Main extends App {
    def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = {
        def helpCompute(seq: Seq[A], res: B): B ={
            seq match {
                case Seq() => res
                case _ => helpCompute(seq.tail, op(seq.head,res))
            }
        }
        helpCompute(seq, init)
    }

    println(compute(Seq(1,2,3,4))(0)(op = (_ + _)))
    println(compute(Seq(1,2,3,4))(1)(op = (_ * _)))
    println(compute(Seq("kota", " ", "ma", " ", "ala"))("")(op = (_ + _)))

}