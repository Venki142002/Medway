package com.medway.db;
import com.medway.registration.registration;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@Component
public class RegDb
{
    public String  result;
    public void Registration(registration reg)
    {
        addReg(reg);
    }
   private void addReg(registration reg)  {
        String username,fullname, mail_id, password, dob1,gender, mobile,bloodgrp,city;
        username = reg.getUsername() ;
        fullname = reg.getFullname();
        mail_id  = reg.getMailid();
        password = reg.getPassword();
        dob1 = reg.getDob();
        gender = reg.getGender();
        mobile = reg.getPhno();
        bloodgrp = reg.getBld();
        city = reg.getCity();

        //for checking already account  is present'
        String mail_avalable = "";

        try {
            Statement smt = db_connection.con.createStatement();
            ResultSet data = smt.executeQuery("select PRO.MEDWAY.MAIL_ID FROM PRO.MEDWAY WHERE MAIL_ID ='" + mail_id + "'");
            if (data.next()) {
                mail_avalable = data.getString(1);
            }
            if (!Objects.equals(mail_avalable, mail_id))
            {
                try {
                    db_connection.pst = db_connection.con.prepareStatement("INSERT INTO PRO.MEDWAY (USERNAME, FULLNAME, MAIL_ID, PASSWORD, DOB, GENDER, MOBILE, BLOODGRP, CITY) VALUES(?, ?,?,?,?,?,?,?,?)");
                    db_connection.pst.setString(1, username);
                    db_connection.pst.setString(2, fullname);
                    db_connection.pst.setString(3, mail_id);
                    db_connection.pst.setString(4, password);
                    db_connection.pst.setString(5, dob1);
                    db_connection.pst.setString(6, gender);
                    db_connection.pst.setString(7, mobile);
                    db_connection.pst.setString(8, bloodgrp);
                    db_connection.pst.setString(9, city);

                    db_connection.pst.execute();
                    result = "ACCOUNT AS BEEN SUCCESSFULLY CREATED";

                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                    result = "PLEASE TRY AGAIN LATER";
                }
            }
            else
            {
                result = "ALREADY ACCOUNT AS BEEN AVAILABLE";
            }
            }
       catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
