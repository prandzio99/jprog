import akka.actor._

object Message {
    case class Send(a: Double, b: Double, c: Double, server: ActorRef)
    case class Check(a: Double, b: Double, c: Double) 
}

class Client extends Actor {
    import Message._
    def receive: Receive = {
        case Send(a: Double, b: Double, c: Double, server: ActorRef) => server ! Check(a: Double, b: Double, c: Double)
        case true => println("Podane odcinki tworzą trójkąt :)")
        case false => println("Podane odcinki nie tworzą trójkąta :(")
    }
}

class Server extends Actor {
    import Message._
    def receive: Receive ={
        case Check(a: Double, b: Double, c: Double) => 
        if (a+b>c || b+c>a || c+a>b) {sender() ! true}
        else {sender() ! false}
    }
}

object zad1 extends App {
    import Message._
    val system = ActorSystem("Connection")
    val client = system.actorOf(Props[Client], "client")
    val server = system.actorOf(Props[Server], "server")
    client ! Send(3, 4, 5, server)
}