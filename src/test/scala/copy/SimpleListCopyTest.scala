package copy

import org.scalatest.FunSpec

class SimpleListCopyTest extends FunSpec  {

  val src = List(
    ImmutableEntity(1),
    ImmutableEntity(2),
    ImmutableEntity(3),
    ImmutableEntity(4),
    ImmutableEntity(5)
    )

  describe("class SimpleListCopy") {
    val target = new SimpleListCopy()
    describe("copyAsSameのテスト") {
      val actual = target.copyAsSame(src)
      it("copyAsSameで別のインスタンスを生成して返しているかの判定") {
        assert(actual.ne(src))
      }
      it("copyAsSameで返されたリストの要素の値比較") {
        assert(actual == src)
        actual.zipWithIndex.foreach({case(x, i) =>
          assert(x.eq(src.apply(i)))
        })
      }
    }
    describe("copyAsCloneのテスト") {
      val actual = target.copyAsClone(src)
      it("copyAsCloneで別のインスタンスを生成して返しているかの判定") {
        assert(actual.ne(src))
        assert(actual == src)
        actual.zipWithIndex.foreach({case(x, i) =>
          assert(x.ne(src.apply(i)))
        })
      }
      it("copyAsCloneで返されたリストの要素の値比較") {
        assert(actual == src)
        actual.zipWithIndex.foreach({case(x, i) =>
          assert(x.ne(src.apply(i)))
        })
      }
    }
    describe("copyAsPartialのテスト") {
      val actual = target.copyAsPartial(src, 1, 3)
      it("copyAsPartialで別のインスタンスを生成して返しているかの判定") {
        assert(actual.ne(src))
      }
      it("copyAsPartialで返されたリストの要素の値比較") {
        assert(actual.size == 3)
        actual.zipWithIndex.foreach({case(x, i) =>
          assert(x == src.apply(i + 1))
          assert(x.eq(src.apply(i + 1)))
        })
      }
    }
  }

}