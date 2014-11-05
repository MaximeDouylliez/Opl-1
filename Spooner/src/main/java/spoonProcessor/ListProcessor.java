package spoonProcessor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtVariable;

import java.util.LinkedList;


public class ListProcessor extends AbstractProcessor<CtVariable> {

    private int infArrayChange = 0;
    private int infLinkedListChange = 0;


    /**
     * detect ArrayList and LinkedList instantiations
     *
     * @param element Read all CtVariables
     */
    public void process(CtVariable element) {
        String imp ="com.google.common.collect.";

        if (element.getDefaultExpression() != null){
        String SElement = element.getDefaultExpression().getType().getSimpleName();
        if (("LinkedList").equals(SElement)) {
            change(element, imp+"Lists.newLinkedList()");
        } else if (("ArrayList").equals(SElement)) {
            change(element, imp+"Lists.newArrayList()");
        }
    }}

    /**
     * @param element CtVariables
     * @param s       Substitution String
     */
    public void change(CtVariable element, String s) {
        System.out.println("§ " + element.getDefaultExpression() + " -> " + s);//Debug

        if (("Lists.newLinkedList()").equals(s)){infLinkedListChange++;}
        else if(("Lists.newArrayList()").equals(s)){infArrayChange++;}
        CtExpression<LinkedList<java.lang.String>> value = getFactory().Code().createCodeSnippetExpression(s);
        CtExpression exp = element.getDefaultExpression();
        exp.replace(value);
    }

    public int getInfArrayChange() {

        return infArrayChange;
    }

    public int getInfLinkedListChange() {
        return infLinkedListChange;
    }
}