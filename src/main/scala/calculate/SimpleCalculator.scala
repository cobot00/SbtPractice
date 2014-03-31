package calculate

import Operator._

class SimpleCalculator extends Calculator {
  def calculate(a: String, b: String, op: Operator.Value): Int = {

    try {
      val na = a.toInt
      val nb = b.toInt

      op match {
        case PLUS => na + nb
        case MINUS => na - nb
        case MULTIPLY => na * nb
        case DIVIDE => if (nb == 0) throw new CalculationException() else na / nb
      }
    } catch {
      case e: NumberFormatException => throw new CalculationException()
    }
  }

}
