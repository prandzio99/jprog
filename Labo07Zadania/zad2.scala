object Main extends App {
    def pairPosNeg(seq: Seq[Double]): (Seq[Double], Seq[Double]) = {
        seq.filter(_!=0.0).partition(_>0.0)
    }
    println(pairPosNeg(Seq[Double](1,0,5,6,-2,-3,4)))
}