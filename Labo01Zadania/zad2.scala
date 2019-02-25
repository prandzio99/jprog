object Main extends App {
  println("Podaj liczbę:")
  var number = io.StdIn.readInt()
  if (number % 2 == 1) {
    println("Liczba jest nieparzysta.")
  }
  else {
    println("Liczba jest parzysta.")
  }
}