package ram.ramires.company3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import androidx.databinding.DataBindingUtil.setContentView
import ram.ramires.company3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Locale.setDefault(Locale("ru", "RU"))
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}