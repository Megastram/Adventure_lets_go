package gameElements

import helper.assignDefaultHitShape
import korlibs.image.color.Colors
import korlibs.korge.view.*


/**
 *
 * Liste aller Laser auf dem Spielfeld
 *
 * Brauchen wir um zu prüfen, ob die Laser etwas treffen.
 *
 */
val lasers = mutableListOf<View>()
val laserSpeed = 5


/**
 * Erzeuge einen Laser
 **/
fun Container.createLaser(ufo: Image) {

    val laser = solidRect(3.0, 20.0, Colors.RED) {
        anchor(0.5, 0.5)
        position(ufo.x, ufo.y)
        assignDefaultHitShape()
    }


    // was passiert mit dem laser während das spiel läuft?
    laser.addUpdater {
        // laser nach oben bewegen chek
        y = y - laserSpeed
        // laser am oberen rand entfernrn chek
        if (y < 50) {
            removeLaser(laser)
        }
    }

    lasers.add( laser )

}

fun removeLaser(laser: View) {
    laser.removeFromParent()
    lasers.remove( laser )
}
