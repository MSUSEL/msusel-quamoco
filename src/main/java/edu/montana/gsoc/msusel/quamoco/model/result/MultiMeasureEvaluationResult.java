/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.quamoco.model.result;

import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class MultiMeasureEvaluationResult extends EvaluationResult {

    @Getter
    private List<MeasureRankingEvaluationResult> results;

    /**
     * @param identifier
     */
    @Builder(buildMethodName = "create")
    public MultiMeasureEvaluationResult(String identifier, Evaluation resultFrom, DoubleInterval value, @Singular List<MeasureRankingEvaluationResult> results) {
        super(identifier, resultFrom, value);
        this.results = results;
    }

    public void addResult(MeasureRankingEvaluationResult result) {
        if (result == null || results.contains(result))
            return;

        results.add(result);
    }

    public void removeResult(MeasureRankingEvaluationResult result) {
        if (result == null || !results.contains(result))
            return;

        results.remove(result);
    }
}