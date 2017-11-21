package uk.gov.ons.util.general

// old: main.scala.uk.gov.ons

import java.io.File

/**
  * Created by coolit on 16/11/2017.
  */
object GeneralUtils {

  def currentDirectory = new File(".").getCanonicalPath

  def unquote(s: String) = s.replace("\"", "")
}
