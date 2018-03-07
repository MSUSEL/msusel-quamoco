# ~~Model~~

---

* ~~Name: TestHier~~
* ~~Title: TestHier~~
* ~~Description: TestHier~~
* ~~Requires: Test~~
* ~~Originates From: Test#Test Source~~
* ~~Tagged By: Test#Test Tag~~

## ~~Entities~~

---

* ~~Class~~
  - ~~Name: Class~~
  - ~~Title: Type~~
  - ~~Description: ClassType~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~IsA: Test#Source Code Part~~
  - ~~Part Of: null~~

## ~~Factors~~

---

* ~~Reliability~~
  - ~~Name: Reliability~~
  - ~~Title: Reliability~~
  - ~~Description: Reliability~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines: null~~
  - ~~Influences: Test#Quality @Product, Test#Quality @Source Code Part~~

* ~~RelManual~~
  - ~~Name: RelManual~~
  - ~~Title: RelManual~~
  - ~~Description: RelManual~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines: null~~
  - ~~Influences: Reliability~~

* ~~RelMultMeasure~~
  - ~~Name: RelMultMeasure~~
  - ~~Title: RelMultMeasure~~
  - ~~Description: RelMultMeasure~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines: null~~
  - ~~Influences: Reliability~~

* ~~RelQIESL~~
  - ~~Name: RelQIESL~~
  - ~~Title: RelQIESL~~
  - ~~Description: RelQIESL~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines: null~~
  - ~~Influences: Reliability~~

