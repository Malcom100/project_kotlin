package adneom.project_kotlin.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose


class Address() : Parcelable {
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

    constructor(parcel: Parcel) : this() {
        street = parcel.readString()
        suite = parcel.readString()
        city = parcel.readString()
        zipcode = parcel.readString()
        geo = parcel.readParcelable(Geo::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(street)
        parcel.writeString(suite)
        parcel.writeString(city)
        parcel.writeString(zipcode)
        parcel.writeParcelable(geo,flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString() : String {
        return street.plus("-").plus(suite).plus("-").plus(city).plus("-").plus(zipcode).plus(" : ").plus(geo.toString())
    }
}