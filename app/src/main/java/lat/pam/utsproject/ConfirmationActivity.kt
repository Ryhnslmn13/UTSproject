package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("foodName") ?: "Unknown Food"
        val servings = intent.getStringExtra("servings") ?: "N/A"
        val orderingName = intent.getStringExtra("orderingName") ?: "Unknown"
        val additionalNotes = intent.getStringExtra("additionalNotes") ?: "None"

        findViewById<TextView>(R.id.tvTitle).text = "Order Confirmation"
        findViewById<TextView>(R.id.foodNameTextView).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.servingsTextView).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.orderingNameTextView).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.additionalNotesTextView).text = "Additional Notes: $additionalNotes"

        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}