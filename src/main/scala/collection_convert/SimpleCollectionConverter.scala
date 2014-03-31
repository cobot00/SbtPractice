package collection_convert

class SimpleCollectionConverter extends CollectionConverter {

  /*
   * EntityのListをMapに変換して返す。
   *
   * e.g.
   * [(a, 1), (b, 2), (c, 3), (d, 1), (e,5)]
   * -> {(a, 1), (b, 2), (c,3), (d, 1), (e,5)}
   *
   * (): Entity, []: List, {}: Map
   */
  def listToMap(src: List[StringKeyEntity]): Map[String, StringKeyEntity] = {
    src.map(e => e.key -> e).toMap
  }

  /*
   * EntityのListをEntityのkey値毎にグルーピングしたListに分割し、Mapに詰めて返す。
   *
   * e.g.
   * [(a, 1), (b, 1), (c,3), (a, 3), (c, 1), (c,2), (a,2)]
   * -> {[(a, 1), (a, 3), (a, 2)], [(b, 1)], [(c,3), (c, 1), (c,2)]}
   *
   * (): Entity, []: List, {}: Map
   */
  def listToMapAsGroupBy(src: List[StringKeyEntity]): Map[String, List[StringKeyEntity]] = {
    src.groupBy(_.key)
  }
}