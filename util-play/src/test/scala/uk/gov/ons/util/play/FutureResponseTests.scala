package uk.gov.ons.util.play

import org.scalatest.FlatSpec
import uk.gov.ons.util.play.FutureResponse._
import play.api.mvc.{Result, Results}

import scala.concurrent.Future
import scala.util.Try

/**
  * Created by coolit on 20/11/2017.
  */
class FutureResponseTests extends FlatSpec {

  it should "use an implicit to convert a Result -> Future[Result]" in {
    val resp: Result = Results.Ok
    assert(resp.future match { case _: Future[Result] => true; case _ => false })
  }

  it should "use an implicit to convert an Exception -> Future[Exception]" in {
    val ex: ArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException()
    assert(ex.futureErr match { case _: Future[Exception] => true; case _ => false })
  }

  it should "use an implicit to convert a Try -> Future[Try]" in {
    val t: Try[String] = Try("trying...")
    assert(t.futureTryRes match { case _: Future[Try[String]] => true; case _ => false })
  }
}
