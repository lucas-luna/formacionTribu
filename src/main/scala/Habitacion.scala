

object Habitacion extends App {

  val csv = scala.io.Source.fromFile("resources/RealEstate.csv").getLines()
  //print(csv)
  for (line <- csv) {
    val columnas = line.split(",")(3)
    if (columnas.matches("[0-9]")) {
      val cuarto = columnas
      val opcion = cuarto match {
        case "1" => "(1) Chico"
        case "2" => "(2) Mediano"
        case "3" => "(3) Grande"
        case "4" | "5" => "(4|5) Familiar"
        case _ => ""
      }
      println(opcion)
    }
  }
}
