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
package edu.montana.gsoc.msusel.quamoco.model.result;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Isaac Griffith
 *
 */
public class SystemDescriptor {

    private String name;
    private String identifier;
    private String version;
    private String analysisDate;
    
    /**
     * 
     */
    public SystemDescriptor(String name, String version)
    {
        this(name, version, new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(LocalDateTime.now()));
    }
    
    public SystemDescriptor(String name, String version, String date) {
        this(name, version, date, UUID.randomUUID().toString());
    }
    
    public SystemDescriptor(String name, String version, String date, String identifier) {
        this.name = name;
        this.version = version;
        this.analysisDate = date;
        this.identifier = identifier;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }

    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * @return the analysisDate
     */
    public String getAnalysisDate()
    {
        return analysisDate;
    }
}
