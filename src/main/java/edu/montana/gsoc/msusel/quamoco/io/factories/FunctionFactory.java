package edu.montana.gsoc.msusel.quamoco.io.factories;

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearDecreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearIncreasingFunction;
import org.w3c.dom.Element;

public class FunctionFactory extends AbstractQMElementFactory {

    private FunctionFactory() {
        super();
    }

    private final static class Holder {

        public static final FunctionFactory INSTANCE = new FunctionFactory();
    }
    public static FunctionFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public QMElement create(Element e, ModelManager manager) {
        Function function = null;
        this.manager = manager;

        if (e.hasAttribute("xsi:type"))
        {
            FunctionType type = FunctionType.fromType(e.getAttribute("xsi:type"));
            switch (type) {
                case LINEAR_INCREASING:
                    function = createLinearIncreasingFunction(e);
                    break;
                case LINEAR_DECREASING:
                    function = createLinearDecreasingFunction(e);
                    break;
            }
        }

        return function;
    }

    private Function createLinearDecreasingFunction(Element e) {
        return LinearDecreasingFunction.builder()
                .identifier(e.getAttribute("xmi:id"))
                .lowerBound(e.hasAttribute("lowerBound") ? Double.valueOf(e.getAttribute("lowerBound")) : 0.0)
                .upperBound(e.hasAttribute("upperBound") ? Double.valueOf(e.getAttribute("upperBound")) : 1.0)
                .create();
    }

    private Function createLinearIncreasingFunction(Element e) {
        return LinearIncreasingFunction.builder()
                .identifier(e.getAttribute("xmi:id"))
                .lowerBound(e.hasAttribute("lowerBound") ? Double.valueOf(e.getAttribute("lowerBound")) : 0.0)
                .upperBound(e.hasAttribute("upperBound") ? Double.valueOf(e.getAttribute("upperBound")) : 1.0)
                .create();
    }
}
