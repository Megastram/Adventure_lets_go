package gameElements

import globalGameWindow
import helper.assignDefaultHitShape
import korlibs.image.color.Colors
import korlibs.korge.view.*
import kotlin.random.Random

var numasteroits : Int = 0

fun Container.createAsteroid(ufo: Image) {

    val container: Container = this

    circle(
        fill = Colors.RED,
        radius = Random.nextDouble(10.0,30.0)
    ) {
        position(x = Random.nextDouble( container.width ), y = 0)
        anchor(0.5, 0.5)
        assignDefaultHitShape()
        addUpdater {

            // nach unten bewegen
            y = y + 1

            // laser am oberen rand entfernrn chek
            if (y > container.height) {
                removeFromParent()
            }

            // Prüfe, ob wir mit dem UFO kollidiert sind
            if ( hitTestView(ufo) != null ) {
                globalGameWindow.close(0)
            }

            // Finde kollidierenden Laser und speichere ihn als name "collidedLaser"
            val collidedLaser = lasers.firstOrNull { hitTestView(it) != null }
            // Wenn das ergebnis null ist, dann hat kein Laser kollidiert.
            // Aber wenn es NICHT null ist, dann ...
            if ( collidedLaser!=null ) {

                // lösche den asteroiden
                removeAsteroid( this )

                // lösche den laser
                removeLaser( collidedLaser )

                numasteroits += 1

            }

        }

    }

}

fun removeAsteroid(asteroid: View) {
    asteroid.removeFromParent()
}
