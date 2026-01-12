package com.example.dogclient

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dogclient.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryActivity : AppCompatActivity() {

    private var breedName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        breedName = intent.getStringExtra("BREED_NAME")
        
        loadImages()
    }

    private fun loadImages() {
        breedName?.let {
            RetrofitClient.instance.getImages(it).enqueue(object : Callback<List<String>> {
                override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                    if (response.isSuccessful) {
                        val images = response.body()
                        // Aqui você deve inflar seu RecyclerView ou Adapter de imagens
                    }
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    Toast.makeText(this@GalleryActivity, "Erro ao carregar imagens", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun favoriteImage(url: String) {
        RetrofitClient.instance.addFavorite(url).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@GalleryActivity, "Adicionado aos favoritos!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {}
        })
    }
}