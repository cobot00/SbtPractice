package calculate

trait Calculator {
  def calculate(a: String, b: String, op: Operator.Value): Int
}
