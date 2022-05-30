package com.javaex.dao;
import java.util.*;
import com.javaex.vo.*;

public class TestApp {
	public static void main(String[] args) {
		GuestBookDao gDao = new GuestBookDao();
		List<GuestVo> gList = gDao.getList();
		
		GuestVo gVo = gDao.getGuest(777);
		
		System.out.println(gList);
		System.out.println(gVo);
	}
}
