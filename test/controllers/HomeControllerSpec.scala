package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._


/**
  * Created by helen on 26/10/16.
  */
class HomeControllerSpec extends PlaySpec with OneAppPerSuite  {

  object FakeMorningGreeter extends TimeGreetingService {
    def greeting = "Morning, want to order lunch?"
  }

  object FakeAfternoonGreeter extends TimeGreetingService {
    def greeting = "Afternoon, want to order lunch?"
  }

  object TestHomeControllerTest extends HomeController
  val controller = TestHomeControllerTest

  "The Home page controller" should {
    "say morning" when {
      val result = controller.landing(FakeMorningGreeter.greeting)(FakeRequest(GET, "foo"))
      status(result) mustBe OK

      contentAsString(result) must include ("lunch?")
      contentAsString(result) must include ("Morning")
    }

    "say afternoon" when {
      val result = controller.landing(FakeAfternoonGreeter.greeting)(FakeRequest(GET, "foo"))
      status(result) mustBe OK

      contentAsString(result) must include ("lunch?")
      contentAsString(result) must include ("Afternoon")
    }

    "have some content" when {
      val result = controller.landing(FakeMorningGreeter.greeting)(FakeRequest(GET, "foo"))
      status(result) mustBe OK
      contentAsString(result) must include ("Morning, want to order lunch?")
    }

    "Say hello" when {
      "I go to the landing page" in {
        val result = controller.landing("Hello")(FakeRequest(GET, "foo"))
        contentAsString(result) must include ("Hello")
      }
    }

    "not return a 404" when {
      "I go to the route landing" in {
        route(app, FakeRequest(GET, "/landing")).map(status(_)) must not be Some(NOT_FOUND)
      }
    }
  }
}
