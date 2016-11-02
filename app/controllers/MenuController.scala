package controllers

import javax.inject.Inject

import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

class MenuController @Inject() extends Controller {

  case class MenuData(itemName:String, price: Int)

  val menuForm = Form(
    mapping(
      "item" -> nonEmptyText,
      "price" -> number(min = 0, max = 10)
    )(MenuData.apply)(MenuData.unapply)
  )

  val menuItems = Map(("item" -> "Meat", "price" -> 123),
                      ("item" -> "Fruit", "price" -> "price" -> 99),
                      ("item" -> "Salad", "price" -> 199))
  val menuData: MenuData = menuForm.bindFromRequest().get

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
//      //val
//    }
//  )
}
