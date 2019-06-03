package motivation

import javax.inject.Inject

import org.combinators.cls.git.{InhabitationController, Results, RoutingEntries}
import org.combinators.cls.interpreter.CombinatorInfo
import org.combinators.cls.git.EmptyResults
import org.combinators.cls.types.syntax._
import org.webjars.play.WebJarsUtil
import play.api.inject.ApplicationLifecycle
import LilyPond.instances._

class MotivationController @Inject()(webJars: WebJarsUtil, lifeCycle: ApplicationLifecycle)
  extends InhabitationController(webJars, lifeCycle)
    with RoutingEntries {
  lazy val repository = new MotivationRepository
  lazy val Gamma = repository.reflectedRepository
  override lazy val combinatorComponents: Map[String, CombinatorInfo] = Gamma.combinatorComponents
  override lazy val results: Results = EmptyResults().add(repository.results)
  override lazy val controllerAddress: String = "motivation"
}