import korlibs.image.color.Colors
import korlibs.korge.view.*

fun Stage.createLaser(ufo: Image) {
    solidRect(3.0, 20.0, Colors.RED) {
        anchor(0.5, 0.5)
        position(ufo.x, ufo.y)


        // was passiert mit dem laser während das spiel läuft?
        addUpdater {
            // laser nach oben bewegen chek
            y = y - 1
            // laser am oberen rand entfernrn chek
            if (y < 50) {
                removeFromParent()
            }
        }

    }
}
