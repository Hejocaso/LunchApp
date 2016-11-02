package controllers

import javax.inject._

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

@Singleton
class HomeController @Inject() extends Controller {

  //val greeter = RealTimeGreeterService

  val fakeGreeter = FakeMorningGreeter

  def landing(message: String = "Morning") = Action {
    Ok(views.html.landing(message))
  }

}
