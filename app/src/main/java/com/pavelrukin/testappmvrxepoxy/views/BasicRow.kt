package com.pavelrukin.testappmvrxepoxy.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.pavelrukin.testappmvrxepoxy.databinding.BasicRowBinding
import com.pavelrukin.testappmvrxepoxy.utils.viewBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class BasicRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding: BasicRowBinding by viewBinding()

    init {
        orientation = VERTICAL
    }

    @TextProp
    fun setTvCurrentTime(tvCurrentTime: CharSequence?) {
        binding.tvCurrentTime.text = tvCurrentTime
    }

    @CallbackProp
    fun setButton(clickListener: OnClickListener?) {
        binding.btnButton.setOnClickListener(clickListener)


    }

}