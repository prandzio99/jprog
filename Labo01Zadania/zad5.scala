object Main extends App {
  var number = io.StdIn.readInt()
  var div = 2
  var isPrime = true

  while (isPrime == true && div < number) {
    if (number % div == 0) {
      isPrime = false
    }
    else {
      div+=1
    }
  }
  if (isPrime == true){
    println("Liczba jest pierwsza.")
  }
  else {
    println("Liczba nie jest pierwsza.")
  }
}