package motivation

import org.combinators.cls.interpreter._
import org.combinators.cls.types._
import org.combinators.cls.types.syntax._


class MotivationRepository {
  val performer: Variable = Variable("performer")
  val defaultPerformerSpace =
    Kinding(performer).addOption('Springsteen)

  @combinator object motivationSong {
    def apply(): LilyPond[Music] =
      LilyPond.loadMusic("noretreat.ly")
    val semanticType: Type = 'Springsteen
  }

  @combinator object addLyrics {
    def apply(music: LilyPond[Music],
              lyrics: String): LilyPond[Song] =
      music.setLyrics(lyrics)
    val semanticType: Type = performer =>: performer =>: performer
  }

  class LyricsCombinator(lyrics: String, performerName: String) {
    def apply(): String = lyrics
    val semanticType: Type = Constructor(performerName)
  }

  def reflectedRepository: ReflectedRepository[MotivationRepository] = {
    val crawler = CrawlerDemo
    val (performerSpace, lyricsCombinators) =
      crawler
        .findLyrics("surrender")
        .foldLeft((defaultPerformerSpace, Seq.empty[LyricsCombinator])) {
          case ((s, cs), (lyrics, performerName)) =>
            (s.addOption(Constructor(performerName)),
              cs :+ new LyricsCombinator(lyrics, performerName))
        }
    lyricsCombinators.foldLeft(
      ReflectedRepository[MotivationRepository](
        substitutionSpace = performerSpace,
        inst = this,
        classLoader = this.getClass.getClassLoader)) {
      case (repo, combinator) => repo.addCombinator(combinator)
    }
  }

  def results: InhabitationResult[LilyPond[Song]] =
    reflectedRepository.inhabit[LilyPond[Song]]('Springsteen)
}


