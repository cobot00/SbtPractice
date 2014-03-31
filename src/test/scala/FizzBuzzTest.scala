import org.scalatest.FunSpec

class FizzBuzzTest extends FunSpec {

  describe("class FizzBuzz") {
    // tuple list
    val expected = List(
      (1,"1"),(2,"2"),(3,"Fizz"),(4,"4"),(5,"Buzz"),
      (6,"Fizz"),(7,"7"),(8,"8"),(9,"Fizz"),(10,"Buzz"),
      (11,"11"),(12,"Fizz"),(13,"13"),(14,"14"),(15,"FizzBuzz"),
      (16,"16"),(30,"FizzBuzz"),(33,"Fizz"),(35,"Buzz")
    )

    val target = new FizzBuzz()
    describe("FizzBuzzのテスト") {
      it("網羅的なテスト") {
        expected.foreach({e =>
          assert(target.fizzBuzz(e._1) == e._2)
        })
      }

      /* 「it」で囲っていないのでこれはテスト結果にカウントされない。
      / ※ScalaTestの実行結果は以下のように出力される
      / [info] Run completed in 373 milliseconds.
      / [info] Total number of tests run: 12
      / [info] Suites: completed 2, aborted 0
      / [info] Tests: succeeded 12, failed 0, canceled 0, ignored 0, pending 0
      */
      assert(target.fizzBuzz(100) == "Buzz")
    }
  }

}