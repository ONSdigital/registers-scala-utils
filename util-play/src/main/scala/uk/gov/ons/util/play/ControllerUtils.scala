package uk.gov.ons.util.play

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.{JsObject, JsValue, Json}
import play.api.mvc.{Controller, Result, Results}

import scala.util.{Failure, Success, Try}

/**
  * Created by coolit on 16/11/2017.
  */
trait ControllerUtils extends Controller with LazyLogging {

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
    case Success(s) => Results.Ok(s)
    case Failure(ex) =>
      logger.error("Failed to parse instance to expected json format", ex)
      Results.BadRequest(errAsJson(BAD_REQUEST, "bad_request", s"Could not perform action with exception $ex"))
  }
}

