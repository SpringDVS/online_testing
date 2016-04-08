import scala.sys.process._

object ForgeCmd {
  def runCommand() = {
    val cmd = "forge"
    val output = cmd.!!
  }
}