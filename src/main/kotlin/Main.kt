fun main() {
    val triangle = Triangle(Dot(-1.0,0.0), Dot(3.0,0.0), Dot(1.0,3.0))
    triangle.C = Dot(1.0, 0.0)
    triangle.print()
    triangle.perimeter()
    triangle.area()
    triangle.rotate(-90)
    triangle.print()
}