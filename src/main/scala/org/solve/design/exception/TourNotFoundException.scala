package org.solve.design.exception

/** Custom Exception representing incomplete Pawn's tour */
final case class TourNotFoundException(message: String)
  extends Exception(message)