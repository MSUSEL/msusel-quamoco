/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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

import com.sparqline.codetree.INode;

/**
 * A Finding is simply a report that a static analysis rule was triggered at
 * some point within a system. Typically, findings are negative indicators of
 * quality. Each finding is associated with a issue key and name and the
 * location in the CodeTree in which the rule was triggered.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Finding {

    /**
     * Location in the CodeTree where the Finding was found
     */
    private INode  location;
    /**
     * Associated Issue Key (Rule Key) to which this finding belongs
     */
    private String issueKey;
    /**
     * Simple name of the issue to which this finding belongs.
     */
    private String issueName;

    /**
     * Constructs a new Finding for the given issue key and name at the given
     * location in the CodeTree
     * 
     * @param location
     *            Location
     * @param issueKey
     *            Issue Key
     * @param issueName
     *            Issue Name
     */
    public Finding(final INode location, final String issueKey, final String issueName)
    {
        if (location == null || issueKey == null || issueKey.isEmpty() || issueName == null || issueName.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.location = location;
        this.issueKey = issueKey;
        this.issueName = issueName;
    }

    /**
     * @return the CodeTree location of the activated issue
     */
    public INode getLocation()
    {
        return location;
    }

    /**
     * @param location
     *            the new location of the activated issue
     */
    public void setLocation(final INode location)
    {
        if (location == null)
        {
            return;
        }

        this.location = location;
    }

    /**
     * @return the key of the activate issue
     */
    public String getIssueKey()
    {
        return issueKey;
    }

    /**
     * @param issueKey
     *            the new key of the activated issue
     */
    public void setIssueKey(final String issueKey)
    {
        if (issueKey == null || issueKey.isEmpty())
        {
            return;
        }

        this.issueKey = issueKey;
    }

    /**
     * @return the name of the activated issue
     */
    public String getIssueName()
    {
        return issueName;
    }

    /**
     * @param issueName
     *            the new name of the activated issue
     */
    public void setIssueName(final String issueName)
    {
        if (issueName == null || issueName.isEmpty())
        {
            return;
        }

        this.issueName = issueName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (issueKey == null ? 0 : issueKey.hashCode());
        result = prime * result + (issueName == null ? 0 : issueName.hashCode());
        result = prime * result + (location == null ? 0 : location.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Finding))
        {
            return false;
        }
        final Finding other = (Finding) obj;
        if (issueKey == null)
        {
            if (other.issueKey != null)
            {
                return false;
            }
        }
        else if (!issueKey.equals(other.issueKey))
        {
            return false;
        }
        if (issueName == null)
        {
            if (other.issueName != null)
            {
                return false;
            }
        }
        else if (!issueName.equals(other.issueName))
        {
            return false;
        }
        if (location == null)
        {
            if (other.location != null)
            {
                return false;
            }
        }
        else if (!location.equals(other.location))
        {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "Finding [location=" + location.toString() + ", issueKey=" + issueKey + ", issueName=" + issueName + "]";
    }
}
