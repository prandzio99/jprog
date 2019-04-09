object Main extends App {
  def countChars(str: String): Int = {
    str.groupBy(identity).size
  }

  println(countChars("String"))
}
