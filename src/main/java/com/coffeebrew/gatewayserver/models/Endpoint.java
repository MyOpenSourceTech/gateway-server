package com.coffeebrew.gatewayserver.models;

import java.util.regex.Pattern;

public class Endpoint {
    private String url;
    private String method;

    public Endpoint(String endpoint) {
        String[] split = endpoint.split(";");
        this.url = split[0];
        this.method = split[1];
    }

    public Endpoint(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public boolean equals(Endpoint obj) {
        boolean match1 = Pattern.compile(url).matcher(obj.url).matches();
        boolean match2 = Pattern.compile(obj.url).matcher(url).matches();
        if ((match1 || match2) && obj.method.equals(method)) {
            return true;
        } else {
            return false;
        }
    }
}
