object Main extends App {
  var countNegative = 0
  var countPositive = 0
  var number = io.StdIn.readInt()
  while (number != 0) {
    if (number > 0) {
      countPositive += 1
    }
    if (number < 0){
      countNegative += 1
    }
    number = io.StdIn.readInt()
  }
  print("Liczb dodatnich: ")
  println(countPositive)
  print("Liczb ujemnych: ")
  println(countNegative)
}