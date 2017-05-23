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
				System.out.println("�ļ����ǿյ�!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println("�ļ���:" + file2.getAbsolutePath());
						traverseFolder2(file2.getAbsolutePath());
					} else {
						System.out.println("�ļ�:" + file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("�ļ�������!");
		}
	}

	public static List<File> getFileList(String strPath) {
		List<File> filelist = new ArrayList<File>();
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // ���ļ�Ŀ¼���ļ�ȫ����������
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				if (files[i].isDirectory()) { // �ж����ļ������ļ���
					getFileList(files[i].getAbsolutePath()); // ��ȡ�ļ�����·��
				} else if (fileName.endsWith("avi")) { // �ж��ļ����Ƿ���.avi��β
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
