package com.pavelrukin.testappmvrxepoxy.ui.main

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.pavelrukin.testappmvrxepoxy.R
import com.pavelrukin.testappmvrxepoxy.databinding.MainFragmentBinding
import com.pavelrukin.testappmvrxepoxy.utils.redToast
import com.pavelrukin.testappmvrxepoxy.utils.viewBinding
import com.pavelrukin.testappmvrxepoxy.views.basicRow


class MainFragment : Fragment(R.layout.main_fragment), MavericksView {
    private val binding: MainFragmentBinding by viewBinding()
    private val viewModel: MainViewModel by fragmentViewModel()


    override fun invalidate() = withState(viewModel) { state ->
        viewModel.getCurrentTimeTextView(requireContext())

        binding.epoxyRv.withModels {
            basicRow {
                id("basic_row")
                tvCurrentTime(state.getCurrentTimeTextView())
                button { _ ->
                       Toast(requireActivity()).redToast(
                           message = requireActivity().getText(R.string.current_time)
                               .toString() + viewModel.getCurrentTimeToast(),
                           activity = requireActivity()
                       )
                   }
            }
        }
    }

}








