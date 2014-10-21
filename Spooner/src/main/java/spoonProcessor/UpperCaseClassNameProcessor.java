package main.java.spoonProcessor;

import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.processing.Severity;
import spoon.reflect.code.CtCatch;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.factory.CodeFactory;
import spoon.reflect.factory.Factory;

/**
 * Reports warnings when empty catch blocks are found.
 */
public class UpperCaseClassNameProcessor extends AbstractProcessor<CtClass> {

	public List<CtClass> badNamedCLass = new ArrayList<CtClass>();

	// detect class name with a lower case as first character
	public void process(CtClass element) {
		String className = element.getSimpleName();
		if (!Character.isUpperCase(className.charAt(0))) {
			badNamedCLass.add(element);
		}

	}

	/**
	 * Display to user class without upper case as a first character & generate valid class
	 */
	@Override
	public void processingDone() {
		String simpleName, body;
		char header;
		super.processingDone();
		for (CtClass cc : badNamedCLass) {
			// parse class name
			simpleName = cc.getSimpleName();
			header = simpleName.charAt(0);
			body = (String) simpleName.subSequence(1, simpleName.length());

			getFactory().getEnvironment().report(this,Severity.WARNING,cc,cc.getQualifiedName()
						+ " does not begin with an uppercase.\n Valid class  will be generated");
			
			//modify name in meta model to generate a valid class
			cc.setSimpleName(Character.toUpperCase(header) + body);
		}
	}
}
