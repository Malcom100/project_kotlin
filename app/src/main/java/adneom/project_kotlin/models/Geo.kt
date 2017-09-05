package adneom.project_kotlin.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

class Geo() : Parcelable{
    @Expose
    var lat : Double? = null
    get
    set

    @Expose
    var lng : Double? = null
    get
    set

    constructor(parcel: Parcel) : this() {
        lat = parcel.readDouble()
        lng = parcel.readDouble()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lat!!)
        parcel.writeDouble(lng!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Geo> {
        override fun createFromParcel(parcel: Parcel): Geo {
            return Geo(parcel)
        }

        override fun newArray(size: Int): Array<Geo?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString() : String {
        return "(".plus(lat).plus(",").plus(lng).plus(")")
    }
}