import app.connection.ConnectionBuilder
import io.vertx.core.json.{JsonArray, JsonObject}

import scala.language.implicitConversions
import scala.io.Source
import app.util.JsonWrapper._

val conf=new JsonObject(Source.fromFile("git/json-reader/conf/conf.json").mkString) \\ "config"

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

connectionBuilder.toString