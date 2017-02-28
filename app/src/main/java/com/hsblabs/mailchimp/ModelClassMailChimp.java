package com.hsblabs.mailchimp;

/**
 * Created by Muhammad Haseeb on 2/28/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClassMailChimp {
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("merge_fields")
    @Expose
    private MergeFields mergeFields;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MergeFields getMergeFields() {
        return mergeFields;
    }

    public void setMergeFields(MergeFields mergeFields) {
        this.mergeFields = mergeFields;
    }

}
