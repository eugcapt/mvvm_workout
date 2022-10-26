package com.eugcapt.mvvm_workout.presentation


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eugcapt.mvvm_workout.R
import com.eugcapt.mvvm_workout.data.repository.UserRepositoryImpl
import com.eugcapt.mvvm_workout.data.storage.models.User
import com.eugcapt.mvvm_workout.data.storage.sharedprefs.SharedPrefsUserStorage
import com.eugcapt.mvvm_workout.domain.models.UserName
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

   // private val userStorage = UserStorage()


    private  val vm: MainViewModel by viewModel<MainViewModel>()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditTextVIew = findViewById<EditText>(R.id.dataEditTextVIew)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

       vm.resultLive.observe(this, Observer {
           dataTextView.text = it
       })


        receiveButton.setOnClickListener{
            vm.load()
        }

        sendButton.setOnClickListener {
            val text = dataEditTextVIew.text.toString()
            vm.save(text)

        }
    }
}