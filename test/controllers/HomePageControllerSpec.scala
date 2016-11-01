package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._


/**
  * Created by helen on 19/10/16.
  */
class HomePageControllerSpec extends PlaySpec with OneAppPerSuite {
  "HomePageController" should {
    "not return 404" when {
      "I go to the route /landing" in {
        val result = route(app, FakeRequest(GET, "/land"))
        status(result.get) must not be(NOT_FOUND)
      }
    }
    "render the correct page with the expected text" when {
      "I navigate to the homepage" in {
        val result = controller.land().apply(FakeRequest(GET, "/land"))

        status(result) mustBe OK
        contentAsString(result) must include ("Good morning Helen")
        //arrange
        //action
        //assert
      }
      "I go to the homepage after lunch" in {
        val result = controller.land("Good afternoon Helen").apply(FakeRequest(GET, "/land"))

        contentAsString(result) must include ("Good afternoon Helen")
      }
    }
  }

  object TestController extends HomeController
  val controller = TestController
}
