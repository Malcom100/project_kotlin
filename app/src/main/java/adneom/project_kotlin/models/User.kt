package adneom.project_kotlin.models

import com.google.gson.annotations.Expose

class User (mName : String, mId : Int, mUsername : String, mEmail : String, mPhone : String, mWebSite : String, mAddress: Address, mCompany : Company){
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

    init {
        name = mName
        id = mId
        username = mUsername
        email = mEmail
        phone = mPhone
        website = mWebSite
        address = mAddress
        company = mCompany
    }

    override fun toString() : String {
        return "{".plus(id).plus(" ").plus(name).plus(" ").plus(username).plus(" ").plus(email).plus(" ").plus(phone).plus(" ").plus(website).plus(" - ").plus(address.toString()).plus(" - ").plus(company.toString()).plus("}")
    }
}