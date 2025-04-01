object Main {

  def configura(): Unit = {
    println("Configurando")

  }

  def Add(valor: String): Int = {


    if (valor.endsWith(",")) {
      throw new Exception("Ya fue")
    }
    if (valor.endsWith("\n")) {
      throw new Exception("Ya fue")
    }

    if (valor == "") {
      0
    }
    else {

      if (valor.startsWith("//")) {


        // Extraer el delimitador entre "//" y "\n"
        val delimiterPattern = "//(.*)\n".r
        val delimiter = delimiterPattern.findFirstMatchIn(valor).map(_.group(1)).getOrElse("")

        // Dividir la cadena en dos partes separadas por "\n"
        val parts = valor.split("\n", 2) // Dividimos en dos partes

        // Obtener la parte después del delimitador
        val dataPart = if (parts.length > 1) parts(1) else ""


        val splitVal = valor.split(s"[$delimiter]").map(_.toInt)


        splitVal.reduce((a, b) => {
          a + b
        })

      }



      else
      {
        val splitVal = valor.split("[,\n]").map(a => a.toInt)
        splitVal.reduce((a, b) => {
          a + b
        })
      }

    }

  }
}