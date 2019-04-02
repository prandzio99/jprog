object Main extends App {
    def subseq[A](seq: Seq[A], begIndx: Int, endIndx: Int): Seq[A] = {
        seq.drop(begIndx-1).take(endIndx-begIndx+1)
    }

    println(subseq(Seq(1,2,3,4,5,6,7), 4, 6))
}