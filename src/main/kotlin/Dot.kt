class Dot(var x: Double = 0.0, var y: Double = 0.0) {
    fun similarX(A: Dot): Boolean {
        return x == A.x
    }

    fun similarY(A: Dot): Boolean {
        return y == A.y
    }
}