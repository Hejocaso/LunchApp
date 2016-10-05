package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest

/**
  * Created by helen on 21/09/16.
  */
class BreakfastAppControllerSpec extends PlaySpec with OneAppPerSuite {
  "BreakfastAppController" should {
    "not return 404" when {
      "we try to hit the route /home" in {
        route(app, FakeRequest(GET, "/home")).map(status(_)) must not be Some(NOT_FOUND)
      }
    }
  }
}
