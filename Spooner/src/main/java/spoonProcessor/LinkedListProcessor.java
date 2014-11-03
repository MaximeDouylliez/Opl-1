package spoonProcessor;

import com.google.common.collect.Lists;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtVariable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//import com.google.common.collect.*

public class LinkedListProcessor extends AbstractProcessor<CtVariable<java.util.LinkedList<java.lang.String>>> {


    public List<CtVariable<java.util.LinkedList<java.lang.String>>> toConvert = new ArrayList();


    public void process(CtVariable<java.util.LinkedList<java.lang.String>> element) {


        LinkedList<String> transformation = Lists.newLinkedList();
        transformation.add(new String("Lists.newLinkedList()"));
       // System.out.println(transformation);
        //exp.replace(new CtExpression(transformation));
		CtExpression<LinkedList<String>> exp=element.getDefaultExpression();
        System.out.println("t||"+exp);
		exp.set("Lists.newLinkedList()");

       // System.out.println(element.getSimpleName() + " " + element.getDefaultExpression() + "\n");

    }

    /**
     *
     */
    @Override
    public void processingDone() {
        String simpleName, body;
        char header;
        super.processingDone();

    }
}

	

