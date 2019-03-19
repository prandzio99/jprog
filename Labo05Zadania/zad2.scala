object Main extends App {
    def insertInto[A](a: A, seq: Seq[A])(pred: (A, A) => Boolean): Seq[A] = {
        def insertHelper(a: A, seq: Seq[A], res: Seq[A])(pred: (A,A)=>Boolean): Seq[A] = {
            if(pred(a, seq.head)) (res:+a)++seq
            else insertHelper(a, seq.tail, res:+seq.head)(pred)
        }
        insertHelper(a, seq, Seq.empty)(pred)
    }

    type pred[A]=(A,A)=>Boolean
    var s1=Seq(1,3,6)
    var z:pred[Int]=(x:Int, y:Int)=>x<y
    println(insertInto(0, s1)(z)) 
}