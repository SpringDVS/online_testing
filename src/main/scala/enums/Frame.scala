package enums

object Frame extends Enumeration {
  type Frame = Value
  val FrameNetwork,FrameResponse,FrameNodeInfo,FrameNodeStatus,FrameResponseStatus,None = Value
}