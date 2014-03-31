package collection_convert

class StringKeyEntity(val key: String, val value: Int) extends Cloneable {
  override def clone: StringKeyEntity = super.clone.asInstanceOf[StringKeyEntity]
  override def hashCode = key.hashCode
  override def equals(other: Any) = other match {
    case that: StringKeyEntity => this.key == that.key
    case _ => false
  }
}

// インスタンス生成を楽にするためにコンパニオンオブジェクトを定義しておく
object StringKeyEntity {
  def apply(key: String, value: Int) = {
    new StringKeyEntity(key, value)
  }
}