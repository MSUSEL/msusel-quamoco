/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import com.google.common.collect.Lists;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * An abstract representation of an Edge for the Quamoco
 * processing graph. In the Quamoco Graph, edges normalize the value of the
 * source and provide this normalized value to the dest.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
@EqualsAndHashCode(of = {"name"})
@ToString(of = {"name"})
public abstract class AbstractEdge implements Edge {

    /**
     * Incoming side of the edge
     */
    @Getter
    @Setter
    protected Node source;
    /**
     * Outgoing side of the edge
     */
    @Getter
    @Setter
    protected Node dest;
    /**
     * Normalizer attached to this edge
     * FIXME: should only be available on Normalizable Edges
     */
    @Getter
    @Setter
    protected Normalizer norm;
    /**
     * The next unique identification number for an edge
     */
    private static long NEXT_ID = 0;
    /**
     * Name of this edge
     */
    @Getter
    private final String name;
    /**
     * The unique identifying number for this edge
     */
    @Getter
    @Setter
    private long id;

    /**
     * Constructs a new MeasureToMeasureNumberEdge with the given name
     * connecting the source and dest nodes.
     *
     * @param name
     *            Name of this edge
     * @param source
     *            Source node
     * @param dest
     *            Dest node
     */
    AbstractEdge(final String name, final Node source, final Node dest) {
        this.name = name;
        id = AbstractEdge.NEXT_ID++;
        this.source = source;
        this.dest = dest;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Double> getValues() {
        final List<Double> list = Lists.newArrayList();
        list.add(getValue());

        return list;
    }

    /**
     * A value for any edge (after processing) should be in the range [0.0,1.0]
     * and thus any values outside of this must be made to conform to this
     * range. Thus this method takes a value and if this value is less than 0.0,
     * returns 0.0, or if the value is greater than 1.0, returns 1.0. Otherwise
     * it returns the original value.
     *
     * @param value
     *            Input value
     * @return 0.0 if the input value is less than 0.0, 1.0 if the input value
     *         is greater than 1.0, and the original value otherwise.
     */
    double thresholdValue(double value, double lower, double upper) {
        if (Double.compare(value, lower) < 0)
            return lower;

        if (Double.compare(value, upper) > 0)
            return upper;

        return value;
    }
}