package vcmsa.ci.practicumexam
// ST10469837 DIMPHO BIANCA MOKOENA
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // The values are set to mutable lists, to allow the user to edit their entries.
    companion object {

    val songTitle = mutableListOf<String>()
    val artistName = mutableListOf<String>()
    val rating = mutableListOf<Int>()
    val comments = mutableListOf<String>()
}
// Declaration of button variables.
    var addBtn: Button? = null
    var nextBtn: Button? = null
    var exitBtn: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
// The mutable list values are found by their initialised ID's
        val songTitle = findViewById<View>(R.id.songTitle) as EditText
        val artistName = findViewById<View>(R.id.artistName) as EditText
        val rating = findViewById<View>(R.id.rating) as EditText
        val comments = findViewById<View>(R.id.comments) as EditText

        // Buttons are found by their initialised ID's
        addBtn = findViewById<View>(R.id.addBtn) as Button
        nextBtn = findViewById<View>(R.id.nextBtn) as Button
        exitBtn = findViewById<View>(R.id.exitBtn) as Button

        // When triggered, this button will add the user's inputs in the playlist.
        addBtn!!.setOnClickListener{
            val titleSong = songTitle.text.toString()
            val name = artistName.text.toString()
            val rates = rating.text.toString()
            val comment = comments.text.toString()
          //  When there are missing inputs, users will be prompted to fill them in.
            if (titleSong.isBlank() || name.isBlank() || rates.isBlank() || comment.isBlank()) {
                Toast.makeText(this, "Please fill in all empty spaces.", Toast.LENGTH_SHORT).show()
            }
            // If the user inputs a rating less than 1 or more than 5, they will be prompted to rate from 1-5
            val rate = rates.toInt()
            if (rate == null || rate > 5) {
                Toast.makeText(this, "Please rate from numbers 1-5", Toast.LENGTH_SHORT).show()
            }
            // When all information has been filled in, there will be an output to inform the user that the information has been added in the list.
            if (titleSong.isNotEmpty() || name.isNotEmpty() || rates.isNotEmpty() || comment.isNotEmpty()) {
                Toast.makeText(this, "Added: $songTitle \n Added: $artistName \n Added: $rating \n Added: $comments", Toast.LENGTH_SHORT).show()

                songTitle.text.clear()
                artistName.text.clear()
                rating.text.clear()
                comments.text.clear()
            }
        }
        // When this button is triggered, it will allow users to move to the detailed view screen.
        nextBtn!!.setOnClickListener{
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }
        // When this button is triggered, it will stop the application.
        exitBtn!!.setOnClickListener {
            finishAffinity()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}