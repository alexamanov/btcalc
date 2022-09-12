package com.alexamanov.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SendRequest
{
    public InputStream execute(
            String uri
    ) {
        try {
            return (new URL(uri).openStream());
        } catch (IOException e) {
            return null;
        }
    }
}
