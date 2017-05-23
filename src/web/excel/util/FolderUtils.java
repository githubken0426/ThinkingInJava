package web.excel.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderUtils {
	public void traverseFolder2(String path) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println("文件夹:" + file2.getAbsolutePath());
						traverseFolder2(file2.getAbsolutePath());
					} else {
						System.out.println("文件:" + file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}

	public static List<File> getFileList(String strPath) {
		List<File> filelist = new ArrayList<File>();
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
				} else if (fileName.endsWith("avi")) { // 判断文件名是否以.avi结尾
					String strFileName = files[i].getAbsolutePath();
					System.out.println("---" + strFileName);
					filelist.add(files[i]);
				} else {
					continue;
				}
			}

		}
		return filelist;
	}
}
