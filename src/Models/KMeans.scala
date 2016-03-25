package Models

/**
  * Created by anton on 25/03/2016.
  */
object KMeans {
  def main(args: Array[String]) = {
    val numberPoints = 100
    val numberCluster = 3

    var points = List[Point]()
    for (i <- 0 to numberPoints) {
      points = points :+ new Point(i)
    }
    points.foreach(println)
    var clusters = List[Cluster]()

    for (i <- 0 to numberCluster) {
      clusters = clusters :+ new Cluster(i)
    }
    clusters.foreach(println)

    var step = 0;
    var MSE = Double.PositiveInfinity
    var finished = false;
    while (!finished) {
      println("STEP " + step)
      for (point <- points) {
        var minDistance = Double.PositiveInfinity
        for (cluster <- clusters) {
          if (point.distance(cluster.centerOfMass) < minDistance) {
            minDistance = point.distance(cluster.centerOfMass)
            point.cluster = cluster
          }
        }
      }

      points.foreach(println)

      for (cluster <- clusters) {
        cluster.setPoints(points.filter(x => x.cluster == cluster))
      }
      clusters.foreach(println)

      var newMSE = 0.0;
      points.foreach(x => newMSE += x.distance(x.cluster.centerOfMass))
      if (newMSE < MSE) {
        step += 1
        MSE = newMSE;
      } else finished = true


    }
  }
}