import akka.actor._

case object Ping
case object Pong
case object KoniecGry
case class Graj(opp: ActorRef)

class Nadzorca extends Actor {
    var count = 0
    def receive: Receive = {
        case Graj(opp: ActorRef) => 
            count += 1
            println("Ping!")
            opp ! Pong
        case Ping =>
            Thread.sleep(250)
            println("       Pong!")
            sender ! Pong 
        case Pong =>
            Thread.sleep(250)
            count += 1
            println("Ping!")
            if (count > 10) {
                sender ! KoniecGry
                println("Game Ended")
                context.stop(self)
            } else {
                sender ! Ping
            }
        case KoniecGry =>
            context.stop(self)
    }
}

object zad1 extends App {
    val system = ActorSystem("PingPong")
    val player1 = system.actorOf(Props[Nadzorca], "player1")
    val player2 = system.actorOf(Props[Nadzorca], "player2")
    player1 ! Graj(player2)
}