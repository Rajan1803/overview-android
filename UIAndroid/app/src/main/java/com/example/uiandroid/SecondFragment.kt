package com.example.uiandroid

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fragment lifecycle 2","onCreate")
        arguments?.let {

            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("fragment lifecycle 2","onAttach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("fragment lifecycle 2","onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("fragment lifecycle 2","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment lifecycle 2","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment lifecycle 2","onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("fragment lifecycle 2","onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("fragment lifecycle 2","onDestroyView")
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        Log.d("fragment lifecycle 2","onDestroyOptionsMenu")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("fragment lifecycle 2","onDetach")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d("fragment lifecycle 2","onLowMemory")
    }

    override fun onStop() {
        super.onStop()
        Log.d("fragment lifecycle 2","onStop")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("fragment lifecycle 2","onViewStateRestored")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        Log.d("fragment lifecycle 2","onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}