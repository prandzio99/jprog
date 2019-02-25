object Main extends App {
  var a = io.StdIn readInt()
  var b = io.StdIn.readInt()
  while (a!=b) {
    if(a<b) {
      b=b-a
    }
    if(b<a) {
      a=a-b
    }
  }
  print("NWD: ")
  println(a)
}