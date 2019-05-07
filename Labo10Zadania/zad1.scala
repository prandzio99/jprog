object Main extends App {
    val secret = Seq(1, 3, 2, 2, 4, 5)
    val guess = Seq(2, 1, 2, 4, 7, 2)

    val black = secret.zip(guess).count(para => para._1 == para._2)
    val white = secret.intersect(guess).length - black
    println("Black: " + black)
    println("White: " + white)
}