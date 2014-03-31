package calculate

class CalculationException(message :String = null, cause :Throwable = null)
extends RuntimeException(message, cause)