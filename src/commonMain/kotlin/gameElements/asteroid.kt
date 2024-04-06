package gameElements

import helper.assignDefaultHitShape
import korlibs.image.color.Colors
import korlibs.korge.view.*

fun Stage.createAsteroid(ufo: Image, container: Stage) {

    circle(
        fill = Colors.RED
    ) {
        position(x = ufo.x, y = 0)
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
                gameWindow.close(0)
            }

            // Finde kollidierenden Laser und speichere ihn als name "collidedLaser"
            val collidedLaser = hitTestView( lasers )
            // Wenn das ergebnis null ist, dann hat kein Laser kollidiert.
            // Aber wenn es NICHT null ist, dann ...
            if ( collidedLaser!=null ) {

                // lösche den asteroiden
                removeAsteroid( this )

                // lösche den laser
                removeLaser( collidedLaser )

            }

        }

    }

}

fun removeAsteroid(asteroid: View) {
    asteroid.removeFromParent()
}
