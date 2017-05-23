package th.part_20_Annotation.chapter_03;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

public class InterfaceExtractorProcessor implements AnnotationProcessor {
	private AnnotationProcessorEnvironment env;
	private List<MethodDeclaration> list=new ArrayList<MethodDeclaration>();
	
	public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env){
		this.env=env;
	}
	@Override
	public void process() {
		for(TypeDeclaration typeDec :env.getSpecifiedTypeDeclarations()){
			ExtractInterface ext=typeDec.getAnnotation(ExtractInterface.class);
			if(ext==null)
				break;
			for(MethodDeclaration m:typeDec.getMethods()){
				if(m.getModifiers().contains(Modifier.PUBLIC)&&(!m.getModifiers().contains(Modifier.STATIC)))
					list.add(m);
			}
			if(list.size()>0){
				try {
					PrintWriter writer=env.getFiler().createSourceFile(ext.value());
					writer.print("package"+typeDec.getPackage().getQualifiedName());
					writer.print("public interface "+ext.value()+"{");
					for(MethodDeclaration m: list){
						writer.print(" public "+m.getReturnType()+" ");
						writer.print(m.getSimpleName()+" (");
						int i=0;
						for(ParameterDeclaration parm:m.getParameters()){
							writer.print(parm.getType()+" "+parm.getSimpleName());
							if(++i<m.getParameters().size())
								writer.print(", ");
						}
						writer.print(")");
					}
					writer.print("}");
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				
			}
		}
	}

}
