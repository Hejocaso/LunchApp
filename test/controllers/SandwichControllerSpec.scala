package controllers

import models.Sandwich
import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.SandwichService

class SandwichControllerSpec extends PlaySpec with OneAppPerSuite {

  class NoSandwichSandwichService extends SandwichService {
    override def getSandwiches(): List[Sandwich] = ???
  }

  "Exist as a route" when {
    "I go to the sandwich page" in {
      val result = route(app, FakeRequest(GET, "/sandwiches"))
      status(result.get) mustBe OK
    }

    "Display a welcome message" in {
      val controller = SandwichesController
      val result = controller.sandwiches()(FakeRequest(GET, "foo"))
      status(result) mustBe OK
      contentAsString(result) must include ("Want to order lunch?")
    }

    "Display a welcome message when there are no sandwiches" in {
      val noSandwichService = NoSandwichService
      val controller = SandwichesController
      val result = controller.sandwiches()(FakeRequest(GET, "foo"))
      status(result) mustBe OK
      contentAsString(result) must include ("Want to order lunch?")
      contentAsString(result) must include ("Sorry, we're sold out")
    }


    //    "find the page" in {
    //      val result = route(app, FakeRequest(GET, "/sandwiches"))
    //      status(result.get) must not be NOT_FOUND
    //    }
    //
    //    "show 'no sandwiches' when provided with no sandwiches" in {
    //      val controller = new SandwichController {
    //        val sandwichService = new NoSandwichSandwichService
    //      }
    //
    //      val result = controller.getSandwiches.apply(FakeRequest())
    //      contentAsString(result) must include ("No sandwiches")
    //    }
  }
}
