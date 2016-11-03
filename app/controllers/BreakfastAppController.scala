package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}

/**
  * Created by helen on 21/09/16.
  */
class BreakfastAppController @Inject() extends Controller {
  def home = Action {
    Ok(views.html.index("Welcome to Play"))
  }
}
