package com.group.bodyBuilding.servlet.staff;

import com.group.bodyBuilding.dao.ApparatusDao;
import com.group.bodyBuilding.dao.UserDao;
import com.group.bodyBuilding.factory.Factory;
import com.group.bodyBuilding.vo.Apparatus;
import com.group.bodyBuilding.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.group.bodyBuilding.ReadCookie.ReadCookieMap;

public class ApparatusManageServlet_staff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*int flag = Integer.parseInt(req.getParameter("flag"));
        System.out.println(flag);*/
        ApparatusDao apparatusDao = Factory.getApparatusDao();
        List<Apparatus> apparatusList = new ArrayList<>();
        apparatusList = apparatusDao.apparatusList();

        req.setAttribute("apparatusList", apparatusList);
            /*for(int i = 0;i<userList.size();i++){
                System.out.println(userList.get(i).getuId());
            }*/
        req.getRequestDispatcher("/staff/apparatusManage.jsp").forward(req,resp);
    }
}
