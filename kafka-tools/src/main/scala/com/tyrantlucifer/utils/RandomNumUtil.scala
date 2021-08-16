package com.tyrantlucifer.utils

import java.util.Random
import scala.collection.mutable

object RandomNumUtil {
  val random = new Random()
  val map = Map(
    1  -> 'a',
    2  -> 'b',
    3  -> 'c',
    4  -> 'd',
    5  -> 'e',
    6  -> 'f',
    7  -> 'g',
    8  -> 'h',
    9  -> 'i',
    10 -> 'j',
    11 -> 'k',
    12 -> 'l',
    13 -> 'm',
    14 -> 'n',
    15 -> 'o',
    16 -> 'p',
    17 -> 'q',
    18 -> 'r',
    19 -> 's',
    20 -> 't',
    21 -> 'u',
    22 -> 'v',
    23 -> 'w',
    24 -> 'x',
    25 -> 'y',
    26 -> 'z'
  )

  /**
    * 返回一个随机的整数 [from, to]
    *
      * @param from
    * @param to
    * @return
    */
  def randomInt(from: Int, to: Int): Int = {
    if (from > to) throw new IllegalArgumentException(s"from = $from 应该小于 to = $to")
    random.nextInt(to - from + 1) + from
  }

  /**
    * 随机的Long  [from, to]
    *
      * @param from
    * @param to
    * @return
    */
  def randomLong(from: Long, to: Long): Long = {
    if (from > to) throw new IllegalArgumentException(s"from = $from 应该小于 to = $to")
    random.nextLong().abs % (to - from + 1) + from
  }

  /**
    * 生成一系列的随机值
    *
      * @param from
    * @param to
    * @param count
    * @param canRepeat 是否允许随机数重复
    */
  def randomMultiInt(from: Int, to: Int, count: Int, canRepeat: Boolean = true): List[Int] =
    if (canRepeat)
      (1 to count).map(_ => randomInt(from, to)).toList
    else {
      val set: mutable.Set[Int] = mutable.Set[Int]()
      while (set.size < count)
        set += randomInt(from, to)
      set.toList
    }

  /**
    * 按照指定长度生成随机字符串
    * @param length 生成随机字符串长度
    * @return
    */
  def randomString(length: Int): String = {
    val list: List[Char] = (1 to length).map { _ =>
      val i: Int = randomInt(1, 26)
      map.getOrElse(i, 'x')
    }.toList
    list.mkString("")
  }

  /**
    * 根据给定的元素列表，从列表随机挑选出元素
    * @param itemList 元素列表
    * @tparam T
    * @return
    */
  def randomItemFromList[T](itemList: List[T]): T = {
    val i: Int = randomInt(0, itemList.length - 1)
    itemList(i)
  }
}
