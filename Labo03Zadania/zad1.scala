object Main extends App {
    def odwroc(str: String): String = {
        def odwrocHelp(napis: String, n: Int): String = {
            if (n == -1) " "
            else napis(n)+odwrocHelp(napis, n-1)
        }
        odwrocHelp(str, str.length-1)
    }

    println("Podaj napis: ")
    var napis = io.StdIn.readLine
    println("Odwracam...")
    println(odwroc(napis))
}