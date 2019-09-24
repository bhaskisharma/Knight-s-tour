import com.typesafe.scalalogging.LazyLogging
import org.solve.design.Point
import org.solve.design.exception.{InvalidPointException, TourNotFoundException}
import org.solve.service.{Tours, WarnsdorffAlgo}
import org.solve.service.Tours.{X, Y}

object Driver extends App with LazyLogging {

  import org.solve.service.Tours._

  // board dimensions as N  * N
  val N = 10
  private val boardDimension: (X, Y) = (10, 10)

  // starting position of pawn in the board
  private val startPoint = Point(9, 9)

  // all legal moves
  private val legalMoves: Set[(X, Y)] =
    Set(
      (0, -3), // West
      (0, 3), // East
      (3, 0), // South
      (-3, 0), // North
      (2, -2), // SouthWest
      (2, 2), // SouthEast
      (-2, -2), // NorthWest
      (-2, 2) // NorthEast
    )
  private val service: Tours = new WarnsdorffAlgo()

  service.findPath(startPoint, boardDimension, legalMoves).map { path =>
    logger.info(s"Found Tour's path : \n $path")
    val array = pathAsArray(path, boardDimension)
    printAsGrid(array)
  } recover {
    case ex@(_: InvalidPointException | _: TourNotFoundException) =>
      logger.error(ex.getMessage)
  }

  private def printAsGrid(array: Array[Array[Int]]): Unit = {
    logger.info(" Tour's path as grid :")
    val maxRow = array.length
    val maxCol = array(0).length
    for (row <- 0 until maxRow) {
      for (col <- 0 until maxCol) {
        print(s"${array(row)(col)} \t")
      }
      println()
    }
  }

}
