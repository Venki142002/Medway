package com.medway.db;

import com.medway.userlocation.locationProcess;

import java.sql.SQLException;
import java.sql.Statement;

public class userEmergencyData
{
    public userEmergencyData(String name, String phno)
    {
        try
        {
            db_connection.pst = db_connection.con.prepareStatement("INSERT INTO PRO.medway_acc_details(name, mobile, location, Address,HOSPTITAL) VALUES(?,?,?,?,?)");
            db_connection.pst.setString(1,name);
            db_connection.pst.setString(2,phno);
            db_connection.pst.setString(3, "http://maps.google.com/maps?q="+ locationProcess.latitude+","+locationProcess.longitude);
            db_connection.pst.setString(4, locationProcess.address);
            db_connection.pst.setString(5, locationProcess.hosname);
            db_connection.pst.execute();

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}

