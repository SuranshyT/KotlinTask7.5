import kotlin.math.*

class Triangle(a1: Dot, b1: Dot, c1: Dot) {
    private var status = false // статус для определения получится создать треугольник или нет
    var A = a1 // Сеттеры с условиями что новая новая координата изменится только если треугольник возможен
        set(value) {
            if (value.similarX(B) && B.similarX(C) || value.similarY(B) && B.similarY(C)) { // проверяю если новая точка не будет на одной линии с остльными двумя
                println("Error: triangle would be impossible. So triangle stays the same")
            }else{
                field = value
            }
        }
    var B = b1
        set(value) {
            if (value.similarX(A) && A.similarX(C) || value.similarY(A) && A.similarY(C)) {
                println("Error: triangle would be impossible. So triangle stays the same")
            }else{
                field = value
            }
        }
    var C = c1
        set(value) {
            if (value.similarX(B) && B.similarX(A) || value.similarY(B) && B.similarY(A)) {
                println("Error: triangle would be impossible. So triangle stays the same")
            }else{
                field = value
            }
        }

    init {
        if (A.similarX(B) && B.similarX(C) || A.similarY(B) && B.similarY(C)) {
            println("Triangle is impossible. All points lay on one line")
        }else{
            status = true
        }
    }

    fun print() {
        if (status) {
            println("Triangle with point A(${A.x},${A.y}), point B(${B.x},${B.y}) and point C(${C.x},${C.y})")
        }
    }

    fun perimeter() {
        if (status) {
            val res = sqrt((B.x-A.x).pow(2) + (B.y-A.y).pow(2)) + sqrt((C.x-B.x).pow(2) + (C.y-B.y).pow(2)) + sqrt((C.x-A.x).pow(2) + (C.y-A.y).pow(2))
            println ("Perimeter is $res")
        }
    }

    fun area() {
        if (status) {
            val res = 0.5 * (A.x * (B.y-C.y) + B.x * (C.y-A.y) + C.x * (A.y-B.y))
            println ("Area is $res")
        }
    }

    fun rotate(angle: Int) {
        val centroidX = (A.x+B.x+C.x).toInt()/3
        val centroidY = (A.y+B.y+C.y).toInt()/3
        val angleRadians = angle*PI/180
        val x1=A.x
        val y1=A.y
        val x2=B.x
        val y2=B.y
        val x3=C.x
        val y3=C.y
        A.x = cos(angleRadians).toInt()*(x1-centroidX) - sin(angleRadians).toInt()*(y1-centroidY) + centroidX
        A.y = sin(angleRadians).toInt()*(x1-centroidX) + cos(angleRadians).toInt()*(y1-centroidY) + centroidY
        B.x = cos(angleRadians).toInt()*(x2-centroidX) - sin(angleRadians).toInt()*(y2-centroidY) + centroidX
        B.y = sin(angleRadians).toInt()*(x2-centroidX) + cos(angleRadians).toInt()*(y2-centroidY) + centroidY
        C.x = cos(angleRadians).toInt()*(x3-centroidX) - sin(angleRadians).toInt()*(y3-centroidY) + centroidX
        C.y = sin(angleRadians).toInt()*(x3-centroidX) + cos(angleRadians).toInt()*(y3-centroidY) + centroidY
        println("Triangle was rotated $angle degrees around Centroid")
    }
}