package vcmsa.ci.practicumexam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {
    val songTitle = mutableListOf<String>()
    val artistName = mutableListOf<String>()
    val rating = mutableListOf<Int>()
    val comments = mutableListOf<String>()
    // Declarations
    var output: TextView? = null
    var displayBtn: Button? = null
    var averageBtn: Button? = null
    var returnBtn: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        // variables are found by the ID's
        output = findViewById<View>(R.id.output) as TextView
        displayBtn = findViewById<View>(R.id.displayBtn) as Button
        averageBtn = findViewById<View>(R.id.averageBtn) as Button
        returnBtn = findViewById<View>(R.id.returnBtn) as Button

        // Button that will display all inputs.
        displayBtn!!.setOnClickListener {
            val builder = StringBuilder()
            for (i in MainActivity.songTitle.indices) {
                if (MainActivity.rating[i] >= 2) {
                   output!!.text = ("Song Title: ${MainActivity.songTitle[i]} \n")
                   output!!.text = ("Artist Name: ${MainActivity.artistName[i]}\n")
                   output!!.text = ("Rating: ${MainActivity.rating[i]}\n")
                   output!!.text = ("Comments: ${MainActivity.comments[i]}\n")

                }
                }

            }


        // Button that allows user to return back to first screen.
        returnBtn!!.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        averageBtn!!.setOnClickListener {


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    } }
