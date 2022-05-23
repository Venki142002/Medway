package com.medway.userlocation;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;
import com.medway.db.db_connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class locationProcess
{
    public static Double latitude;
    public static Double longitude;
    public static String address;
    public static int distance = 1000;
    public static String hosname = "";
    public locationProcess(Double latitudes,Double longitudes)
    {
       latitude = latitudes;
        longitude =longitudes;
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("fa043bf06f0e4c7c98bcfdf8d74e6056");

        JOpenCageReverseRequest request = new JOpenCageReverseRequest(latitude, longitude);
        request.setLanguage("es");
        request.setNoDedupe(true);
        request.setLimit(5);
        request.setNoAnnotations(true);
        request.setMinConfidence(3);
        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
        address = response.getResults().get(0).getFormatted();
        System.out.println(address);
        distance();
    }
    public void distance()
    {
      int  radius = 6371;
        try {
            Statement smt = db_connection.con.createStatement();//creating statement for executing the query
            ResultSet result = smt.executeQuery("select NAME,LATITUDE,LONGITUDE FROM PRO.MEDWAY_HOSPITAL ");//executing query
            while (result.next())
            {
                String name = result.getString(1);
                double lat2 = result.getDouble(2);
                double lon2 = result.getDouble(3);
                double dlat = Math.toRadians(lat2 - latitude);
                double dlon = Math.toRadians(lon2-longitude);
                double a = Math.sin(dlat/2) * Math.sin(dlat/2) + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dlon/2) * Math.sin(dlon/2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                double d = radius * c;
                if (distance>d)
                {
                    distance = (int) d;
                    hosname = name;
                }
            }
            System.out.println(distance*1.609344);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
