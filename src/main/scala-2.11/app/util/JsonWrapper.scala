package app.util

/**
  * Created by sercan on 14.09.2016.
  */
import io.vertx.core.json.{JsonArray, JsonObject}
trait GetterWrapper[+T] {
  def get(conf: JsonObject, next: String): T
}
object StringGetter extends GetterWrapper[String]{
  def get(conf: JsonObject, next: String) = conf.getString(next)
}

object IntGetter extends GetterWrapper[Int]{
  def get(conf: JsonObject, next: String) = conf.getInteger(next)
}

object BooleanGetter extends GetterWrapper[Boolean]{
  def get(conf: JsonObject, next: String) = conf.getBoolean(next)
}

object ArrayGetter extends GetterWrapper[JsonArray]{
  def get(conf: JsonObject, next: String) = conf.getJsonArray(next)
}

class JsonWrapper(val conf: JsonObject) {

  def \\(next: String) = new JsonWrapper(conf.getJsonObject(next))

  def \[T](next: String)(implicit ex: GetterWrapper[T]): T = ex.get(conf,next)

}

object JsonWrapper {

  implicit val sG: GetterWrapper[String] = StringGetter
  implicit val iG: GetterWrapper[Int] = IntGetter
  implicit val bG: GetterWrapper[Boolean] = BooleanGetter
  implicit val aG: GetterWrapper[JsonArray] = ArrayGetter

  implicit def wrap(conf: JsonObject) = new JsonWrapper(conf)
}
