package ve.develop.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ve.develop.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Valery Egorov")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            showNickName()
        }
    }

    private fun showNickName() {
        binding.apply {
            binding.myName?.nickName = binding.inputName.text.toString()
            binding.nameTextview.visibility = View.VISIBLE
            binding.inputName.visibility = View.GONE
            invalidateAll()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(imageView.windowToken,0)
        }

    }

}