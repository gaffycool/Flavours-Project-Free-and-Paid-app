package com.example.tae.myflavoursapp.data.network.model;

/**
 * Created by TAE on 21-Feb-18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedTopic {

    @SerializedName("Icon")
    @Expose
    private Icon icon;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("FirstURL")
    @Expose
    private String firstURL;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFirstURL() {
        return firstURL;
    }

    public void setFirstURL(String firstURL) {
        this.firstURL = firstURL;
    }

}