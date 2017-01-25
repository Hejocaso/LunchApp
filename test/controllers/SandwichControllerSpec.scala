//package controllers
//
//import models.Sandwich
//import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
//import play.api.test.FakeRequest
//import play.api.test.Helpers._
//import services.SandwichService
//
//class SandwichControllerSpec extends PlaySpec with OneAppPerSuite {
//
//  class NoSandwichSandwichService extends SandwichService {
//    override def getSandwiches(): List[Sandwich] = ???
//  }
//
//  "SandwichController" should {
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
//  }
//}
