class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClient.instance.listBreeds().enqueue(object : Callback<Map<String, Any>> {
            override fun onResponse(call: Call<Map<String, Any>>, response: Response<Map<String, Any>>) {
                val data = response.body()?.get("message") as? Map<String, List<String>>
                updateList(data?.keys?.toList() ?: emptyList())
            }
            override fun onFailure(call: Call<Map<String, Any>>, t: Throwable) {}
        })
    }
}