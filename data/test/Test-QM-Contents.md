# Quality Model

---

~~Model Name: Test~~

## Entities

---

* ~~Comment~~
  - ~~Is A: Product Part~~
  - ~~Originates From: Test Source~~
  - ~~Tags: Test Tag~~
* Product
  - Consists Of: Product Part, Source Code
  - ~~Originates From: Test Source~~
  - Characterized By: Mean, Quality
* Product Part
  - Specialized By: Comment, Source Code Part
  - ~~Part Of: Product~~
  - ~~Originates From: Test Source~~
  - Characterized By: Parent
* Source Code
  - ~~Part Of: Product~~
  - Consists Of: Source Code Part
  - ~~Originates From: Test Source~~
* Source Code Part
  - ~~Is A: Product Part~~
  - ~~Part Of: Source Code~~
  - ~~Originates From: Test Source~~
  - Characterized By: Quality, Test Measure, Test Normalization

## Factors

---

* Maintainability
  - ~~Title: Test Maintainability~~
  - ~~Description: Test for Maintainability~~
  - Completeness: 100.0
  - Evaluated By: Test/Maintainability/SingleMeasureEvaluation
  - ~~Originates From: Test Source~~
  - Measured By: Test Measure @Source Code Part
  - ~~Influences: Quality @Product, Quality @Source Code Part~~
  - ~~Tagged By: Test Tag~~
* Quality @Product
  - ~~Title: Software Quality~~
  - ~~Description: Product Quality~~
  - ~~Characterizes: Product~~
  - Completeness: 100.0
  - Refined By: Quality @Source Code Part
  - Evaluated By: Test/Quality @Product/WeightedSumFactorAggregation
  - ~~Originates From: Test Source~~
  - Influenced By: Maintainability, Security
  - ~~Tagged By: Test Tag~~
* Quality @Source Code Part
  - ~~Description: Source Code Part Quality~~
  - ~~Characterizes: Source Code Part~~
  - Completeness: 100.0
  - ~~Refines: Quality @Product~~
  - Evaluated By: Test/Quality @Source Code Part/WeightedSumFactorAggregation
  - ~~Originates From: Test Source~~
  - Influenced By: Maintainability, Security
  - ~~Tagged By: Test Tag~~
* Security
  - ~~Description: Security~~
  - Completeness: 100.0
  - Evaluated By: Test/Security/SingleMeasureEvaluation
  - ~~Originates From: Test Source~~
  - Measured By: Test Measure @Source Code Part
  - ~~Influences: Quality @Product, Qualilty @Source Code Part~~
  - ~~Tagged By: Test Tag~~

## ~~Evaluations~~

---

* ~~Test/Maintainability/SingleMeasureEvaluation~~
  - ~~Title:~~
  - ~~Description: Test evaluation for maintainability~~
  - ~~Originates From: Test Source~~
  - ~~Completeness: 100~~
  - ~~Maximum Points: 100~~
  - ~~Tagged By: Test Tag~~
  - ~~Evaluation Function:~~
     * ~~Maximum Points: 100~~
	 * ~~Measure Used: Test Measure~~
	 * ~~Normalization: Test Normalization~~
	 * ~~Range: File~~
	 * ~~Function: Linear Increasing Points~~
	     - ~~Min: 0.0~~
		 - ~~Max: 1.0~~
* ~~Test/Quality @Product/WeightedSumFactorAggregation~~
  - ~~Title: Product Quality Aggregation~~
  - ~~Description: Aggregates Product Quality~~
  - ~~Originates From: Test Source~~
  - ~~Completeness: 100~~
  - ~~Maximum Points: 100~~
  - ~~Tagged By: Test Tag~~
  - ~~Factor Aggregation:~~
     * ~~Maximum Points: 100~~
	 * ~~Rankings:~~
	    - ~~Ranking:1, CP:33.33, Name:Maintainability, Type:Positive~~
		- ~~Ranking:1, CP:33.33, Name:Quality @Source Code Part, Type:refinement~~
		- ~~Ranking:1, CP:33.33, Name:Security, Type:Positive~~
