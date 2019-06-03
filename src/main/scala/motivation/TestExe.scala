package motivation

import org.combinators.cls.types.Omega
import org.combinators.cls.types.syntax._

object TestExe extends App {
  println(new MotivationRepository().results.interpretedTerms.index(0).contents)
}
