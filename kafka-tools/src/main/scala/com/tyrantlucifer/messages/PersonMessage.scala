package com.tyrantlucifer.messages

import com.tyrantlucifer.beans.Person
import com.tyrantlucifer.utils.{ConvertObjectToJson, RandomNumUtil}

class PersonMessage extends AbstractMessage {
  override def generateMessage: String = {
    val person: Person = Person(
      RandomNumUtil.randomString(5),
      RandomNumUtil.randomInt(1, 100),
      RandomNumUtil.randomInt(0, 1)
    )
    ConvertObjectToJson.convert(person)
  }
}
