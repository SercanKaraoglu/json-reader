# Json Reader

This project written in Scala and improves the usage experience of vertx json library like below

``` scala

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


```

instead of writing things like;

``` scala

val conf=new JsonObject(Source.fromFile("git/json-reader/conf/conf.json").mkString).getJsonObject("config")

val connectionBuilder = new ConnectionBuilder {
  setName(conf.getJsonObject("connection").getString("name"))
  setAddress(conf.getJsonObject("connection").getString("address"))
  setPort(conf.getJsonObject("connection").getString("port"))
  setBufferSize(conf.getJsonObject("connection").getString("bufferSize"))
  setUserName(conf.getJsonObject("connection").getString("username"))
  setPassword(conf.getJsonObject("connection").getString("password"))
  setEnableReconnect(conf.getJsonObject("connection").getString("enableReconnect"))
  setReconnectTime(conf.getJsonObject("connection").getString("reconnect-time"))
  
}

```