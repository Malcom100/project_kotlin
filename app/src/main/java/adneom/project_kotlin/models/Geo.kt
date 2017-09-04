package adneom.project_kotlin.models

import com.google.gson.annotations.Expose

class Geo {
    @Expose
    var lat : Double? = null
    get
    set

    @Expose
    var lng : Double? = null
    get
    set

    override fun toString() : String {
        return "(".plus(lat).plus(",").plus(lng).plus(")")
    }
}