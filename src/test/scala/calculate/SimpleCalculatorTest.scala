package calculate

import org.scalatest.FunSpec
import Operator._

class SimpleCalculatorTest extends FunSpec  {

  describe("class SimpleCalculator") {
    describe("SimpleCalculatorの正常系テスト") {
      val target = new SimpleCalculator()
      it("1 + 2 -> 3") {
        assert(target.calculate("1", "2", PLUS) == 3)
      }
      it("2 + 3 -> 5") {
        assert(target.calculate("2", "3", PLUS) == 5)
      }
      it("3 - 2 -> 1") {
        assert(target.calculate("3", "2", MINUS) == 1)
      }
      it("2 - 3 -> -1") {
        assert(target.calculate("2", "3", MINUS) == -1)
      }
      it("2 * 3 -> 6") {
        assert(target.calculate("2", "3", MULTIPLY) == 6)
      }
      it("3 * -4 -> -12") {
        assert(target.calculate("3", "-4", MULTIPLY) == -12)
      }
      it("6 / 3 -> 2") {
        assert(target.calculate("6", "3", DIVIDE) == 2)
      }
      it("7 / 3 -> 2") {
        assert(target.calculate("7", "3", DIVIDE) == 2)
      }
    }
    describe("SimpleCalculatorの異常系テスト") {
      val target = new SimpleCalculator()
      it("'' + 1 -> CalculationException") {
        intercept[CalculationException] {
          target.calculate("", "1", PLUS)
        }
      }
      it("1 + '' -> CalculationException") {
        intercept[CalculationException] {
          target.calculate("1", "", PLUS)
        }
      }
      it("5 / 0 -> CalculationException") {
        intercept[CalculationException] {
          target.calculate("5", "0", DIVIDE)
        }
      }
    }
  }

}