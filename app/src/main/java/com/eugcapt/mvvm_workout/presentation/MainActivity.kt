package com.eugcapt.mvvm_workout.presentation


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.eugcapt.mvvm_workout.R
import com.eugcapt.mvvm_workout.data.repository.UserRepositoryImpl
import com.eugcapt.mvvm_workout.data.storage.sharedprefs.SharedPrefsUserStorage


class MainActivity : AppCompatActivity() {

   // private val userStorage = UserStorage()
   private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
       UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = applicationContext))
   }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        com.eugcapt.mvvm_workout.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        com.eugcapt.mvvm_workout.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditTextVIew = findViewById<EditText>(R.id.dataEditTextVIew)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        //val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        receiveButton.setOnClickListener{
            val userName: com.eugcapt.mvvm_workout.domain.models.UserName = getUserNameUseCase.execute()
            "${userName.firstName} ${userName.lastName}".also { dataTextView.text = it }
        }

        sendButton.setOnClickListener {
            val text = dataEditTextVIew.text.toString()
            val params = com.eugcapt.mvvm_workout.domain.models.SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "save result = $result"
        }
    }
}