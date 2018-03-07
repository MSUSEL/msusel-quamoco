package edu.montana.gsoc.msusel.quamoco.distiller;

import edu.montana.gsoc.msusel.quamoco.graph.edge.*;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;

public class EdgeFactory {

    private EdgeFactory() {

    }

    private static final class Holder {
        public static final EdgeFactory INSTANCE = new EdgeFactory();
    }

    public static EdgeFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Edge createEdge(QMElement source, QMElement dest, DistillerData data) {
        if (source instanceof MeasurementMethod) {
            if (dest instanceof Measure) {
                return createProviderToMeasureEdge((MeasurementMethod) source, (Measure) dest, data);
            }
        } else if (source instanceof Measure) {
            if (dest instanceof Measure) {
                return createMeasureToMeasureEdge((Measure) source, (Measure) dest, data);
            } else if (dest instanceof Factor) {
                return createMeasureToFactorEdge((Measure) source, (Factor) dest, data);
            }
        } else if (source instanceof Factor) {
            if (dest instanceof Factor) {
                return createFactorToFactorEdge((Factor) source, (Factor) dest, data);
            }
        }

        return null;
    }

    private Edge createFactorToFactorEdge(Factor source, Factor target, DistillerData data) {
        Node src = data.getFactor(source);
        Node dest = data.getFactor(target);
        if (src != null && dest != null)
            return new FactorToFactorEdge(source.getName() + ":" + target.getName(), src, dest, source.getInfluenceOn(target));
        return null;
    }

    private Edge createMeasureToFactorEdge(Measure source, Factor target, DistillerData data) {
        Node src = data.getMeasure(source);
        Node dest = data.getFactor(target);

        if (src != null && dest != null) {
            if (source.getType() == MeasureType.FINDINGS) {
                return new MeasureToFactorFindingsEdge(source.getName() + ":" + target.getName(),
                        src, dest, InfluenceEffect.POSITIVE);
            } else {
                return new MeasureToFactorNumberEdge(source.getName() + ":" + target.getName(),
                        src, dest, InfluenceEffect.POSITIVE);
            }
        }

        return null;
    }

    private Edge createMeasureToMeasureEdge(Measure source, Measure target, DistillerData data) {
        Node src = data.getMeasure(source);
        Node dest = data.getMeasure(target);

        if (src != null && dest != null) {
            if (source.getType().equals(MeasureType.FINDINGS) && target.getType().equals(MeasureType.FINDINGS))
            {
                return new MeasureToMeasureFindingsEdge(source.getName() + ":" + target.getName(), src, dest);
            }
            else if (source.getType().equals(MeasureType.NUMBER) && target.getType().equals(MeasureType.NUMBER))
            {
                new MeasureToMeasureNumberEdge(source.getName() + ":" + target.getName(), src, dest);
            }
            else
            {
                new MeasureToMeasureFindingsNumberEdge(source.getName() + ":" + target.getName(), src, dest);
            }
        }

        return null;
    }

    private Edge createProviderToMeasureEdge(MeasurementMethod source, Measure target, DistillerData data) {
        Node src = data.getValue(source);
        if (src == null)
            src = data.getUnion(source);
        System.out.println("Node: " + source.getName() + " Determines: " + source.getDetermines().getName());
        if (src != null) {
            if (src instanceof ValueNode) {
                return new ValueToMeasureEdge(source.getName() + ":" + target.getName(), src, data.getMeasure(target));
            } else {
                return new FindingToMeasureEdge(source.getName() + ":" + target.getName(), src, data.getMeasure(target));
            }
        }
        return null;
    }
}
