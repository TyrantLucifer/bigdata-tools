package com.tyrantlucifer.utils

import org.apache.kafka.clients.producer.KafkaProducer

import java.io.InputStream
import java.util.Properties

object KafkaProducerUtil {
  def createKafkaProducer: KafkaProducer[String, String] = {
    // 读取kafka配置文件
    val stream: InputStream    = this.getClass.getClassLoader.getResourceAsStream("kafka.properties")
    val properties: Properties = new Properties()
    properties.load(stream)

    // 新建kafka生产者
    new KafkaProducer[String, String](properties)
  }

}
