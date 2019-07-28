package com.adgvit.task4;

import com.google.gson.annotations.SerializedName;

public class data
{
    @SerializedName("name")
    String name;
    @SerializedName("imageUrl")
    String url;

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public data(String name, String url)
    {
        this.name = name;
        this.url = url;
    }
}