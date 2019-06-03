package motivation

trait Crawler {
  def findLyrics(searchTerm: String): Seq[(String, String)]
}

object CrawlerDemo extends Crawler {
  def findLyrics(searchTerm: String): Seq[(String, String)] =
    Seq(
      ("No re -- treat ba by no su -- rre -- nder", "Springsteen"),
      ("I surrender. Every night’s getting longer", "Dion")
    )
}