package web.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import web.excel.Shop;

public final class FilesUtil {
	static String imgPath = "C:\\Users\\Administrator\\Desktop\\img";
	static String copyImgPath = "C:\\Users\\Administrator\\Desktop\\copyImg";

	/**
	 * 数据对应不上
	 * 
	 * @param list
	 * @param folderNames
	 *            2017-2-9 上午10:08:01
	 */
	public static void findError(List<Shop> list, List<String> folderNames) {
		List<String> result = new ArrayList<String>();
		for (String folder : folderNames) {
			for (Shop shop : list) {
				String shopName = shop.getShopName();
				boolean boo = (shopName != null && shopName != "") ? shopName
						.equals(folder) : false;
				if (boo)// 把excel和folder相同的添加进来
					result.add(folder);
			}
		}
		folderNames.removeAll(result);// folder中去除相同项，返回不同项
		System.out.println(folderNames);
	}

	/**
	 * 读取图片信息
	 * 
	 * @param list
	 * @param folderNames
	 *            2017-2-7 下午04:51:30
	 */
	public static List<Shop> folderAndImg(List<Shop> list,
			List<String> folderNames) {
		List<Shop> result = new ArrayList<Shop>();
		// 创建图片文件夹(店铺uuid/detail(thumbnail)/img.jpg img2.jpg img3.jpg)
		String bigImg = File.separator + "大图";
		String smallImg = File.separator + "缩略图";
		String detail = File.separator + "detail";
		String thumbnail = File.separator + "thumbnail";
		for (Shop shop : list) {
			//Collection的toString()方法，默认会加上空格，需要重写
			List<String> small = new ArrayList<String>() {
				@Override
				public String toString() {
					StringBuffer buf = new StringBuffer();
					Iterator<String> i = iterator();
					boolean hasNext = i.hasNext();
					while (hasNext) {
						String o = i.next();
						buf.append(o);
						hasNext = i.hasNext();
						if (hasNext)//源码有空格，buf.append(", ");
							buf.append(",");
					}
					return buf.toString();
				}
			};
			List<String> bigger = new ArrayList<String>() {
				@Override
				public String toString() {
					StringBuffer buf = new StringBuffer();
					Iterator<String> i = iterator();
					boolean hasNext = i.hasNext();
					while (hasNext) {
						String o = i.next();
						buf.append(o);
						hasNext = i.hasNext();
						if (hasNext)
							buf.append(",");
					}
					return buf.toString();
				}
			};
			String shopName = shop.getShopName();
			for (String folder : folderNames) {
				boolean boo = (shopName != null && shopName != "") ? shopName
						.equals(folder) : false;
				if (boo) {
					String wrriteDetail = copyImgPath + File.separator
							+ shop.getId() + detail;// 大图
					File writeDetailFile = new File(wrriteDetail);
					writeDetailFile.mkdirs();

					String readDetail = imgPath + File.separator + folder
							+ bigImg;
					File readDetailFile = new File(readDetail);
					File readDetailFiles[] = readDetailFile.listFiles();
					for (File file : readDetailFiles) {
						String fileName = file.getName();
						wrriteDetail = copyImgPath + File.separator
								+ shop.getId() + detail + File.separator
								+ fileName;// 写入的图片地址
						bigger.add((File.separator + "carhome" + File.separator
								+ "shop" + File.separator + shop.getId()
								+ detail + File.separator + fileName).trim());// 数据库存入相对地址
						readDetail = imgPath + File.separator + folder + bigImg
								+ File.separator + fileName;
						copyFile(readDetail, wrriteDetail);
					}

					String writeThumbnail = copyImgPath + File.separator
							+ shop.getId() + thumbnail;// 缩略图
					File writeThumbnailFile = new File(writeThumbnail);
					writeThumbnailFile.mkdirs();
					String readThumbnail = imgPath + File.separator + folder
							+ smallImg;
					File readThumbnailFile = new File(readThumbnail);
					File readThumbnailFiles[] = readThumbnailFile.listFiles();
					for (File file : readThumbnailFiles) {
						String fileName = file.getName();
						writeThumbnail = copyImgPath + File.separator
								+ shop.getId() + thumbnail + File.separator
								+ fileName;// 写入的缩略图图片地址
						small.add(File.separator + "carhome" + File.separator
								+ "shop" + File.separator + shop.getId()
								+ thumbnail + File.separator + fileName);// 数据库存入相对地址
						readThumbnail = imgPath + File.separator + folder
								+ smallImg + File.separator + fileName;
						copyFile(readThumbnail, writeThumbnail);
					}
				}
			}
			String sl = small.toString();
			String be = bigger.toString();
			shop.setShopPicUrl(sl);
			shop.setDisplayPicUrlList(be);
			result.add(shop);
		}
		return result;
	}

	// 获取img下的文件夹名称集合
	public static List<String> getFolderNames(String path) {
		List<String> list = new ArrayList<String>();
		File file = new File(path);
		for (File f : file.listFiles()) {
			if (f.isDirectory())
				list.add(f.getName());
		}
		return list;
	}

	/**
	 * 复制文件
	 * 
	 * @param src
	 * @param target
	 *            2017-2-7 下午04:10:45
	 */
	public static void copyFile(String src, String target) {
		File srcFile = new File(src);
		File targetFile = new File(target);
		try {
			InputStream in = new FileInputStream(srcFile);
			OutputStream out = new FileOutputStream(targetFile);
			byte[] bytes = new byte[1024];
			int len = -1;
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "";
	}

	public static void main(String[] args) {
		String str = Arrays.asList("1,2,3,4,5".split(",")).toString();
		System.out.println(str.substring(str.indexOf("[") + 1, str
				.lastIndexOf("]")));
	}
}
