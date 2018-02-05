package id.dev.catnip.perpustakaanapp.utils

import android.graphics.drawable.Drawable
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator

/**
 * Created by herma on 05-Feb-18.
 */
class DrawableText{
    companion object {
        fun makeDrawable(text : String?): Drawable {
            val generator : ColorGenerator = ColorGenerator.MATERIAL
            var color = generator.randomColor
            val builder: TextDrawable.IBuilder = TextDrawable.builder()
                    .beginConfig()
                    .width(60)  // width in px
                    .height(60) // height in px\
                    .endConfig()
                    .round()
            val draw = builder.build(text!!.substring(0,2), color)
            return draw
        }
    }

}