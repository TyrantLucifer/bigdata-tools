package com.tyrantlucifer.producer

import com.tyrantlucifer.factory.MessageGeneratorFactory
import com.tyrantlucifer.utils.{GetProperties, KafkaProducerUtil}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

class ProduceKafkaMessage extends Thread {
  override def run(): Unit = {
    val topic: String                           = GetProperties.producerProperties.getProperty("topic")
    val producer: KafkaProducer[String, String] = KafkaProducerUtil.createKafkaProducer
    while (true) {
      val message: String = MessageGeneratorFactory.getGenerator.generateMessage
      producer.send(new ProducerRecord[String, String](topic, message))
      println(s"topic:$topic msg = $message")
      Thread.sleep(GetProperties.producerProperties.getProperty("delay").toInt)
    }
  }
}
