package adneom.project_kotlin.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

/**
 * Created by gtshilombowanticale on 04-09-17.
 */
class Company() : Parcelable{
    @Expose
    var name : String? = null
    get
    set

    @Expose
    var catchPhrase : String? = null
    get
    set

    @Expose
    var bs : String? = null
    get
    set

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        catchPhrase = parcel.readString()
        bs = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(catchPhrase)
        parcel.writeString(bs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Company> {
        override fun createFromParcel(parcel: Parcel): Company {
            return Company(parcel)
        }

        override fun newArray(size: Int): Array<Company?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString() : String {
        return name.plus(" ").plus(catchPhrase).plus(" ").plus(bs)
    }
}