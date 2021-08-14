package com.tyrantlucifer.producer

import com.tyrantlucifer.utils.GetProperties

import scala.collection.mutable.ListBuffer

object StartProduce {
  def main(args: Array[String]): Unit = {
    val threadList: ListBuffer[ProduceKafkaMessage] = ListBuffer()
    val count: Int                                  = GetProperties.producerProperties.getProperty("thread.count").toInt
    for (i <- 1 to count) {
      val thread: ProduceKafkaMessage = new ProduceKafkaMessage
      thread.setDaemon(true)
      thread.setName(s"thread-$i")
      thread.start()
      threadList += thread
    }
    for (thread <- threadList)
      thread.join()
  }
}
