package services

import models.Sandwich


trait SandwichService {
  def allSandwiches(): List[Sandwich]
}
object SandwichService extends SandwichService {
  override def allSandwiches(): List[Sandwich] = {
    List()
  }
}
