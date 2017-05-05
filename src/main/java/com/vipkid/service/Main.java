package com.vipkid.service;

import com.google.gson.Gson;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.vipkid.service.geo.GeoUtil;

import static com.vipkid.service.geo.GeoUtil.getCity;
import static com.vipkid.service.geo.GeoUtil.getIsp;
import static com.vipkid.service.useragent.UserAgentUtil.getBrowserAndVersion;
import static spark.Spark.get;
import static spark.Spark.internalServerError;
import static spark.Spark.notFound;
import static spark.Spark.path;
import static spark.Spark.port;

import java.io.IOException;


/**
 * Created by xushengxiang on 2017/5/4.
 */
public class Main {
    public static void main(String[] args) throws IOException, GeoIp2Exception {
        init();
    }
    private static void init() {
        GeoUtil.init();
        Gson gson = new Gson();

        port(8080);
        get("/health", (q, a) -> "ok");
        path("/api", () -> {
            path("/ip/:ip", () -> {
                get("/city", (request, response) -> getCity(request.params(":ip")), gson::toJson);
                get("/isp", (request, response) ->  getIsp(request.params(":ip")), gson::toJson);
            });
            get("/ua", ((request, response) -> getBrowserAndVersion(request.queryParams("userAgent"))), gson::toJson);
        });

        notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Custom 404\"}";
        });

        internalServerError((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"oh!! your request unsupported \"}";
        });



    }
}
