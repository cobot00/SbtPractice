package collection_convert

import org.scalatest.FunSpec

class SimpleCollectionCoverterTest extends FunSpec  {

  val src = List(
    StringKeyEntity("a", 1),
    StringKeyEntity("b", 2),
    StringKeyEntity("c", 3),
    StringKeyEntity("d", 4),
    StringKeyEntity("e", 5)
    )

  val srcDuplicated = List(
    StringKeyEntity("a", 1),
    StringKeyEntity("b", 2),
    StringKeyEntity("c", 3),
    StringKeyEntity("d", 4),
    StringKeyEntity("e", 5),
    StringKeyEntity("c", 13),
    StringKeyEntity("a", 11),
    StringKeyEntity("b", 12)
    )

  describe("class SimpleCollectionConverter") {
    val target = new SimpleCollectionConverter()
    describe("listToMapのテスト") {
      val actual = target.listToMap(src)
      it("listToMapで返されたMapの要素数の確認") {
        assert(actual.size == src.size)
      }
      it("listToMapで返されたMapの要素の確認") {
        src.foreach(e => {
          assert(actual.contains(e.key))
        })
      }
    }

    describe("listToMapAsGroupByのテスト") {
      val actual = target.listToMapAsGroupBy(srcDuplicated)
      it("listToMapAsGroupByで返されたMapの要素数の確認") {
        assert(actual.size == 5)
      }
      it("listToMapAsGroupByで返されたMapの要素の確認") {
        assert(actual.apply("a") == List(StringKeyEntity("a", 1), StringKeyEntity("a", 11)))
        assert(actual.apply("b") == List(StringKeyEntity("b", 2), StringKeyEntity("b", 12)))
        assert(actual.apply("c") == List(StringKeyEntity("c", 3), StringKeyEntity("c", 13)))
        assert(actual.apply("d") == List(StringKeyEntity("d", 4)))
        assert(actual.apply("e") == List(StringKeyEntity("e", 5)))
      }
    }
  }
}