import args._

class ForgeTest(collection: args.Collection) {
  
  override def toString() : String = 
     "--unit-test" + 
     " " + collection.msgType.toArgument() +
     " " + collection.msgTarget.toArgument() +
     " " + collection.nodeType.toArgument() +
     " " + collection.nodeState.toArgument() +
     " " + collection.nodeService.toArgument() +
     " " + collection.nodeRegister.toArgument() +
     " " + collection.textContent.toArgument()
}