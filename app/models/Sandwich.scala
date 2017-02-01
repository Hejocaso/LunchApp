package models

case class Sandwich(name:String, price: Double) {
  def getSandwiches: List[String] = {
    val sandwichList = List("Ham and Cheese", "SpicyChicken", "etc.")
    sandwichList
  }
}
