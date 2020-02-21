import java.text.Normalizer

object Cancion extends App {

  def readFile(fileName: String): Iterator[String]= io.Source.fromFile(fileName).getLines

  val ds: Array[Array[String]] = readFile("resources/tusa.txt")
    .map(_.split(" ")).toArray

  val  resultado =ds.flatMap(
    row=>row.map(
      cell=>{
        Normalizer.normalize(cell, Normalizer.Form.NFD)
          .replaceAll("[^A-Za-z0-9]", "")//.toLowerCase()
      }
    )
  ).groupBy(palabras => {
    palabras
  })

  resultado.foreach(x=> println( x._1 +" tiene "+ x._2.length))

  val maximo = resultado.maxBy(maximo=> maximo._2.length)
  if(maximo._2.length > 4)
  {
    println(maximo._1 +" es el mayor con "+ maximo._2.length +" repeticiones")
  }

}

