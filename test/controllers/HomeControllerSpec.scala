package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._


/**
  * Created by helen on 26/10/16.
  */
class HomeControllerSpec extends PlaySpec with OneAppPerSuite  {

  //Replace HomePageController with stuff here

  object FakeMorningGreeter extends TimeGreetingService {
    def greeting = "Morning"
  }

  object FakeAfternoonGreeter extends TimeGreetingService {
    def greeting = "Afternoon"
  }

  object TestHomeControllerTest extends HomeController
  val controller = TestHomeControllerTest

  "The Home page controller" should {
    "say morning" when {
      val result = controller.land(FakeMorningGreeter.greeting).apply(FakeRequest(GET, "/land"))
      status(result) mustBe OK

      contentAsString(result) must include ("lunch?")
      contentAsString(result) must include ("Morning")
    }

    "say afternoon" when {
      val result = controller.land(FakeAfternoonGreeter.greeting)(FakeRequest(GET, "/land"))
      status(result) mustBe OK

      contentAsString(result) must include ("lunch?")
      contentAsString(result) must include ("Afternoon")
    }

    "have some content" when {
      val result = controller.land()(FakeRequest(GET, "/land"))
      status(result) mustBe OK
      contentAsString(result) must include ("Morning, want to order lunch?")
    }

    "Say hello" when {
      "I go to the landing page" in {
        val result = route(app, FakeRequest(GET, "/land"))
        result.map(contentAsString(_)).get must include ("want to order lunch?")
      }
    }
  }
}
