import akka.actor._

case class Odbierz(wiadomosc:String)

class Nadzorca extends Actor with Stash {
    def receive = unstashedHandler

    def unstashedHandler: Receive = {
        case Odbierz(wiadomosc) => wiadomosc match {
            case "zmien" => 
                unstashAll()
                context.become(stashHandler)
            case _ => 
                stash()
        }
    }
    
    def stashHandler: Receive = {
        case Odbierz(wiadomosc) => wiadomosc match {
            case "zmien" => context.become(unstashedHandler)
            case wiadomosc => println(wiadomosc)
        }
    }
}

object zad2 extends App {
    val system = ActorSystem("system")
    val client = system.actorOf(Props[Nadzorca], "client")

    client ! Odbierz("wiadomosc 1")
    client ! Odbierz("wiadomosc 2")
    client ! Odbierz("zmien")
    client ! Odbierz("wiadomosc 3")
}