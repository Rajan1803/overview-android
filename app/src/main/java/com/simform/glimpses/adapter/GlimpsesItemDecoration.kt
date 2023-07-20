package com.simform.glimpses.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GlimpsesItemDecoration(
    private val verticalSpace: Int = 12,
    private val horizontalSpace: Int = 8
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.apply {
            left = horizontalSpace
            right = horizontalSpace
            top = verticalSpace
            bottom = verticalSpace
        }
    }

}