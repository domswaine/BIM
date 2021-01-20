import scala.reflect.ClassTag

class Matrix[@specialized(Double, Int, Float, Long) T: ClassTag](val no_rows: Int, val no_cols: Int, val data: Array[T]){

  def indexFromRowCol(row: Int, col: Int): Int = (row - 1) * no_cols + (col - 1)

  def rowColFromIndex(index: Int): (Int, Int) = {
    val r = (index % no_cols) + 1
    val c = (index / no_cols) + 1
    (r, c)
  }

  def update(row: Int, col: Int, value: T): Unit = {
    val index = indexFromRowCol(row, col)
    data(index) = value
  }

  def get(row: Int, col: Int): T = {
    val index = indexFromRowCol(row, col)
    data(index)
  }

  def transpose(): Matrix[T] = {
    val array = new Array[T](no_rows * no_cols)
    val transpose = new Matrix[T](no_rows, no_cols, array)
    (1 to no_rows).foreach(r => {
      (1 to no_cols).foreach(c => {
        val value: T = get(r, c)
        transpose.update(c, r, value)
      })
    })
    transpose
  }

}