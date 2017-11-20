package uk.gov.ons.util.general

// old: main.scala.uk.gov.ons

import java.io.File
import java.util.Optional

/**
  * Created by coolit on 16/11/2017.
  */
trait GeneralUtils {

  def toOption[X](o: Optional[X]) = if (o.isPresent) Some(o.get) else None

  def toJavaOptional[A](o: Option[A]): Optional[A] =
    o match { case Some(a) => Optional.ofNullable(a); case _ => Optional.empty[A] }

  def currentDirectory = new File(".").getCanonicalPath

  def unquote(s: String) = s.replace("\"", "")

  def getElement(value: AnyRef) = {
    val res = value match {
      case None => ""
      case Some(i: Int) => i
      case Some(l: Long) => l
      case Some(z) => s"""${z.toString}"""
    }
    res
  }
}
