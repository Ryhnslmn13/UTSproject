package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("foodName")
        val tvFoodName = findViewById<TextView>(R.id.etFoodName)
        tvFoodName.text = foodName ?: "No Food Selected"

        val etServings = findViewById<EditText>(R.id.etServings)
        val etName = findViewById<EditText>(R.id.etName)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnOrder.setOnClickListener {
            val servings = etServings.text.toString()
            val name = etName.text.toString()

            if (servings.isEmpty() || name.isEmpty()) {
                Toast.makeText(this, "Please fill in the servings and ordering name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("foodName", foodName)
                    putExtra("servings", servings)
                    putExtra("orderingName", name)
                    putExtra("orderingName", name)
                }
                startActivity(intent)
            }
        }
    }
}