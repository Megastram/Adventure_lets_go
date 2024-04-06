import korlibs.image.format.readBitmap
import korlibs.io.file.std.resourcesVfs
import korlibs.korge.view.*

suspend fun Stage.createUfo() = image(resourcesVfs["Ufo.png"].readBitmap()) {
    anchor(.5, .5)
    position(256, 256)
    scale(2.0)
    val bounds = getLocalBounds()
    hitShape {
        ellipse(bounds)
    }
}
