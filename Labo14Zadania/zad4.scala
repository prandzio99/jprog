import akka.actor._

object Pracownik {
    case class Wynik(num1: Double, num2: Double)
    case object Zmien
}

class Pracownik extends Actor {
    import Pracownik._

    def receive = dodawaj

    def dodawaj: Receive = {
        case Wynik(num1: Double, num2: Double) => println(num1+num2)
        case Zmien => context.become(dziel)
    }

    def dziel: Receive = {
        case Wynik(num1: Double, num2: Double) => println(num1/num2)
        case Zmien => context.become(dodawaj)
    }
}

object zad4 extends App {
    import Pracownik._
    val system = ActorSystem("system")
    val pracownik = system.actorOf(Props[Pracownik], "pracownik")

    pracownik ! Wynik(2,2)
    pracownik ! Zmien
    pracownik ! Wynik(2,2)
    pracownik ! Zmien
    pracownik ! Wynik(2,2)
}