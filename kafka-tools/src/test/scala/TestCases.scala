import com.tyrantlucifer.utils.RandomNumUtil
import org.scalatest.funsuite.AnyFunSuite

class TestCases extends AnyFunSuite {
  test("random util of random item from a list") {
    val str = RandomNumUtil.randomItemFromList(List("1", "2", "3"))
    println(str)
  }
}
