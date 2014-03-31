package copy

trait ListCopy {
  def copyAsSame(src: List[ImmutableEntity]): List[ImmutableEntity]
  def copyAsClone(src: List[ImmutableEntity]): List[ImmutableEntity]
  def copyAsPartial(src: List[ImmutableEntity], start: Int, end: Int): List[ImmutableEntity]
}