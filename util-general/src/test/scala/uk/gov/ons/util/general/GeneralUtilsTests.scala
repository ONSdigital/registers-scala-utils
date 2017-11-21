package uk.gov.ons.util.general

import uk.gov.ons.util.general.GeneralUtils._

import org.scalatest.FlatSpec

/**
  * Created by coolit on 20/11/2017.
  */
class GeneralUtilsTests extends FlatSpec {

  it should "get the current directory" in {
    val currDir = currentDirectory
    assert(currDir.contains("/registers-scala-utils"))
  }

  it should "unquote a string with double quotes" in {
    val msg: String = "\"Hello, world!\""
    val unquoted: String = unquote(msg)
    assert(!unquoted.contains('"'))
  }
}
