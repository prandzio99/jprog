object Main extends App {
    def isOrdered[A](seq: Seq[A])(pred: (A, A) => Boolean): Boolean = {
        def isOrderedHelper(seq: Seq[A], result: Boolean): Boolean = {
            if(seq.tail.isEmpty|| result == false) result
            else if(pred(seq.head, (seq.tail).head)) isOrderedHelper(seq.tail, true)
            else isOrderedHelper(seq, false)
        }
        isOrderedHelper(seq, true)
    }

    println("Podaj długość sekwencji: ")
    val length = io.StdIn.readInt()

    println("Podaj sekwencje: ")
    val arr = new Array[Int](length)
    
    var n = 0
    while(n<length) {
        arr(n) = io.StdIn.readInt()
        n+=1
    }
    
    if(isOrdered(arr)((m, n)=> m < n)){
        println("Sekwencja jest w kolejności rosnącej.")
    }
    else println("Sekwencja jest w innej kolejności.")
}