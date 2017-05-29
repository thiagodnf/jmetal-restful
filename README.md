<img src="https://raw.githubusercontent.com/thiagodnf/jmetal-restful/master/src/main/resources/assets/logo.png" width="450"/>


**A RESTFul Web Service for JMetal Framework**

Overview
-
JMetal RESTFul was built to turn available some features available in <a href="https://github.com/jMetal/jMetal">JMetal Framework</a>. This tool uses a RESTFul server powered by <a href="http://spring.io/">Spring</a> to expose some operations that can be access through POST requests.

Features
--

JMetal RESTFul is able to do the following tasks:

- **Generate Pareto-front**  - This task generates a pareto-front set given a set of solutions
- **Calculate Quality Indicators** - This task calculates quality indicators (such as Hypervolume, IGD, GD, and so on) given a set of solutions and a pareto-front set

How this works
-

The following image shows how this tools works

<img src="https://raw.githubusercontent.com/thiagodnf/jmetal-restful/master/src/main/resources/assets/how-this-works.png" />

First, the tool receives as input a JSON-formatted string in the body of a POST request provided by a client. Next, this one converts this string into a object instance that will used to run the algorithms available in JMetal Framework. When it is done, JMetal RESTFul will return a JSON-formatted string to the client. 

Run the server
-

You can run the Application class as desktop application or run the following command

```sh
java -jar jmetal-restful-<version>.jar
```

Usage
-

Each task has its own JSON-formatted string required. At the following there are some examples how to use each task.

<h3>Generate Pareto-front</h3>

**The request type**: POST

**URL:** /generator/pareto-front

**Body:**
```json
{
    "solutions": [
        {"objectives": [20, 12], "variables": ["0101"]},
        {"objectives": [2, 11 ], "variables": ["0101"]},
        {"objectives": [10, 11], "variables": ["0101"]},
        {"objectives": [15, 11], "variables": ["0101"]},
        {"objectives": [8, 9  ], "variables": ["0101"]},
        {"objectives": [13, 8 ], "variables": ["0101"]},
        {"objectives": [4, 7  ], "variables": ["0101"]},
        {"objectives": [18, 6 ], "variables": ["0101"]},
        {"objectives": [8, 5  ], "variables": ["0101"]},
        {"objectives": [12, 5 ], "variables": ["0101"]},
        {"objectives": [13, 2 ], "variables": ["0101"]},
        {"objectives": [20, 1 ], "variables": ["0101"]},
    ]
}
```

**Response:**
```json
{
    "solutions": [
        {"objectives": [2, 11 ], "variables": ["0101"]},
        {"objectives": [4, 7  ], "variables": ["0101"]},
        {"objectives": [8, 5  ], "variables": ["0101"]},
        {"objectives": [13, 2 ], "variables": ["0101"]},
        {"objectives": [20, 1 ], "variables": ["0101"]},
    ]
}
```

<h3>Calculate Quality Indicators</h3>

**The request type**: POST

**URL:** /calculate/quality-indicators

**Body:**
```json
{
    "paretoFront":{
        "solutions": [
            {"objectives": [2, 11 ], "variables": ["0101"]},
            {"objectives": [4, 7  ], "variables": ["0101"]},
            {"objectives": [8, 5  ], "variables": ["0101"]},
            {"objectives": [13, 2 ], "variables": ["0101"]},
            {"objectives": [20, 1 ], "variables": ["0101"]},
        ]
    },
    "population": {
        "solutions": [
            {"objectives": [8, 9  ], "variables": ["0101"]},
            {"objectives": [12, 5 ], "variables": ["0101"]},
        ]
    }
}
```

**Response:**
```json
{
	"metrics": {
		"epsilon": 6.0,
		"hypervolume": 0.0,
		"igd_plus": 4.294427190999916,
		"error_ratio": 1.0,
		"igd": 2.5768197453450252,
		"gd": 2.5495097567963922,
		"spread": 0.7296692939273969
	},
	"normalizedMetrics": {
		"epsilon": 0.4,
		"hypervolume": 0.3111111111111111,
		"igd_plus": 0.3109049957647721,
		"igd": 0.17210390200811762,
		"gd": 0.18625616238044682,
		"spread": 0.6831692859568865
	}
}
```

Example with JQuery
-
The following javascript code contains an example of requests by using JQuery

```javascript
$.ajax({
    url: 'http://localhost:8080/generator/pareto-front',
    type: 'POST',
    contentType: "application/json; charset=utf-8",
    dataType: 'json',
    processData:false, //To avoid making query String instead of JSON
    data: JSON.stringify({
	"solutions": [
		{"objectives": [2, 11 ], "variables": ["0101"]},
		{"objectives": [4, 7  ], "variables": ["0101"]},
		{"objectives": [8, 5  ], "variables": ["0101"]},
		{"objectives": [13, 2 ], "variables": ["0101"]},
		{"objectives": [20, 1 ], "variables": ["0101"]},
	]
    }),
    success: function(result) {
	console.log(result)
    },
    error: function(error){
	console.log(error.responseText);
    }
});
```

```javascript
$.ajax({
    url: 'http://localhost:8080/calculate/quality-indicators',
    type: 'POST',
    contentType: "application/json; charset=utf-8",
    dataType: 'json',
    processData:false, //To avoid making query String instead of JSON
    data: JSON.stringify({
	paretoFront:{
		"solutions": [
			{"objectives": [2, 11 ], "variables": ["0101"]},
			{"objectives": [4, 7  ], "variables": ["0101"]},
			{"objectives": [8, 5  ], "variables": ["0101"]},
			{"objectives": [13, 2 ], "variables": ["0101"]},
			{"objectives": [20, 1 ], "variables": ["0101"]},
		]
	},
	population: {
		"solutions": [
			{"objectives": [8, 9  ], "variables": ["0101", "ae"]},
			{"objectives": [12, 5 ], "variables": ["0101", "aj"]},
		]
	}
    }),
    success: function(result) {
	console.log(result)
    },
    error: function(error){
	console.log(error.responseText);
    }
});
```

Warning
-

This is not an official JMetal Framework product



