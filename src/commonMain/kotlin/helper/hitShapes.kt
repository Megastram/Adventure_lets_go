package helper

import korlibs.korge.view.RectBase
import korlibs.korge.view.ShapeView
import korlibs.math.geom.Rectangle
import korlibs.math.geom.shape.EmptyShape2D
import korlibs.math.geom.shape.toShape2D

fun ShapeView.assignDefaultHitShape() {
    hitShape2d = path?.toShape2D() ?: EmptyShape2D
}

fun RectBase.assignDefaultHitShape() {
    hitShape2d = Rectangle(0.0,0.0, width, height)
}
