package api

import retrofit2.Call
import retrofit2.http.*

interface DogApiEndpoint {
    @GET("api/breeds")
    fun listBreeds(): Call<Map<String, Any>>

    @GET("api/breeds/{breed}/images")
    fun getImages(@Path("breed") breed: String): Call<List<String>>

    @GET("api/favorites")
    fun getFavorites(): Call<List<String>>

    @POST("api/favorites")
    fun addFavorite(@Query("imageUrl") url: String): Call<Void>

    @DELETE("api/favorites")
    fun removeFavorite(@Query("imageUrl") url: String): Call<Void>
}