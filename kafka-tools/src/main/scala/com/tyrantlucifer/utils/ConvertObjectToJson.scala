package com.tyrantlucifer.utils

import org.json4s.DefaultFormats
import org.json4s.native.Serialization

object ConvertObjectToJson {
  def convert[T](obj: T): String = {
    implicit val formats = DefaultFormats
    Serialization.write(obj)
  }
}
