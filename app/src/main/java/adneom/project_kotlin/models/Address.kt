package adneom.project_kotlin.models

import com.google.gson.annotations.Expose


class Address {
    @Expose
    var street : String? = null
    get
    set
    @Expose
    var suite : String? = null
    get
    set
    @Expose
    var city : String? = null
    get
    set
    @Expose
    var zipcode : String? = null
    get
    set

    @Expose
    var geo : Geo? = null
    get
    set

    override fun toString() : String {
        return street.plus("-").plus(suite).plus("-").plus(city).plus("-").plus(zipcode).plus(" : ").plus(geo.toString())
    }
}