package prithvi.io.workmanager.utility.extentions

import android.content.Context
import android.location.LocationManager
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult

fun Context.isGPSEnabled() = (getSystemService(Context.LOCATION_SERVICE) as LocationManager).isProviderEnabled(LocationManager.GPS_PROVIDER)

private val onLocationResultStub = { _: LocationResult? -> Unit }

fun locationCallback(
        locationResult: (locationResult: LocationResult?) -> Unit = onLocationResultStub
): LocationCallback {
    return object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            super.onLocationResult(locationResult)
            locationResult(locationResult)
        }
    }
}