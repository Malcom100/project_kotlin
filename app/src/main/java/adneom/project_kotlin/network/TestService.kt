package adneom.project_kotlin.network

import adneom.project_kotlin.models.User
import io.reactivex.Observable
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by gtshilombowanticale on 01-09-17.
 */


interface TestService {

    @GET("/users")
    fun getUsers(): Call<List<User>>

    @GET("/users")
    fun getUsersObs(): Observable<List<User>>

}