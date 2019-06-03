package motivation

import java.nio.file.{Path, Paths}

import org.combinators.cls.types.{Constructor, Type}
import org.combinators.templating.persistable.Persistable

import scala.io.Source

sealed trait MusicType
case class Music() extends MusicType
case class Song() extends MusicType


trait LilyPond[T <: MusicType] { self =>
  val path: String
  val contents: String
  def setLyrics(lyrics: String): LilyPond[Song] = new LilyPond[Song] {
    val path = self.path
    val contents =
      self.contents.replaceFirst("\\\\addlyrics \\{[^\\}]*\\}", s"\\\\addlyrics { $lyrics }")
  }
}

object LilyPond {
  def loadMusic(relPath: String): LilyPond[Music] = new LilyPond[Music] {
    val path = relPath
    val contents = Source.fromURL(classOf[LilyPond[_]].getResource(relPath), "UTF-8").mkString
  }
  object instances {
    implicit def lilyPondPersistable[MT <: MusicType] : Persistable.Aux[LilyPond[MT]] = new Persistable {
      def path(elem: LilyPond[MT]): Path = Paths.get(elem.path)
      def rawText(elem: LilyPond[MT]): Array[Byte] = elem.contents.getBytes
      type T = LilyPond[MT]
    }
  }
}


