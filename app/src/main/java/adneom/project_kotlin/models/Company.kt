package adneom.project_kotlin.models

import com.google.gson.annotations.Expose

/**
 * Created by gtshilombowanticale on 04-09-17.
 */
class Company {
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

    override fun toString() : String {
        return name.plus(" ").plus(catchPhrase).plus(" ").plus(bs)
    }
}