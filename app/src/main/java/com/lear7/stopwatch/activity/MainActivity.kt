package com.lear7.stopwatch.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lear7.stopwatch.R
import com.lear7.stopwatch.viewmodel.MyViewModel
import com.lear7.stopwatch.viewmodel.TimeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel: MyViewModel by viewModel()
    private val timeViewModel by viewModel<TimeViewModel>()
//    private val timeViewModel: TimeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateByViewModel()
    }

    private fun updateByViewModel() {
//        timeViewModel = ViewModelProviders.of(this).get(TimeViewModel::class.java)
        val observer = Observer<String> { newValue: String ->
            tv_time.text = newValue
        }
        timeViewModel.getTime().observe(this, observer)
    }
}
