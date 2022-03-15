package com.example.week4network.Entity;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DutyPharmacy implements Parcelable
{

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("dist")
    @Expose
    private String dist;
    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    public final static Creator<DutyPharmacy> CREATOR = new Creator<DutyPharmacy>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DutyPharmacy createFromParcel(android.os.Parcel in) {
            return new DutyPharmacy(in);
        }

        public DutyPharmacy[] newArray(int size) {
            return (new DutyPharmacy[size]);
        }

    };

    public DutyPharmacy(String address, String dist, String loc, String name, String phone) {
        this.address = address;
        this.dist = dist;
        this.loc = loc;
        this.name = name;
        this.phone = phone;
    }

    protected DutyPharmacy(android.os.Parcel in) {
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.dist = ((String) in.readValue((String.class.getClassLoader())));
        this.loc = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DutyPharmacy() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.dist == null)? 0 :this.dist.hashCode()));
        result = ((result* 31)+((this.loc == null)? 0 :this.loc.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.phone == null)? 0 :this.phone.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DutyPharmacy) == false) {
            return false;
        }
        DutyPharmacy rhs = ((DutyPharmacy) other);
        return ((((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.dist == rhs.dist)||((this.dist!= null)&&this.dist.equals(rhs.dist))))&&((this.loc == rhs.loc)||((this.loc!= null)&&this.loc.equals(rhs.loc))))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.phone == rhs.phone)||((this.phone!= null)&&this.phone.equals(rhs.phone))));
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(address);
        dest.writeValue(dist);
        dest.writeValue(loc);
        dest.writeValue(name);
        dest.writeValue(phone);
    }

    public int describeContents() {
        return 0;
    }

}