package com.medway;

import com.medway.db.RegDb;
import com.medway.db.db_connection;
import com.medway.db.login;
import com.medway.db.userEmergencyData;
import com.medway.login.loginvalidation;
import com.medway.registration.registration;
import com.medway.userlocation.locationProcess;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Controller
public class medwayController
{
    @RequestMapping("/")
    public String home(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        session.removeAttribute("latitude");
        session.removeAttribute("longitude");
        return "index";
    }

    //LOGIN PAGE PROCESS
    @RequestMapping("login")
    public String loginform(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        session.removeAttribute("a");
        return "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String loginvalidation(@ModelAttribute loginvalidation logindata , HttpServletRequest req)
    {
        System.out.println(logindata);
        login process = new login();
        process.validate(logindata);
        HttpSession session = req.getSession();
        if (process.loginresult.equals("Sucess"))
        {
            session.setAttribute("username",logindata.getMail());
            return "/";
        }
        else
        {
            session.setAttribute("a", process.loginresult);
            return "login";
        }
    }

    //logout
    @RequestMapping( "logout")
    public String logout( HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        return "index";
    }


    //REGISTRATION PAGE PROCESS
    @RequestMapping( "Registration")
    public String regform(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        session.removeAttribute("result");
        return "Registration";
    }

    @RequestMapping(value = "Registration",method = RequestMethod.POST)
    public String registration(@ModelAttribute registration reg , HttpServletRequest req)
    {
        RegDb registration = new RegDb();
        registration.Registration(reg);
        HttpSession session = req.getSession();
        session.setAttribute("result", registration.result);
        return "popup";
    }

    //emergency

    @RequestMapping(value = "emergency",method = RequestMethod.POST)
    public String locationprocess(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        double latitude = Double.parseDouble(req.getParameter("latitude"));
        double longitude = Double.parseDouble(req.getParameter("longitude"));
        session.setAttribute("latitude",latitude);
        session.setAttribute("longitude",longitude);
        locationProcess v = new locationProcess(latitude,longitude);
        String username =""+session.getAttribute("username");
        if(username.equals(""))
        {
            new userEmergencyData(req.getParameter("name"), req.getParameter("mobile").toString());
        }
        else
        {
            try {
                String user = ""+session.getAttribute("username");
                Statement smt = db_connection.con.createStatement();//creating statement for executing the query
                ResultSet result = smt.executeQuery("select PRO.MEDWAY.MOBILE FROM PRO.MEDWAY WHERE MAIL_ID ='" + user + "'");//executing query
                String mobile = "" ;

                if (result.next())//retrieving password for particular username
                {
                    mobile = result.getString(1);
                }
                new userEmergencyData(user.toString(), mobile);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "map";
    }
}
