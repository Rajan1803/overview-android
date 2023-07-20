package com.simform.glimpses.customViews

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import com.simform.glimpses.R

class OTPView : LinearLayout {

    var otpLength: Int = 4
    private var otpListener: OTPListener? = null

    private var customTextColor = 0
    private var customPaddingLeft = 0
    private var customPaddingTop = 0
    private var customPaddingRight = 0
    private var customPaddingBottom = 0
    private var customPadding = 0
    private var customMargin = 0
    private var customWidth = 0
    private var customHeight = 0
    private var backgroundDrawable = 0

    private var itemViews = ArrayList<EditText>()

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        val styles = context.obtainStyledAttributes(attrs, R.styleable.OTPView)
        customTextColor = styles.getColor(
            R.styleable.OTPView_valueColor, context.getColor(R.color.black)
        )
        customWidth = styles.getDimension(R.styleable.OTPView_width, DEFAULT_WIDTH).toInt()
        customHeight = styles.getDimension(R.styleable.OTPView_height, DEFAULT_HEIGHT).toInt()
        customPadding = styles.getDimension(R.styleable.OTPView_customPadding, -1f).toInt()
        customPaddingLeft = styles.getDimension(R.styleable.OTPView_customPaddingLeft, 0f).toInt()
        customPaddingTop = styles.getDimension(R.styleable.OTPView_customPaddingTop, 0f).toInt()
        customPaddingRight = styles.getDimension(R.styleable.OTPView_customPaddingRight, 0f).toInt()
        customPaddingBottom =
            styles.getDimension(R.styleable.OTPView_customPaddingBottom, 0f).toInt()
        customMargin = styles.getDimension(R.styleable.OTPView_customMargin, 0f).toInt()
        backgroundDrawable =
            styles.getResourceId(R.styleable.OTPView_backgroundSrc, R.drawable.corner_bordered)
        styleEditTexts(styles)
        styles.recycle()
    }

    private fun styleEditTexts(styles: TypedArray) {
        orientation = HORIZONTAL
        val linearLayoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutParams = linearLayoutParams
        otpLength = styles.getInt(R.styleable.OTPView_otpLength, DEFAULT_LENGTH)
        generateViews()
    }

    private fun generateViews() {
        itemViews = ArrayList()
        if (otpLength > 0) {
            for (i in 0 until otpLength) {
                addEditText()
            }

            itemViews.forEachIndexed { index, editText ->
                if (index > 0 && index < itemViews.count() - 1) {
                    editText.addTextChangedListener(
                        CustomTextWatcher(
                            this, editText, itemViews[index + 1], context
                        )
                    )
                    editText.setOnKeyListener(CustomKeyEvent(editText, itemViews[index - 1]))
                } else if (index == 0) {
                    editText.addTextChangedListener(
                        CustomTextWatcher(
                            this, editText, itemViews[1], context
                        )
                    )
                } else {
                    editText.setOnKeyListener(CustomKeyEvent(editText, itemViews[index - 1]))
                    editText.addTextChangedListener(
                        CustomTextWatcher(
                            otpView = this, currentEditText = editText, nextEditText = null, context
                        )
                    )
                }
            }
        } else {
            throw IllegalStateException(context.getString(R.string.please_specify_the_length_of_the_otp_view))
        }
    }

    private fun addEditText() {
        val editText = EditText(context).apply {
            layoutParams = LayoutParams(customWidth, customHeight).apply {
                setMargins(customMargin, 0, customMargin, 0)
            }
            gravity = Gravity.CENTER
            if (customPadding == -1) {
                setPadding(
                    customPaddingLeft, customPaddingTop, customPaddingRight, customPaddingBottom
                )
            } else {
                setPadding(
                    customPadding, customPadding, customPadding, customPadding
                )
            }
            setTextColor(customTextColor)
            setSelectAllOnFocus(true)
            inputType = InputType.TYPE_CLASS_NUMBER
            filters += InputFilter.LengthFilter(1)
            background = AppCompatResources.getDrawable(context, backgroundDrawable)
        }
        itemViews.add(editText)
        addView(editText)
    }

    fun setOTPListener(listener: OTPListener) {
        otpListener = listener
    }

    companion object {

        private const val DEFAULT_LENGTH = 4
        private const val DEFAULT_HEIGHT = 48f
        private const val DEFAULT_WIDTH = 48f

    }

    fun interface OTPListener {
        fun onOTPCompleted(otp: String)
    }

    class CustomTextWatcher(
        private val otpView: OTPView,
        private val currentEditText: EditText,
        private val nextEditText: EditText?,
        val context: Context
    ) : TextWatcher {

        override fun beforeTextChanged(string: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(string: CharSequence?, start: Int, before: Int, count: Int) {
            string?.let {
                if (count == 1) {
                    currentEditText.clearFocus()
                    if (nextEditText != null) {
                        nextEditText.requestFocus()
                    } else {
                        otpView.otpListener?.let { otpListener ->
                            val otpString = otpView.itemViews.fold("") { acc, editText ->
                                acc.plus(editText.text)
                            }

                            if (otpString.length == otpView.otpLength) {
                                otpListener.onOTPCompleted(otpString)
                            }
                        }
                        (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                            currentEditText.windowToken, 0
                        )
                    }
                }
            }
        }

        override fun afterTextChanged(string: Editable?) {}

    }

    class CustomKeyEvent(private val currentView: EditText, private val previousView: EditText?) :
        OnKeyListener {
        override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event != null && event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && previousView != null && currentView.text.isEmpty()) {
                previousView.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }
    }

}