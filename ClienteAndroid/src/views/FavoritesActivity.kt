package com.example.dogclient

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dogclient.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        loadFavorites()
    }

    private fun loadFavorites() {
        RetrofitClient.instance.getFavorites().enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    val favoriteUrls = response.body()
                    // Lógica para exibir as imagens favoritadas
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Toast.makeText(this@FavoritesActivity, "Erro ao carregar favoritos", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun removeFavorite(url: String) {
        RetrofitClient.instance.removeFavorite(url).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@FavoritesActivity, "Removido!", Toast.LENGTH_SHORT).show()
                    loadFavorites() 
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {}
        })
    }
}