package com.rusili.assessment4post.model;

import android.support.annotation.Nullable;

import java.util.List;

public class EchinodermResponse {
    private String status;
    private List<Animal> message;

    @Nullable
    public String getStatus() {
        return status;
    }

    @Nullable
    public List<Animal> getMessage() {
        return message;
    }
}
