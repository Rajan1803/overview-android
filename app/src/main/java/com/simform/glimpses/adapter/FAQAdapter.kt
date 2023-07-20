package com.simform.glimpses.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.simform.glimpses.R
import com.simform.glimpses.model.FAQ

class FAQAdapter(
    private val faqList: ArrayList<FAQ>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return faqList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return faqList[groupPosition].subListTitle.size
    }

    override fun getGroup(groupPosition: Int): FAQ {
        return faqList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return faqList[groupPosition].subListTitle[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        val headingTitle = getGroup(groupPosition)

        if (convertView == null) {
            val inflater =
                parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.item_heading_faq, null)
        }

        val tvHeading = convertView?.findViewById<TextView>(R.id.tvHeadingFAQ)
        tvHeading?.text = headingTitle.headingTitle

        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        val subTitle = getChild(groupPosition, childPosition)

        if (convertView == null) {
            val inflater =
                parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.item_sub_faq, null)
        }

        val tvSubFAQ = convertView?.findViewById<TextView>(R.id.tvSubFAQ)
        tvSubFAQ?.text = subTitle

        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}