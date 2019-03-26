object Main extends App {
    def size
    
    def reverse
    
    def applyForAll
    
    def filter
    
    def forAll
    
    def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = {
        def helpCompute(seq: Seq[A], res: B): B ={
            seq match {
                case Seq() => res
                case _ => helpCompute(seq.tail, op(seq.head,res))
            }
        }
    helpCompute(seq, init)
    }
}