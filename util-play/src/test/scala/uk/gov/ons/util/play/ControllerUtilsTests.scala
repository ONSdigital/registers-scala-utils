package uk.gov.ons.util.play

import org.scalatest.FlatSpec
import play.api.libs.json.{JsObject, JsValue, Json}

import scala.util.Try

/**
  * Created by coolit on 20/11/2017.
  */
class ControllerUtilsTests extends FlatSpec with ControllerUtils {

  it should "create an error JSON object from input parameters" in {
    val status = BAD_REQUEST
    val code = "bad_request"
    val msg = "Could not parse request"
    val err: JsObject = errAsJson(status, code, msg)
    assert((err \ "status").as[Int] == 400)
    assert((err \ "code").as[String] == code)
    assert((err \ "message_en").as[String] == msg)
  }

  it should "return a BAD_REQUEST if a JSON conversion fails" in {
    val json: Try[JsValue] = Try(Json.parse("""Invalid JSON"""))
    val resp = tryAsResponse(json)
    assert(resp.header.status == BAD_REQUEST)
  }

  it should "return an OK if a JSON conversion is successful" in {
    val json: Try[JsValue] = Try(Json.parse("""{ "name": "John" }"""))
    val resp = tryAsResponse(json)
    assert(resp.header.status == OK)
  }
}
