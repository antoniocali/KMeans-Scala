package Models

/**
  * Created by anton on 25/03/2016.
  */
class Cluster(idx:Int, com:Point) {

  val id = idx;
  var centerOfMass = com;

  var points = List[Point]()

  def this(id:Int) = this(id,new Point())

  def setPoints(points:List[Point]) = {
    this.points=points
    var x,y:Float = 0
    for(point <- points) {
      x+=point.x
      y+=point.y
    }
    this.centerOfMass = new Point(x/points.size,y/points.size)
  }

  override def toString = {
    "Cluster " + id + " - CenterOfMass ("+centerOfMass.x+","+centerOfMass.y+")"
  }

}
