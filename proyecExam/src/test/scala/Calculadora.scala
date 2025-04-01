import org.scalatest.funsuite.AnyFunSuite

class Calculadora extends AnyFunSuite {

  test("First test") {
    Main.configura()
  }

  test("Valida Cadena vacía"){
    val resultado = Main.Add("")
    assert(resultado == 0)
  }

  test("Valida Cadena valor 1"){
    val resultado = Main.Add("1")
    assert(resultado == 1)
  }

  test("Valida Cadena valor 3"){
    val resultado = Main.Add("1,2")
    assert(resultado == 3)

  }

  test("Valida Cadena 1,3,5,7 igual a 16"){
    val resultado = Main.Add("1,3,5,7")
    assert(resultado == 16)
  }

  test("Valida separadores") {
    val resultado = Main.Add("1,2\n3")
    assert(resultado == 6)
  }
  test("Valida sin separadores al final") {

    assertThrows[Exception] {
      val resultado = Main.Add("1,2,")
    }
  }
  test("Valida sin salto de linea al final") {
    assertThrows[Exception] {
      val resultado = Main.Add("1,2\n")
    }
  }


  test("Diferentes  delimitadores") {
    val resultado = Main.Add("//sep\n2sep5")
    assert(resultado == 7)
  }





}
