package rtf.rshop.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import rtf.rshop.dao.impl.HibernateUtil;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RDistrict;
import rtf.rshop.po.RManager;
import rtf.rshop.po.RProType;
import rtf.rshop.po.RProvince;

public class Installer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("开始安装。。。");
		Session session = HibernateUtil.getSession() ;
		//initRProType(session);
		//initRManager(session);
		copyAddress(session);
		HibernateUtil.closeSession(session);
		System.out.println("安装结束");
		System.exit(0);
	}
	private static void initRProType(Session session){
		Transaction ts = session.beginTransaction() ;
		RProType type= new RProType();
		type.setName("所有商品");
		type.setCode("all");
		type.setParent(type);
		type.setDescribe("所有商品");
		session.save(type);
		ts.commit();
	}
	private static void initRManager(Session session){
		Transaction ts = session.beginTransaction();
		RManager manager = new RManager() ;
		manager.setLoginname("admin");
		manager.setPassword("admin123");
		session.save(manager);
		ts.commit();
	}
	
	private static void copyAddress(Session session){
		List<RProvince> province_list = new ArrayList<RProvince>();
		String url = "jdbc:mysql://localhost:3306/novel?user=root&password=rentongfu" ;
		String sql1 = "select provinceID,province from province" ;
		String sql2 = "select cityID , city from city where city.fatherID=?" ;
		String sql3 = "select areaID , area from area where area.fatherID=?" ;
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("连接数据库成功");
			Statement stmt = conn.createStatement();
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			ResultSet rs =  stmt.executeQuery(sql1);
			while (rs.next()){
				RProvince province = new RProvince();
				
				province.setCode(""+ rs.getInt("provinceID"));
				province.setName(rs.getString("province"));
				System.out.println("------------"+province.getName());
				List<RCity> city_list = new ArrayList<RCity>();
				pstmt2.setInt(1, rs.getInt("provinceID"));
				ResultSet rs2= pstmt2.executeQuery();
				while(rs2.next()){
					RCity city = new RCity();
					
					city.setCode(""+rs2.getInt("cityID"));
					city.setName(rs2.getString("city"));
					city.setProvince(province);
					System.out.println("++++++" + city.getName());
					List<RDistrict> district_list = new ArrayList<RDistrict>();
					pstmt3.setInt(1,rs2.getInt("cityID"));
					ResultSet rs3 = pstmt3.executeQuery();
					while(rs3.next()){
						RDistrict district = new RDistrict();
						district.setName(rs3.getString("area"));
						System.out.println(district.getName());
						district.setCode(""+rs3.getInt("areaID"));
						district.setCity(city);
						district_list.add(district);
					}
					city.setDistricts(district_list);
					
					city_list.add(city);
				}
				province.setCities(city_list);
				
				province_list.add(province);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据获取完毕");
		Transaction trans = session.beginTransaction();
		for(RProvince province: province_list){
			session.save(province);
		}
		trans.commit();
		
	}

}
