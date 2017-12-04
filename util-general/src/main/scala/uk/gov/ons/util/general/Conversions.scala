package uk.gov.ons.util.general

// old: main.scala.uk.gov.ons

import java.util.Optional

/**
  * Created by coolit on 20/11/2017.
  */
object Conversions {

  def toOption[X](o: Optional[X]) = if (o.isPresent) Some(o.get) else None

  def toJavaOptional[A](o: Option[A]): Optional[A] =
    o match { case Some(a) => Optional.ofNullable(a); case _ => Optional.empty[A] }
}