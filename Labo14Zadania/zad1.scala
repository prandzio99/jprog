import akka.actor._

case class Odbierz(wiadomosc: String)
case object Wyswietl

class Nadzorca extends Actor {
    def receive = odbieraj

    def odbieraj: Receive = {
        case Odbierz(wiadomosc: String) => 
            context.become(wyswietlaj(wiadomosc)) 
            self ! Wyswietl
    }

    def wyswietlaj(wiadomosc: String): Receive = {
        case Wyswietl => 
            println(wiadomosc) 
            context.become(odbieraj)
    }

}

object zad1 extends App {
    val system = ActorSystem("system")
    val nadzorca = system.actorOf(Props[Nadzorca], "Nadzorca")
    nadzorca ! Odbierz("Czesc!")
}