package za.ac.iie.sparksapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // declarations
        val etName = findViewById<EditText>(R.id.etName)
        val etTime = findViewById<EditText>(R.id.etTime)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val tvResult = findViewById<TextView>(R.id.textView4)
        val tvResult2 = findViewById<TextView>(R.id.textView5)

        // making button interactable
        btn1.setOnClickListener {
            val name = etName.text.toString()
            val time = etTime.text.toString()
            var response = ""

            if (name.isEmpty() || time.isEmpty()){
                response= "Please fill in all fields first"
            }else {

                //Decisions for output depending on input
                when (time) {
                    "Morning" -> response = "You can send a good morning sticker."
                    "Early Morning" -> response = "Dont interrupt a person when they are sleeping."
                    "Noon" -> response = "You can send a quick 'thinking of you' message"
                    "Afternoon" -> response = "Try sharing a funny meme or interesting link to a friend"
                    "Evening" -> response = "Maybe share some uplifting music or clips"
                    "Dinner" -> response = "Call a relative for a 5-minute catch up"
                    "Night" -> response = "Send a goodnight text"
                    else -> response = "Choose a time"
                }
            }
            // Display Result
            tvResult.text = "Hello $name"
            tvResult2.text = response
        }


        btn2.setOnClickListener {

            // declarations for use inside button
            val name = etName.text.toString()
            val time = etTime.text.toString()

            //Clears all input
            etName.text.clear()
            etTime.text.clear()

            //Resets value 
            tvResult.text = ""
            tvResult2.text = ""





        }


    }
}