package com.vipkid.service.geo;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.IspResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

/**
 * Created by xushengxiang on 2017/5/4.
 */
public class GeoUtil {
    private static InputStream CITY_MMDB = GeoUtil.class.getResourceAsStream("/GeoLite2-City.mmdb");
    private static InputStream IPS_MMDB = GeoUtil.class.getResourceAsStream("/GeoIP2-ISP.mmdb");
    private static DatabaseReader city_reader;
    private static DatabaseReader ips_reader;

    public static void init(){
        try {
            city_reader =  new DatabaseReader.Builder(CITY_MMDB).build();
            ips_reader =  new DatabaseReader.Builder(IPS_MMDB).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static CityResponse getCity(String ip){
        if(city_reader == null) {
            return null;
        }
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            return city_reader.city(ipAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static IspResponse getIsp(String ip){
        if(ips_reader == null) {
            return null;
        }
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            return ips_reader.isp(ipAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
