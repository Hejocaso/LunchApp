package controllers

import com.google.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}

@Singleton
class HomePageController @Inject() extends Controller {
  def landing(message: String = "Good morning Helen") = Action {
    Ok(views.html.landing(message))
  }
}
