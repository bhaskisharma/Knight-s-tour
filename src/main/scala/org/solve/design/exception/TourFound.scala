package org.solve.design.exception

import org.solve.service.Tours.Path

/** Custom Exception for breaking from recursion when a tour path is found */
final case class TourFound(tour: Path) extends Exception