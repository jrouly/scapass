package net.rouly.scapass.app

import scopt.OParser

trait CLI {

  /**
    * Parse input arguments as a [[Config]] and run some processing operation.
    *
    * @param args command line arguments
    * @param op operation to run on the configuration
    * @return result of running the operation on the parsed arguments
    */
  def parseArgs[T](args: Seq[String])(op: Config => T): Option[T] = {
    OParser.parse(parser, args, Config()).map(op)
  }

  private def parser: OParser[Unit, Config] = {
    val builder = OParser.builder[Config]
    import builder._

    OParser.sequence(
      programName("scapass"),
      head("scapass", "0.x"),
      opt[Option[String]]('f', "foo")
        .action((x, c) => c.copy(foo = x))
        .text("foo is a string property"),
    )
  }

}
