package uk.gov.ons.util.play

import scala.concurrent.Future
import scala.util.Try

import play.api.mvc.Result

/**
  * Created by coolit on 20/11/2017.
  */
object FutureResponse {

  implicit class futureSuccess(val res: Result) {
    def future: Future[Result] = Future.successful(res)
  }

  implicit class futureFail(val ex: Exception) {
    def futureErr: Future[Exception] = Future.failed(ex)
  }

  implicit class futureFromTry[T](val f: Try[T]) {
    def futureTryRes: Future[T] = Future.fromTry(f)
  }
}