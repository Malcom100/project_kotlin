package adneom.project_kotlin.picture.map

import adneom.project_kotlin.Manifest
import adneom.project_kotlin.R
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import kotlinx.android.synthetic.main.fragment_map.*
import com.google.android.gms.internal.v
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), MapContract.View,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMarkerClickListener {

    companion object {
        val REQUEST_LOCATION : Int = 874
        fun newInstance() : MapFragment { return MapFragment()
        }
    }

    private lateinit var presenter : MapContract.Presenter

    lateinit var mMapView : MapView
    lateinit var mGoogleMap : GoogleMap
    lateinit var mGoogleApiClient : GoogleApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v : View = inflater!!.inflate(R.layout.fragment_map,container,false)
        //get map view from this VIEW = v
        mMapView = v.findViewById(R.id.mapView) as MapView
        mMapView.onCreate(savedInstanceState)

        MapsInitializer.initialize(this.activity)
        return v
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createConnectionGoogleAPI()
        mMapView!!.getMapAsync {
            googleMap ->
            println("map ready !")
            mGoogleMap = googleMap
            checkPermissions()
        }
    }

    fun createConnectionGoogleAPI(){
        mGoogleApiClient = GoogleApiClient.Builder(this.activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()
    }

    fun checkPermissions() {
        if(ActivityCompat.checkSelfPermission(this.activity,android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this.activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION)
        } else {
            initListeners()
            mGoogleMap.isMyLocationEnabled = true

            mGoogleMap.uiSettings.isMyLocationButtonEnabled = false

            val bxl : LatLng = LatLng(50.8537638, 4.3147165)
            mGoogleMap.addMarker(MarkerOptions().position(bxl).title("Brussels").snippet(" Hello everyone"))

            val cameraPosition : CameraPosition = CameraPosition.builder().target(bxl).zoom(12F).build()
        }
    }

    fun initListeners() {
        mGoogleMap.setOnMarkerClickListener(this)
        mGoogleMap.setOnMapLongClickListener(this)
        mGoogleMap.setOnInfoWindowClickListener(this)
        mGoogleMap.setOnMapClickListener(this)
    }

    override fun setPresenter(mPresenter: MapContract.Presenter) {
        presenter = mPresenter
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_LOCATION ->
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    checkPermissions()
                }
            else -> println("no response")
        }
    }

    override fun onResume() {
        mMapView.onResume()
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
        mGoogleApiClient.connect()
    }

    override fun onDestroy() {
        mMapView.onDestroy()
        super.onDestroy()
    }

    //google map and google api
    override fun onConnected(p0: Bundle?) {
    }

    override fun onConnectionSuspended(p0: Int) {
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
    }

    override fun onInfoWindowClick(p0: Marker?) {
    }

    override fun onMapClick(p0: LatLng?) {
    }

    override fun onMapLongClick(p0: LatLng?) {
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        return false
    }
}