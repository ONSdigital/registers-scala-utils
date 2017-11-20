package uk.gov.ons.util.general

// old: main.scala.uk.gov.ons

import java.util.Optional

/**
  * Created by coolit on 16/11/2017.
  */
trait GeneralUtils {
  /**
    * Convert a Java Optional to a Scala Option
    */
  protected def toOption[X](o: Optional[X]) = if (o.isPresent) Some(o.get) else None
}
