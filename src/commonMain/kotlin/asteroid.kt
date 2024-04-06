import korlibs.image.color.Colors
import korlibs.korge.view.*
import korlibs.math.geom.shape.EmptyShape2D
import korlibs.math.geom.shape.toShape2D

fun Stage.createAsteroid(ufo: Image, container: Stage) {

    circle(
        fill = Colors.RED
    ) {
        hitShape2d = path?.toShape2D() ?: EmptyShape2D
        position(x = ufo.x, y = 0)
        addUpdater {
            // nach unten bewegen
            y = y + 1
            // laser am oberen rand entfernrn chek
            if (y > container.height) {
                removeFromParent()
            }
            // prüfen ob kollision mit ufo
            if (hitTestView(ufo) != null) {
                gameWindow.close(0)
            }
        }

    }

}
