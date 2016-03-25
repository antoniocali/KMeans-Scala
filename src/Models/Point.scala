package Models

import scala.util.Random

/**
  * Created by anton on 25/03/2016.
  */
class Point(idc:Int, xc:Float, yc:Float) {

  def id = idc;
  def x = xc
  def y = yc

  var cluster : Cluster = null;

  def this() = this(-1,Random.nextFloat()*10,Random.nextFloat()*10)
  def this(id:Int) = this(id,Random.nextFloat()*10,Random.nextFloat()*10)
  def this(x:Float,y:Float) = this(-1,x,y)

  def distance(p:Point) = {
    Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y,2))
  }

  override def toString = {
    var result = "Punto " + id + " - (" + x + "," + y + ")"
    if (cluster==null) result else result + " - " + cluster
  }

}
