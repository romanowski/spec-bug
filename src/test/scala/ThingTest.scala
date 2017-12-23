import org.specs2._
import org.specs2.specification.core.Fragment
import org.specs2.specification.core.Fragments

trait ThingTest
  extends org.specs2.mutable.SpecLike
  with org.specs2.specification.core.SpecificationStructure {

  def runTest(name: String): Fragment = {
    "Get a thing" in {
      success
    }
    "Get a thing twice" in {
      success
    }
  }

  "Ala" >> {
    runTest("1")
    runTest("2")
    runTest("3")
    runTest("4")
  }

  "Ala 2" >> {
    runTest("1")
    runTest("2")
    runTest("3")
    runTest("4")
  }
}

class FlatSpec extends ThingTest

class NestedSpec extends ThingTest {
  override def runTest(name: String): Fragment =
    name >> super.runTest(name)
}

class ExpludedSpec extends Specification with ThingTest{
  override def map(fs: => Fragments): Fragments =  section("ala") ^ super.map(fs) ^ section("ala")
}
