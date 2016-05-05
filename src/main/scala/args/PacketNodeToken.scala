package args

class PacketNodeToken(nodeToken: String) extends ForgeArgument {
  def this() = this("")
  override def toArgument() : String = nodeToken match {
    case "" => ""
    case _ => "--node-token "+this.nodeToken
  }
}