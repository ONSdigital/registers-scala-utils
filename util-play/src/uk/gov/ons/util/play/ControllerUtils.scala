package uk.gov.ons.util.play

import play.api.libs.json.{ JsObject, Json }
import play.api.mvc.Result

import scala.concurrent.Future

/**
  * Created by coolit on 16/11/2017.
  */
trait ControllerUtils {

  /**
    * Pass parameters to form a JSON response for a request
    */
  def errAsJson(status: Int, code: String, msg: String): JsObject = {
    Json.obj(
      "status" -> status,
      "code" -> code,
      "message_en" -> msg
    )
  }

  def tryAsResponse(parseToJson: Try[JsValue]): Result = parseToJson match {
    case Success(s) => Ok(s)
    case Failure(ex) =>
      logger.error("Failed to parse instance to expected json format", ex)
      BadRequest(errAsJson(BAD_REQUEST, "bad_request", s"Could not perform action with exception $ex"))
  }
}

