package org.diiage.poc.common.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.lifecycleScope
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.reflect.ParameterizedType
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass


@Suppress("UNCHECKED_CAST")
abstract class MVIFragment<State, Intent, Binding : ViewDataBinding, VM : StateIntentViewModel<State, Intent>>(
    private val layoutId: Int,
    private val viewModelVariable: Int,
    private val backButtonAction: (() -> Unit)? = null,
    private val scheduledAction: (()-> Unit)? = null
) : Fragment(), CoroutineScope {

    private val parameterizedType = javaClass.genericSuperclass as ParameterizedType
    private val viewModelClass = parameterizedType.actualTypeArguments.last() as KClass<VM>
    val viewModel: VM by createViewModelLazy(viewModelClass, { viewModelStore })

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Default
    private var _binding: Binding? = null
    protected val viewBinding: Binding
        get() = _binding
            ?: throw IllegalStateException("Trying to access the binding outside of the view lifecycle.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (backButtonAction != null) {
            requireActivity().onBackPressedDispatcher
                .addCallback(this, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        backButtonAction.invoke()
                    }
                })
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<Binding>(inflater, layoutId, container, false)
        .also { _binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.setVariable(viewModelVariable, viewModel)

        setupViews()

    }


    private var request: Job? = null
    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenResumed {
            viewModel.state.collect(::renderState)
        }
        if (scheduledAction != null) {
            request = launch { scheduledAction.invoke() }
        }
    }

    override fun onPause() {
        super.onPause()
        request?.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun setupViews()
    protected abstract fun renderState(viewState: State)
}