package web.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.excel.util.FilesUtil;
import web.jdbc.ConnectionFactory;

public class InserDataMainTest {
	static String imgPath = "C:\\Users\\Administrator\\Desktop\\img";
	static String copyImgPath = "C:\\Users\\Administrator\\Desktop\\copyImg";
	static String excelPath = "C:\\Users\\Administrator\\Desktop\\carhome_data\\shop.xlsx";
	static String urlLocal = "jdbc:mysql://127.0.0.1:3306/car_home?"
			+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
	static String urlServer = "jdbc:mysql://192.168.1.75:3306/car_home?"
		+ "user=fina&password=111&useUnicode=true&characterEncoding=UTF8";
	public static void main(String[] args) {
		InputStream is;
		try {
			is = new FileInputStream(excelPath);
			List<Shop> list = ReadEecelCompatible.readExcelPureText(is);
			List<String> folderNames = FilesUtil.getFolderNames(imgPath);
//			FilesUtil.findError(list, folderNames);
			
			List<Shop> shopList=FilesUtil.folderAndImg(list, folderNames);
			Connection conn = ConnectionFactory.getConnection(urlLocal);
			insertBean(shopList,conn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入数据库
	 * 
	 * @param shopList
	 * @throws SQLException
	 *             2017-2-7 下午04:52:10
	 */
	public static void insertBean(List<Shop> shopList,Connection conn) throws SQLException {
		int i = 1;
		for (Shop shop : shopList) {
			String sql = "insert into tc_shop (id,rescue_service,repair_service,clean_service,maintain_service,tyre_service,"
					+ "shop_pic_url,shop_name,shop_score,shop_description,longtitude,latitude,province,city,district,"
					+ "detail_address,tel_number_list,display_pic_url_list,"
					+ "is_top,display_priority,delete_flag,insert_time,update_time) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0,0,now(),now())";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, shop.getId());
			state.setInt(2, shop.getRescueService());
			state.setInt(3, shop.getRepairService());
			state.setInt(4, shop.getCleanService());
			state.setInt(5, shop.getMaintainService());
			state.setInt(6, shop.getTyreService());
			state.setString(7, shop.getShopPicUrl());// 缩略图
			state.setString(8, shop.getShopName());
			state.setString(9, "0");
			state.setString(10, shop.getShopDescription());
			state.setString(11, shop.getLongtitude());
			state.setString(12, shop.getLatitude());

			state.setString(13, "辽宁省");
			state.setString(14, "阜新市");
			state.setString(15, shop.getDistrict());

			state.setString(16, shop.getDetailAddress());
			state.setString(17, shop.getTelNumberList());
			state.setString(18, shop.getDisplayPicUrlList());// 大图
			state.executeUpdate();
			//插入服务表
			inserService(shop,conn);
			//插入救援表
			if (shop.getRescueService() != 0){
				inserSecue(shop,conn);
			}
			System.out.println("插入shop："+shop.getShopName()+"--" + i);
			i++;
		}
	}
	//插入救援表
	public static void inserSecue(Shop shop,Connection conn) throws SQLException{
		String tcRescue = "insert into tb_rescue "
			+ "(id,shop_id,type_value,experience,head_portrait_url,product_description,"
			+ "delete_flag,update_time,insert_time) values (?,?,?,?,?,?,0,now(),now())";
		PreparedStatement state3 = conn.prepareStatement(tcRescue);
		state3.setString(1,ReadEecelCompatible.getUUID());
		state3.setString(2, shop.getId());
		state3.setString(3, "1,2,3,4,5");
		state3.setString(4, "5");
		state3.setString(5, shop.getShopPicUrl());
		state3.setString(6, shop.getManageProject());
		state3.executeUpdate();
	}
	//插入服务表
	public static void inserService(Shop shop,Connection conn) throws SQLException{
		int a=1;
		List<Integer> serviceList = new ArrayList<Integer>();
		if (shop.getRepairService() != 0)
			serviceList.add(5100);
		if (shop.getCleanService() != 0)
			serviceList.add(4100);
		if (shop.getMaintainService() != 0)
			serviceList.add(6100);
		if (shop.getTyreService() != 0)
			serviceList.add(7100);
		for (Integer ser : serviceList) {//插入服务表
			String tcService = "insert into tc_service "
					+ "(id,shop_id,service_type,service_brands_url,delete_flag,update_time,insert_time) "
					+ "values (?,?,?,?,0,now(),now())";
			PreparedStatement state2 = conn.prepareStatement(tcService);
			state2.setString(1,ReadEecelCompatible.getUUID());
			state2.setString(2, shop.getId());
			state2.setInt(3, ser);
			state2.setString(4, null);
			state2.executeUpdate();
			System.out.println("插入tc_service:"+a);
			a++;
		}
	}
	
}
