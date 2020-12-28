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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import edu.isu.isuese.datamodel.Component;
import edu.isu.isuese.datamodel.Measurable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * A Finding is simply a report that a static analysis rule was triggered at
 * some point within a system. Typically, findings are negative indicators of
 * quality. Each finding is associated with a issue key and name and the
 * location in the CodeTree in which the rule was triggered.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
@EqualsAndHashCode
@ToString
public abstract class Finding {

    static long idnum = 0;

    private long identifier;

    /**
     * Associated Issue Key (Rule Key) to which this finding belongs
     */
    @Getter
    private String issueKey;
    /**
     * Simple name of the issue to which this finding belongs.
     */
    @Getter
    private String issueName;

    /**
     * Constructs a new Finding for the given issue key and name at the given
     * location in the CodeTree
     *
     * @param issueKey  Issue Key
     * @param issueName Issue Name
     */
    public Finding(final String issueKey, final String issueName) {
        if (issueKey == null || issueKey.isEmpty() || issueName == null || issueName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.identifier = ++idnum;
        this.issueKey = issueKey;
        this.issueName = issueName;
    }

    /**
     * @param issueKey the new key of the activated issue
     */
    public void setIssueKey(final String issueKey) {
        if (issueKey == null || issueKey.isEmpty()) {
            return;
        }

        this.issueKey = issueKey;
    }

    /**
     * @param issueName the new name of the activated issue
     */
    public void setIssueName(final String issueName) {
        if (issueName == null || issueName.isEmpty()) {
            return;
        }

        this.issueName = issueName;
    }

    public abstract Measurable getLocation();
}
