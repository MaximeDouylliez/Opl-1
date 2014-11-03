package spoonProcessor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtVariable;

import java.util.LinkedList;

public class LinkedListProcessor extends AbstractProcessor<CtVariable> {


    public void process(CtVariable element) {
        if (("LinkedList").equals(element.getDefaultExpression().getType().getSimpleName())) {
            CtExpression<LinkedList<java.lang.String>> value = getFactory().Code().createCodeSnippetExpression("Lists.newLinkedList()");
            CtExpression exp = element.getDefaultExpression();
            exp.replace(value);
        }
    }
}