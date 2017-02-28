package com.hsblabs.mailchimp;

/**
 * Created by Muhammad Haseeb on 2/28/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MergeFields {
    @SerializedName("FNAME")
    @Expose
    private String fNAME;
    @SerializedName("LNAME")
    @Expose
    private String lNAME;

    public String getFNAME() {
        return fNAME;
    }

    public void setFNAME(String fNAME) {
        this.fNAME = fNAME;
    }

    public String getLNAME() {
        return lNAME;
    }

    public void setLNAME(String lNAME) {
        this.lNAME = lNAME;
    }
}
