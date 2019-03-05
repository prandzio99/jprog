object Main extends App {
  print{"Podaj liczbe parzystą większą od 2: "}
  var number = io.StdIn.readInt()
  while ( !(number%2==0 && number > 2) ) {
    println("Podaj liczbę parzystą większą od 2!!!")
    number = io.StdIn.readInt()
  }

  var a = number/2
  var b = number/2

  while ( !(isPrime(a) && isPrime(b))) {
    a += 1
    b -= 1
  }
  print("Liczba spełnia hipoteze Goldbacha: ")
  print(a)
  print(" + ")
  print(b)
  print(" = ")
  println(number)

  def isPrime (num:Int) : Boolean = {
    var div:Int = 2
    var isPrime:Boolean = true

    while (div<num && isPrime) {
      if (num % div == 0) {
        isPrime = false
      }
      else {
        div += 1
      }
    }
    return isPrime
  }
}
