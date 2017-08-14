package com.galaxysoft.aquaplannernetng.net.requests.status;

import com.galaxysoft.aquaplannernetng.model.Status;
import com.galaxysoft.aquaplannernetng.net.requests.base.BaseParser;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StatusParser implements BaseParser<Status> {
    @NotNull
    @Override
    public List<Status> parse(@NotNull byte[] data) {
        return null;
    }
}
