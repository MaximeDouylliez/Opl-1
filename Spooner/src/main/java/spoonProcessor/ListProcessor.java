package spoonProcessor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.declaration.ModifierKind;

import java.util.LinkedList;
import java.util.Set;


public class ListProcessor extends AbstractProcessor<CtVariable> {

    /**
     * TODO
     *
     * @param element Read all CtVariables
     */
    public void process(CtVariable element) {


        if (("LinkedList").equals(element.getDefaultExpression().getType().getSimpleName())) {
            change(element, "Lists.newLinkedList()");
        } else if (("ArrayList").equals(element.getDefaultExpression().getType().getSimpleName())) {
            change(element, "Lists.newArrayList()");
        }
    }

    /**
     * TODO
     *
     * @param element CtVariables
     * @param s       Substitution String
     */
    public void change(CtVariable element, String s) {
        Set<ModifierKind> modifiers = element.getModifiers();

        if (modifiers.contains(ModifierKind.PUBLIC)
                && modifiers.contains(ModifierKind.STATIC)
                && modifiers.contains(ModifierKind.FINAL)) {
           s = "Lists.ImmutableList.of()";
        }

        System.out.println("§ " + element.getDefaultExpression() + " -> " + s);//TODO Debug

        CtExpression<LinkedList<java.lang.String>> value = getFactory().Code().createCodeSnippetExpression(s);
        CtExpression exp = element.getDefaultExpression();
        exp.replace(value);
    }


}