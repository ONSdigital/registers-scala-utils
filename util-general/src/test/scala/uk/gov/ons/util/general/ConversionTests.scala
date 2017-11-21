package uk.gov.ons.util.general

import java.util.Optional

import uk.gov.ons.util.general.Conversions._
import org.scalatest.FlatSpec

/**
  * Created by coolit on 20/11/2017.
  */
class ConversionTests extends FlatSpec {

  it should "convert a Scala Option to a Java Optional" in {
    val msg: Option[String] = Some("Hello, world!")
    val optional = toJavaOptional(msg)
    assert(optional match { case _: Optional[String] => true; case _ => false })
  }

  it should "convert a Java Optional to a Scala Option" in {
    val msg: String = "Hello, world!"
    val msgOptional: Optional[String] = Optional.of(msg)
    val option = toOption(msgOptional)
    assert(option match { case _: Option[String] => true; case _ => false })
  }
}
