package com.example.week4network.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginData {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("localId")
    @Expose
    private String localId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("idToken")
    @Expose
    private String idToken;
    @SerializedName("registered")
    @Expose
    private boolean registered;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("expiresIn")
    @Expose
    private String expiresIn;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserLoginData() {
    }

    /**
     *
     * @param expiresIn
     * @param kind
     * @param displayName
     * @param idToken
     * @param registered
     * @param localId
     * @param email
     * @param refreshToken
     */
    public UserLoginData(String kind, String localId, String email, String displayName, String idToken, boolean registered, String refreshToken, String expiresIn) {
        super();
        this.kind = kind;
        this.localId = localId;
        this.email = email;
        this.displayName = displayName;
        this.idToken = idToken;
        this.registered = registered;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public UserLoginData withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public UserLoginData withLocalId(String localId) {
        this.localId = localId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserLoginData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserLoginData withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public UserLoginData withIdToken(String idToken) {
        this.idToken = idToken;
        return this;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public UserLoginData withRegistered(boolean registered) {
        this.registered = registered;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public UserLoginData withRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public UserLoginData withExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserLoginData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("localId");
        sb.append('=');
        sb.append(((this.localId == null)?"<null>":this.localId));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("idToken");
        sb.append('=');
        sb.append(((this.idToken == null)?"<null>":this.idToken));
        sb.append(',');
        sb.append("registered");
        sb.append('=');
        sb.append(this.registered);
        sb.append(',');
        sb.append("refreshToken");
        sb.append('=');
        sb.append(((this.refreshToken == null)?"<null>":this.refreshToken));
        sb.append(',');
        sb.append("expiresIn");
        sb.append('=');
        sb.append(((this.expiresIn == null)?"<null>":this.expiresIn));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.expiresIn == null)? 0 :this.expiresIn.hashCode()));
        result = ((result* 31)+((this.kind == null)? 0 :this.kind.hashCode()));
        result = ((result* 31)+((this.displayName == null)? 0 :this.displayName.hashCode()));
        result = ((result* 31)+((this.idToken == null)? 0 :this.idToken.hashCode()));
        result = ((result* 31)+(this.registered? 1 : 0));
        result = ((result* 31)+((this.localId == null)? 0 :this.localId.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.refreshToken == null)? 0 :this.refreshToken.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserLoginData) == false) {
            return false;
        }
        UserLoginData rhs = ((UserLoginData) other);
        return (((((((((this.expiresIn == rhs.expiresIn)||((this.expiresIn!= null)&&this.expiresIn.equals(rhs.expiresIn)))&&((this.kind == rhs.kind)||((this.kind!= null)&&this.kind.equals(rhs.kind))))&&((this.displayName == rhs.displayName)||((this.displayName!= null)&&this.displayName.equals(rhs.displayName))))&&((this.idToken == rhs.idToken)||((this.idToken!= null)&&this.idToken.equals(rhs.idToken))))&&(this.registered == rhs.registered))&&((this.localId == rhs.localId)||((this.localId!= null)&&this.localId.equals(rhs.localId))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.refreshToken == rhs.refreshToken)||((this.refreshToken!= null)&&this.refreshToken.equals(rhs.refreshToken))));
    }

}

