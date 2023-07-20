package com.simform.glimpses.decorations

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewItemDecoration(
    context: Context,
    resId: Int
) : RecyclerView.ItemDecoration() {

    private var mDivider: Drawable? = ContextCompat.getDrawable(context, resId)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val dividerLeft: Int = parent.x.toInt() + 20


        for (i in 0 until parent.childCount) {
            if (i != parent.childCount - 1) {
                val child: View = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams

                mDivider?.let {
                    val dividerTop: Int = child.bottom + params.bottomMargin - 40
                    val dividerBottom: Int = dividerTop + it.intrinsicHeight
                    val dividerRight: Int = parent.width - 80

                    it.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                    it.draw(c)
                }
            }
        }
    }

    // If Want to use getItemOffsets with Item Decoration for custom Offsets
//    override fun getItemOffsets(
//        outRect: Rect,
//        view: View,
//        parent: RecyclerView,
//        state: RecyclerView.State
//    ) {
////        super.getItemOffsets(outRect, view, parent, state)
//        var itemPosition = parent.getChildAdapterPosition(view)
//        if (itemPosition == 2) {
//            outRect.top += 20
//        }
//    }

}
