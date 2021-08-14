package com.tyrantlucifer.utils

import java.io.InputStream
import java.util.Properties

object GetProperties {
  private val producerStream: InputStream = this.getClass.getClassLoader.getResourceAsStream("producer.properties")
  val producerProperties: Properties      = new Properties()
  producerProperties.load(producerStream)
}
