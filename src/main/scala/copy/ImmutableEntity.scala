package copy

class ImmutableEntity( val id: Int) extends Cloneable {
  override def clone: ImmutableEntity = super.clone.asInstanceOf[ImmutableEntity]

  // hashCodeとequalsをoverrideしておかないとコレクションの比較が正常に動作しない
  override def hashCode = id
  override def equals(other: Any) = other match {
    case that: ImmutableEntity => this.id == that.id
    case _ => false
  }
}

// インスタンス生成を楽にするためにコンパニオンオブジェクトを定義しておく
object ImmutableEntity {
  def apply(id: Int) = {
    new ImmutableEntity(id)
  }
}