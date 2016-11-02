package controllers

import org.joda.time.DateTime
import play.api.mvc._

trait TimeGreetingService {
  def greeting:String
}

//if you don't infer the type of a def in a trait, it will be Any instead

object RealTimeGreeterService extends TimeGreetingService{
  def greeting:String = {
    if (DateTime.now.hourOfDay().get < 12) {
      "Morning,"
    } else {
      "Afternoon,"
    }
  }
}

object FakeMorningGreeter extends TimeGreetingService {
  def greeting = "Morning, want to order lunch?"
}

trait HomeController extends Controller {
  def greeter: TimeGreetingService

  def landing(message: String = "Morning") = Action {
    Ok(views.html.landing(message))
  }
}

object HomeController extends HomeController {

  val greeter = RealTimeGreeterService

  //Notice it was def in the trait but now greeter is a val

  //val fakeGreeter = FakeMorningGreeter
}

