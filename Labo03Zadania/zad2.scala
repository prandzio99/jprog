object Main extends App {
    
    def palindrom(tab: Array[Int]): Boolean = {
        def palindromHelp(tablica: Array[Int], start: Int, end: Int): Boolean = {
            if(start>end){true}
            else {
                if(tablica.length==0||tablica.length==1) {true}
                else {
                    if(tablica(start)!=tablica(end)) {false}
                    else palindromHelp(tablica, start+1, end-1)
                }
            }
        }
        palindromHelp(tab, 0, tab.length-1)
    }

    println("Podaj długość tablicy: ")
    var n = io.StdIn.readInt()
    println("Podaj tablice: ")
    var input = new Array[Int](n)
    var i = 0
    while (i < n){
        input(i)=io.StdIn.readInt()
        i+=1
    }
    println("Sprawdzam czy podana tablica jest palindromem...")
    if(palindrom(input)){
        println("Podana tablica jest palindromem :)")
    }
    else
    println("Podana tablica nie jest palindromem :(")
}