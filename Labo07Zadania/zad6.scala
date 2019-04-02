object Main extends App {
  def countChars(str: String): Int = {
    str.toCharArray.count(isLetter)
  }

  def isLetter(c: Char): Boolean = {
    if (c>='A' && c<='Z' || c>='a' && c<='z') true
    else false
  }

  println(countChars("String"))
}