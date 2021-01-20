object Main {

  def main(args: Array[String]): Unit = {
    val m: Matrix[Int] = new Matrix[Int](3, 3, List(1, 1, 1, 0, 1, 0, 0, 0, 1).toArray)
    println(m)
  }

}