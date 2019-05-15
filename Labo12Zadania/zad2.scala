import akka.actor._
import scala.io.Source

object Boss {
    case class Init(workerCount: Int)
    case class Errand(lines: Seq[String])
    case class Result(res: Int)
}

object Worker {
    case class Work(line: String)
    case class Res(result: Int)
}

class Boss extends Actor {
    import Boss._

    private def addWorkers(num: Int): Set[ActorRef] = {
        def helper(num: Int, output: Set[ActorRef]): Set[ActorRef] = num match {
            case 0 => output
            case _ => helper(num-1, output + context.actorOf(Props[Worker], s"worker$num"))
        }
        helper(num, Set.empty[ActorRef])
    }

    def receive: Receive = withoutWorkers

    def withoutWorkers: Receive = {
        case Init(n) => val workerSet = addWorkers(n)
            context.become(withWorkers(workerSet, n, Seq.empty[Int]))
    }

    def withWorkers(wSet: Set[ActorRef], wCount: Int, res: Seq[Int]): Receive = {
        case Errand(n) => n match {
            case Seq() => context.become(withWorkers(wSet, wCount, res))
            case Seq(head, tail @ _*) => wSet.head ! Worker.Work(head)
                context.become(withWorkers(wSet.tail, wCount, res))
                self ! Errand(tail)
        }
        case Result(n) => wCount match {
            case 1 => context.become(withoutWorkers)
                sender ! PoisonPill
                println((res :+ n).reduce(_+_))
            case _ => context.become(withWorkers(wSet, wCount-1, res :+ n))
                sender ! PoisonPill
        }
    }
}

class Worker extends Actor {
    import Worker._

    def receive = {
        case Work(n) => val res = n.split(" ").filter(_ != "").size
            sender ! Boss.Result(res)
    }
}

object zad2 extends App {
    val system = ActorSystem("sys")
    val input = Source.fromFile("ogniem.txt").getLines.toList
    val szef = system.actorOf(Props[Boss], "szef")
    import Boss._
    szef ! Init(input.size)
    szef ! Errand(input)
}