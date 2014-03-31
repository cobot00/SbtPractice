package copy

class SimpleListCopy extends ListCopy {
  def copyAsSame(src: List[ImmutableEntity]): List[ImmutableEntity] = {
    val buf = scala.collection.mutable.ListBuffer[ImmutableEntity]()
    src.foreach({e => buf += e})
    buf.toList
  }

  def copyAsClone(src: List[ImmutableEntity]): List[ImmutableEntity] = {
    val buf = scala.collection.mutable.ListBuffer[ImmutableEntity]()
    src.foreach({e => buf += e.clone})
    buf.toList
  }

  def copyAsPartial(src: List[ImmutableEntity], start: Int, end: Int): List[ImmutableEntity] = {
    src.slice(start, end + 1)
  }
}