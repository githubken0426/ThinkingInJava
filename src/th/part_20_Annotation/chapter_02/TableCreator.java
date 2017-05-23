package th.part_20_Annotation.chapter_02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import th.part_20_Annotation.chapter_01_Base._03.Constraints;
import th.part_20_Annotation.chapter_01_Base._03.DBTable;
import th.part_20_Annotation.chapter_01_Base._03.SQLInteger;
import th.part_20_Annotation.chapter_01_Base._03.SQLString;

public class TableCreator {
	
	public static String getConstraints(Constraints con){
		String constraints="";
		if(!con.allowNull()){
			constraints+="Not Null";
		}
		if(con.primaryKey()){
			constraints+="primaryKey";
		}
		if(!con.unique()){
			constraints+="unique";
		}
		return constraints;
	}
	
	static String className="th.part_20_Annotation.chapter_01_Base._03.DBTable";
	/**
	 * forName(全限定类名)
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws Exception{
//		if(args.length<1){
//			System.out.println("arguments:annotated classes ");
//			System.exit(0);
//		}
		Class<?> cl=Class.forName(className);
		DBTable t =(DBTable) cl.newInstance();
		DBTable table=cl.getAnnotation(DBTable.class);
		if(table==null){
			System.out.println("no datable in classes"+className);
			System.exit(0);
		}
		String tableName=table.name();
		if(tableName.length()<1){
			tableName=cl.getName().toUpperCase();
		}
		List<String> colunmDefs=new ArrayList<String>();
		for (Field field : cl.getDeclaredFields()) {
			String columName=null;
			Annotation ann[]=field.getDeclaredAnnotations();
			if(ann.length<1)
				continue;
			if(ann[0] instanceof SQLInteger){
				SQLInteger sInt=(SQLInteger) ann[0];
				if(sInt.name().length()<1)
					columName=field.getName().toUpperCase();
				else
					columName=sInt.name();
				colunmDefs.add(columName+" INT "+getConstraints(sInt.constraints()));
			}
			if(ann[0] instanceof SQLString){
				SQLString sString=(SQLString) ann[0];
				if(sString.name().length()<1)
					columName=field.getName().toUpperCase();
				else
					columName=sString.name();
				colunmDefs.add(columName+" varchar( "+sString.value()+")"+getConstraints(sString.constraints()));
			}
			StringBuilder sb=new StringBuilder("Create Table "+tableName+"(");
			for (String colunm : colunmDefs) {
				sb.append("\n "+colunm+",");
			}
			String tableCreate=sb.substring(0,sb.length()-1)+")";
			System.out.println("Table create SQL for:"+className+" is:\n"+tableCreate);
		}
	}
}
