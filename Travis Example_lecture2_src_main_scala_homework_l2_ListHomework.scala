package homework.l2
import ListFunctions.fold


/**
  * Вам нужно реализовать функции sumOfSquares и multiplicationOfCubes
  * при помощи ListFunctions.fold, композиции и частичного применения функций, sum, multiply и pow
  * Можно добавлять промежуточные функции.
  * Также вам может понадобится функция Function.uncurry,
  * которая из карированной функции делает функцию с несколькими аргументами
  */
object ListHomework {


  val sum = (a: Int, b: Int) => a + b

  val multiply = (a: Int, b: Int) => a * b

  def pow(a: Int, p: Int): Int = if(p <= 0) 1 else a * pow(a, p - 1)

  val square = pow(_: Int, 2)

  val cube = pow(_: Int, 3)

  val curSum = sum.curried

  val curMult = multiply.curried

  val SquareAndSum = curSum compose square

  val CubeAndSum = curMult compose cube

  lazy val sumOfSquares: List[Int] => Int = list => fold(0, list)((s, i) => SquareAndSum(i)(s))

  lazy val multiplicationOfCubes: List[Int] => Int = list => fold(1, list)((s, i) => CubeAndSum(i)(s))

  println(sumOfSquares(List(1, 2, 3)))
  println(sumOfSquares(List.empty))

  println(multiplicationOfCubes(List(1, 2, 3)))
  println(multiplicationOfCubes(List.empty))


}