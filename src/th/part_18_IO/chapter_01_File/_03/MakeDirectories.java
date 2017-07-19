package th.part_18_IO.chapter_01_File._03;

import java.io.File;

public class MakeDirectories {
	private static void usage() {
		System.out.println("test");
		System.exit(1);
	}

	/**
	 * 
	 * @param file
	 * @throws @date
	 * 2017年7月18日 下午5:52:46
	 */
	private static void fillData(File file) {
		System.out.println("f.getAbsolutePath:" + file.getAbsolutePath() + "f.getPath:" + file.getPath()
				+ "\n Can read:" + file.canRead() + "\n Can write:" + file.canWrite() + "\n f.getName:" + file.getName()
				+ "\n f.getParent:" + file.getParent() + "\n f.getLength:" + file.length() + "\n f.lastModified:"
				+ file.lastModified());
		if (file.isFile())
			System.out.println("It is a File");
		else if (file.isDirectory())
			System.out.println("It is a Directory");
	}

	public static void main(String[] args) {
		String[]paths= {"F:\\text1.txt","F:\\text2.txt"};
		int count = -1;
		while (++count < paths.length) {
			File f = new File(paths[count]);
			fillData(f);
		}
	}

	public static void test(String[] args) {
		if (args.length < 1)
			usage();
		if (args[0].equals("-r")) {
			if (args.length != 3)
				usage();
			File old = new File(args[1]), rname = new File(args[2]);
			old.renameTo(rname);
			fillData(old);
			fillData(rname);
			return;
		}
		int count = 0;
		boolean del = false;
		if (args[0].equals("-d")) {
			count++;
			del = true;
		}
		count--;
		while (++count < args.length) {
			File f = new File(args[count]);
			if (f.exists()) {
				System.out.println(f + " exists");
				if (del) {
					f.delete();
					System.out.println("delete f" + f);
				}
			} else {
				if (!del) {
					f.mkdirs();
					System.out.println("Create f" + f);
				}
			}
			fillData(f);
		}
	}
}