* ~~Test/Quality @Source Code Part/WeightedSumFactorAggregation~~
  - ~~Title: Source Code Quality Eval~~
  - ~~Description: Aggregates Product Quality~~
  - ~~Originates From: Test Source~~
  - ~~Completeness: 100~~
  - ~~Maximum Points: 100~~
  - ~~Tagged By: Test Tag~~
  - ~~Factor Aggregation:~~
     * ~~Maximum Points: 100~~
	 * ~~Rankings:~~
	    - ~~Ranking:1, CP:50, Name:Maintainability, Type:Positive~~
  	    - ~~Ranking:1, CP:50, Name:Security, Type:Positive~~
* ~~Test/Security/SingleMeasureEvaluation~~
  - ~~Title: Test Measure for Security~~
  - ~~Description: Security test measue evaluation~~
  - ~~Originates From: Test Source~~
  - ~~Completeness: 100~~
  - ~~Maximum Points: 100~~
  - ~~Tagged By: Test Tag~~
  - ~~Evaluation Function:~~
     * ~~Maximum Points: 100~~
	 * ~~Measure Used: Test Measure~~
	 * ~~Normalization: Test Normalization~~
	 * ~~Range: File~~
	 * ~~Function: Linear Decreasing Points~~
	     - ~~Min: 0.0~~
		 - ~~Max: 1.0~~

## Measures

---

* Mean @Product
  - ~~Title: Mean~~
  - ~~Description: Mean~~
  - ~~Characterizes: Product~~
  - ~~Type: Number~~
  - Determined By: Number Mean Measure Aggreagation Mean Test
  - ~~Originates From: Test Source~~
  - ~~Tagged By: Test Tag~~
* Parent @Product Part
  - ~~Title: Parent Measure~~
  - ~~Description: Parent Measure~~
  - ~~Type: FINDINGS~~
  - ~~Characterizes: Product Part~~
  - Refined By: Test Measure @Source Code Part
  - ~~Originates From: Test Source~~
  - ~~Tagged By: Test Tag~~
* Test Measure @Source Code Part
  - ~~Title: Test measure~~
  - ~~Description: Test Measure~~
  - ~~Type: FINDINGS~~
  - ~~Characterizes: Source Code Part~~
  - ~~Refines: Parent @Product Part~~
  - Determined By: Test/Test Measure @Source Code Part/Test2
  - ~~Originates From: Test Source~~
  - ~~Measures: Security, Maintainability~~
  - ~~Tagged By: Test Tag~~
* Test Normalization @Source Code Part
  - ~~Title: Test Normalization~~
  - ~~Description: Test Normalization~~
  - ~~Type: NUMBER~~
  - ~~Normalization: True~~
  - ~~Characterizes: Source Code Part~~
  - Determined By: Test/Test Normalization @Source Code Part/Test
  - ~~Originates From: Test Source~~
  - ~~Tagged By: Test Tag~~

## ~~Measurement Methods~~

---

* ~~Test/Mean @Product/Mean Test~~
  - ~~Name: Mean Test~~
  - ~~Title: Mean Test~~
  - ~~Description: Mean Test~~
  - ~~Determines: Mean @Product~~
  - ~~Originates From: Test Source~~
  - ~~Tagged By: Test Tag~~
* ~~Test/Test Measure @Source Code Part/Test2~~
  - ~~Tool: Test Tool~~
  - ~~Metric: Test2~~
  - ~~Determines: Test Measure @Source Code Part~~
  - ~~Originates From: Test Source~~
  - ~~Tagged By: Test Tag~~
* ~~Test/Test Normalization @Source Code Part/Test~~
  - ~~Tool: Test Tool~~
  - ~~Metric: Test~~
  - ~~Determines: Test Normalization @Source Code Part~~
  - ~~Originates From: Test Source~~
  - ~~Tagged By: Test Tag~~

## Tools

---

* Test Tool
  - ~~Name: Test Tool~~
  - ~~Title: Test Tool~~
  - ~~Description: Test Tool~~
  - ~~Originates From: Test Source~~
  - Invoked By: Test/Test Measure @Source Code Part/Test2, Test/Test Normalization @Source Code Part/Test
  - Tagged By: Test Tag

## Tags

---

* Test Tag
  - ~~Name: Test Tag~~
  - ~~Title: Test Tag~~
  - ~~Description: Test Tag~~
  - ~~Originates From: Test Source~~
  - Used By: Everything

## ~~Sources~~

---

* ~~Test Source~~
  - ~~Name: Test Source~~
  - ~~Title: Test Source~~
  - ~~Description: Test Source~~
  - ~~Referenced By: Everything~~
