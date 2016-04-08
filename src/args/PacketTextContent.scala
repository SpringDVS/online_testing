package args

class PacketTextContent(textContent: String) extends ForgeArgument {
  def this() = this("")
  override def toArgument() : String = textContent match {
    case "" => ""
    case _ => "--text-content "+this.textContent
  }
}