* ~~RelText~~
  - ~~Name: RelText~~
  - ~~Title: RelText`~~
  - ~~Description: RelText~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines: null~~
  - ~~Influences: Reliability~~

* ~~UnionFactor~~
  - ~~Name: UnionFactor~~
  - ~~Title: UnionFactor~~
  - ~~Description: UnionFactor~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines: null~~
  - ~~Influences: Reliability~~

## ~~Evaluations~~

---

* ~~TestHier/Reliability/WeightedSumFactorAggregation~~
  - ~~Name: WeightedSumFactorAggregation~~
  - ~~Title: Test Hier WSFA~~
  - ~~Description: Test Hier WSFA~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Evaluates: Reliability~~
  - ~~Maximum Points: 100~~
  - ~~Completeness: 100~~
  - ~~Factor Aggregation:~~

    Ranking | CP | Name | Type
	--------- | -- | ---- | ----
	 1 | 20 | RelManual | negative
	 1 | 20 | RelMultMeasure | positive
	 1 | 20 | RelQIESL | negative
	 1 | 20 | RelText | positive
	 1 | 20 | UnionFactor | positive

* ~~TestHier/RelManual/ManualEvaluation~~
  - ~~Name: ManualEvaluation~~
  - ~~Title: Test Hier Manual Eval~~
  - ~~Description: Test Hier Manual Eval~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Evaluates: RelManual~~
  - ~~Maximum Points: 100~~
  - ~~Completeness: 100~~
  - ~~Evaluation Function:~~
  	* ~~Function: Linear Increasing Points~~
  	* ~~Max Points: 100~~
  	* ~~Measure: ManualMeas~~
  	* ~~Norm: NormMeas~~
  	* ~~lowerBound: 0.0~~
  	* ~~upperBound: 0.0~~

* ~~TestHier/RelMultMeasure/WeightedSumMultiMeasureEvaluation~~
  - ~~Name: WeightedSumMultiMeasureEvaluation~~
  - ~~Title: Test Hier WSMME~~
  - ~~Description: Test Hier WSMME~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Evaluates: RelMultMeasure~~
  - ~~Maximum Points: 100~~
  - ~~Completeness: 100~~
  - ~~Measure Evaluation:~~
  	* ~~Norm: NormMeas~~
  	* ~~Range: FILE~~
  	* ~~Function: Linear Increasing Points~~
  	* ~~lowerBound: 0.0~~
  	* ~~upperBound: 1.0~~
  	* ~~Max Pts: 100~~
  	* ~~Table:~~

  	 Ranking | CP | Name | Type
  	-------- | -- | ---- | ----
  	 1 | 25 | Measure1 | findings
  	 1 | 25 | Measure2 | findings
  	 1 | 25 | Measure3 | findings
  	 1 | 25 | ToolMeas | findings

* ~~TestHier/RelQIESL/QIESLEvaluation~~
  - ~~Name: QIESLEvaluation~~
  - ~~Title: Test Hier QIESLEval~~
  - ~~Description: Test Hier QIESLEval~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Evaluates: RelQIESL~~
  - ~~Maximum Points: 100~~
  - ~~Completeness: 100~~
  - ~~Evaluation Function:~~
  	* ~~Max Pts: 100~~
  	* ~~Measure: QIESLMeas~~
  	* ~~Norm: NormMeas~~
  	* ~~Function: Linear Decreasing Pts~~
  	* ~~LowerBound: 0.0~~
  	* ~~UpperBound: 1.0~~

* ~~TestHier/RelText/TextEvaluation~~
  - ~~Name: TextEvaluation~~
  - ~~Title: Test Hier TextEval~~
  - ~~Description: Test Hier TextEval~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Evaluates: RelText~~
  - ~~Maximum Points: 100~~
  - ~~Completeness: 100~~
  - ~~Specification: ""~~
  - ~~Evaluation Function:~~
  	* ~~Max Pts: 100~~
  	* ~~Measure: TextMeas~~
  	* ~~Norm: NormMeas~~
  	* ~~Range: FILE~~
  	* ~~Function: Linear Decreasing Points~~
  	* ~~LowerBound: 0.0~~
  	* ~~UpperBound: 1.0~~

* ~~TestHier/UnionFactor/SingleMeasureEvaluation~~
  - ~~Name: SingleMeasureEvaluation~~
  - ~~Title: UnionEval~~
  - ~~Description: UnionEval~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Evaluates: UnionFactor~~
  - ~~Maximum Points: 100~~
  - ~~Completeness: 100~~
  - ~~Measure: UnionMeas~~
  - ~~Norm Measure: NormMeas~~
  - ~~Range: FILE~~
  - ~~Evaluation Function:~~
  	* ~~Max Pts: 100~~
  	* ~~Measure: UnionMeas~~
  	* ~~Norm: NormMeas~~
  	* ~~Range: FILE~~
  	* ~~Function: Linear Increasing Points~~
  	* ~~LowerBound: 0.0~~
  	* ~~UpperBound: 1.0~~

## ~~Measures~~

---

* ~~ManualMeas~~
  - ~~Name: ManualMeas~~
  - ~~Title: Manual Measure~~
  - ~~Description: Manual Measure~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: RelManual~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: NUMBER~~

* ~~Measure1~~
  - ~~Name: Measure1~~
  - ~~Title: Measure1~~
  - ~~Description: Measure1~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: RelMultMeasure~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: FINDINGS~~

* ~~Measure2~~
  - ~~Name: Measure2~~
  - ~~Title: Measure2~~
  - ~~Description: Measure2~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: RelMultMesure~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: FINDINGS~~

* ~~Measure3~~
  - ~~Name: Measure3~~
  - ~~Title: Measure3~~
  - ~~Description: Measure3~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: RelMultMeasure~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: FINDINGS~~

* ~~NormMeas~~
  - ~~Name: NormMeas~~
  - ~~Title: Test Hier NormMeas~~
  - ~~Description: Test Hier NormMeas~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures:~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: NUMBER~~

* ~~QIESLMeas~~
  - ~~Name: QIESLMeas~~
  - ~~Title: QIESLMeas~~
  - ~~Description: QIESLMeas~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: NUMBER~~

* ~~TextMeas~~
  - ~~Name: TextMeas~~
  - ~~Title: Text Measure~~
  - ~~Description: Text Measure~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: RelText~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: FINDINGS~~

* ~~ToolMeas~~
  - ~~Name: ToolMeas~~
  - ~~Title: Tool Measure~~
  - ~~Description: Tool Measure~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: RelMultMeasure~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: FINDINGS~~

* ~~UnionMeas~~
  - ~~Name: UnionMeas~~
  - ~~Title: UnionMeas~~
  - ~~Description: UnionMeas~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Measures: UnionFactor~~
  - ~~Refines:~~
  - ~~Characterizes:~~
  - ~~Type: FINDINGS~~

## ~~Measurement Methods~~

---

* ~~TestHier/ManualMeas/TestHier Manual~~
  - ~~Name: TestHier Manual~~
  - ~~Title: TestHier Manual~~
  - ~~Description: TestHier Manual~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: ManualMeas~~

* ~~TestHier/Measure1/Test1~~
  - ~~Name/Metric: Test1~~
  - ~~Tool: TestHierTool~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: Measure1~~

* ~~TestHier/Measure2/Test2~~
  - ~~Name/Metric: Test3~~
  - ~~Tool: TestHierTool~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: Measure2~~

* ~~TestHier/Measure3/Test3~~
  - ~~Name/Metric: Test3~~
  - ~~Tool: TestHierTool~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: Measure3~~

* ~~TestHier/QIESLMeas/TestHier QIESL Aggr~~
  - ~~Name: TestHier QIESL Aggr~~
  - ~~Title: TestHier QIESL Aggr~~
  - ~~Description: TestHier QIESL Aggr~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: QIESLMeas~~
  - ~~Specification: ""~~

* ~~TestHier/TextMeas/TestHier Text Aggr~~
  - ~~Name: TestHier Text Aggr~~
  - ~~Title: TestHier Text Aggr~~
  - ~~Description: TestHier Text Aggr~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: TextMeas~~
  - ~~Specification: ""~~

* ~~TestHier/ToolMeas/Test4~~
  - ~~Name/Metric: Test4~~
  - ~~Tool: TestHierTool~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: ToolMeas~~

* ~~Findings Union Measure Aggregation TestHier Union Aggr~~
  - ~~Name: TestHier Union Aggr~~
  - ~~Title: TestHier Union Aggr~~
  - ~~Description: TestHier Union Aggr~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: UnionMeas~~

* ~~Number Mean Measure Aggregation TestHier Mean~~
  - ~~Name: TestHier Mean~~
  - ~~Title: TestHier Mean~~
  - ~~Description: TestHier Mean~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~
  - ~~Determines: NormMeas~~

## ~~Tools~~

---

* ~~TestHier Tool~~
  - ~~Name: TestHier Tool~~
  - ~~Title: TestHier Tool~~
  - ~~Description: TestHier Tool~~
  - ~~Originates From: TestHier Source~~
  - ~~Tagged By: TestHier Tag~~

## ~~Tags~~

---

* ~~TestHier Tag~~
  - ~~Name: TestHier Tag~~
  - ~~Title: TestHier Tag~~
  - ~~Description: TestHier Tag~~

## ~~Sources~~

---

* ~~TestHier Source~~
  - ~~Name: TestHier Source~~
  - ~~Title: TestHier Source~~
  - ~~Description: TestHier Source~~
