package com.example.doctorappointment.domain

import android.os.Parcel
import android.os.Parcelable

data class Doctor(
    val Address: String = "",
    val Biography: String = "",
    val Experience: Int = 0,
    val Id: Int = 0,
    val Location: String = "",
    val Mobile: String = "",
    val Name: String = "",
    val Patiens: String = "",
    val Picture: String = "",
    val Rating: Double = 0.0,
    val Site: String = "",
    val Special: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeInt(Experience)
        parcel.writeInt(Id)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(Name)
        parcel.writeString(Patiens)
        parcel.writeString(Picture)
        parcel.writeDouble(Rating)
        parcel.writeString(Site)
        parcel.writeString(Special)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Doctor> {
        override fun createFromParcel(parcel: Parcel): Doctor = Doctor(parcel)
        override fun newArray(size: Int): Array<Doctor?> = arrayOfNulls(size)
    }
}
