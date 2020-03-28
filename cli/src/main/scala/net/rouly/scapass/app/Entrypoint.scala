package net.rouly.scapass.app

object Entrypoint extends App with CLI {

  parseArgs(args.toIndexedSeq) {
    case Config(_) =>
      println("Hello, world.")
      ()
  }

}
