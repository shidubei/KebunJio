package iss.nus.edu.sg.sa4106.kebunjio


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivity()

    }

//     private fun startActivity() {
//         val intent = Intent(this, ReminderActivity::class.java)
//         startActivity(intent)
//     }
}
