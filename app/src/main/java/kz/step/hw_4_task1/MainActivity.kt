package kz.step.hw_4_task1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var submit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        submit = findViewById(R.id.button_sent_message)
    }

    private fun initializeLiseners() {
        submit?.setOnClickListener {
            val message = "“Hello i have written Intent which\n" +
                    "sending you this message"
            sendMessage(message);
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun sendMessage(message: String) {

        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"

        intent.setPackage("com.whatsapp")

        intent.putExtra(Intent.EXTRA_TEXT, message)

        startActivity(intent)
    }
}