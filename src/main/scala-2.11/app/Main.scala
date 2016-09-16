package app

/**
  * Created by sercan on 16.09.2016.
  */
import app.connection.ConnectionBuilder
import io.vertx.core.json.{JsonArray, JsonObject}

import scala.language.implicitConversions
import scala.io.Source
import app.util.JsonWrapper._


object Main {
  def main(args: Array[String]): Unit = {
    val conf=new JsonObject(Source.fromFile("conf/conf.json").mkString) \\ "config"

    val connectionBuilder = new ConnectionBuilder {
      setName(conf \\ "connection" \ "name")
      setAddress(conf \\ "connection" \ "address")
      setPort(conf \\ "connection" \ "port")
      setBufferSize(conf \\ "connection" \ "bufferSize")
      setUserName(conf \\ "connection" \ "username")
      setPassword(conf \\ "connection" \ "password")
      setEnableReconnect(conf \\ "connection" \ "enableReconnect")
      setReconnectTime(conf \\ "connection" \ "reconnect-time")
    }

    println(connectionBuilder.toString)
  }
}
