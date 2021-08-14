package com.tyrantlucifer.factory

import com.tyrantlucifer.messages.{AbstractMessage, PersonMessage}

object MessageGeneratorFactory {
  def getGenerator: AbstractMessage = new PersonMessage
}
