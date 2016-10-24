package controllers

import javax.inject.Inject

import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

import scala.collection.mutable.ArrayBuffer

class MenuController @Inject() extends Controller {

  val menuForm = Form(
    mapping(
      "item" -> nonEmptyText,
      "price" -> number(min = 0, max = 10)
    )(MenuData.apply)(MenuData.unapply)
  )

  private val menuItems = ArrayBuffer(
    ("Menu",123)
  )

  case class MenuData(itemName:String, price: Int)

  def createMenu = Action { implicit request =>
    val validateForm = menuForm.bindFromRequest()
    validateForm.fold({ formWithErrors =>
      BadRequest(views.html.menuPage(formWithErrors))
    }, { menuForm =>
      Redirect(routes.Application.menuPage)
    })
  }

  def showMenu = Action { implicit request =>
    //Pass an unpopulated form to the template
    Ok(views.html.menuPage(menuItems.toSeq, menuForm))
  }


//  menuForm.bindFormRequest.fold(
//    formWithErrors => {
//      //binding failure, you retrieve the form containing errors:
//      BadRequest(views.html.menuPage(formWithErrors))
//    },
//    menuForm => {
//      //binding success, you get the actual value
//      val
//    }
//  )
}
