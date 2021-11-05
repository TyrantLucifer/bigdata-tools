package com.tyrantlucifer.consumer

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.{Collections, Properties}
import scala.jdk.CollectionConverters._

object Consumer {
  def main(args: Array[String]): Unit = {
    val properties = new Properties()
    properties.put("bootstrap.servers", "172.18.0.6:9092,172.18.0.7:9092,172.18.0.8:9092")
    properties.put("group.id", "test")
    properties.put("auto.offset.reset", "earliest")
    properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    properties.put("enable.auto.commit", "true")
    val consumer = new KafkaConsumer[String, String](properties)
    consumer.subscribe(Collections.singletonList("test-topic"))
    while (true) {
      val records = consumer.poll(2000)
      for (record <- records.asScala){
        println(record)
      }
    }
  }
}
