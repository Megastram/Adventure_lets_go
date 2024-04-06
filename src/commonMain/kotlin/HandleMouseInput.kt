import gameElements.createLaser
import gameElements.lasers
import korlibs.korge.input.MouseEvents
import korlibs.korge.view.*

fun handleMouseInput(
    mouseEvents1: MouseEvents,
    ufo: Image,
    container: Stage
) {
    // wenn man die maus bewegt ...chek
    mouseEvents1.onMove { mouseEvents ->
        // setze die position vom ufo auf die position von der maus
        ufo.x = mouseEvents.currentPosStage.x
        ufo.y = mouseEvents.currentPosStage.y
    }

    // wenn man auf das ufo klickt ...chek
    mouseEvents1.onClick { mouseEvents ->
        if (mouseEvents.button.isLeft) {

            // wenn es noch keine 10 laser gibt ...
            if (lasers.size<10) {
                // erzeuge einen laser
                container.createLaser(ufo)
            }

        }
    }
}

