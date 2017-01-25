package controllers

import play.api.mvc.{Action, Controller}
import services.SandwichService


trait SandwichesController extends Controller {
  def sandwichService: SandwichService
}

object SandwichesController extends Controller {
  val sandwichService: SandwichService = SandwichService

//  def sandwiches() = Action {
//    Ok("foo")
//  }

  def sandwiches() = Action {
    Ok(views.html.sandwiches())
  }
}
