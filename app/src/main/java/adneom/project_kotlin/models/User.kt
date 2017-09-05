package adneom.project_kotlin.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

class User  : Parcelable {
    @Expose
    var name : String? = null
    get
    set
    @Expose
    var id : Int? = null
    get
    set
    @Expose
    var username : String? = null
    get
    set
    @Expose
    var email : String? = null
    get
    set
    @Expose
    var phone : String? = null
    get
    set
    @Expose
    var website : String? = null
    get
    set
    @Expose
    var address : Address? = null
    get
    set
    @Expose
    var company : Company? = null
    get
    set

    /*init {
        name = mName
        id = mId
        username = mUsername
        email = mEmail
        phone = mPhone
        website = mWebSite
        address = mAddress
        company = mCompany
    }*/

    constructor(spurce: Parcel) : super() {
        name = spurce.readString()
        id = spurce.readInt()
        username = spurce.readString()
        email = spurce.readString()
        phone = spurce.readString()
        website = spurce.readString()
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(source: Parcel): User {
            return User(source)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeString(name)
        dest!!.writeInt(id!!)
        dest!!.writeString(username)
        dest!!.writeString(email)
        dest!!.writeString(phone)
        dest!!.writeString(website)
    }

    override fun describeContents(): Int {
        return 0
    }


    override fun toString() : String {
        return "{".plus(id).plus(" ").plus(name).plus(" ").plus(username).plus(" ").plus(email).plus(" ").plus(phone).plus(" ").plus(website).plus(" - ").plus(address.toString()).plus(" - ").plus(company.toString()).plus("}")
    }
}