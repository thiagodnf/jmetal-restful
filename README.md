<img src="https://raw.githubusercontent.com/thiagodnf/jmetal-restful/master/src/main/resources/assets/logo.png" width="450"/>


**A RESTFul Web Service for JMetal Framework**

Overview
--
JMetal RESTFul was built to turn available some features available in <a href="https://github.com/jMetal/jMetal">JMetal Framework</a>. This tool uses a RESTFul server powered by <a href="http://spring.io/">Spring</a> to expose some operations that can be access through POST requests.

Features
--

JMetal RESTFul is able to do the following tasks:

- **Generate Pareto-front**  - This task generates a pareto-front set given a set of solutions
- **Calculate Quality Indicators** - This task calculates quality indicators (such as Hypervolume, IGD, GD, and so on) given a set of solutions and a pareto-front set

How this works
--
The following image shows how this tools works

<img src="https://raw.githubusercontent.com/thiagodnf/jmetal-restful/master/src/main/resources/assets/how-this-works.png" />

First, the tool receives as input a JSON-formatted string in the body of a POST request provided by a client. Next, this one converts this string into a object instance that will used to run the algorithms available in JMetal Framework. When it is done, JMetal RESTFul will return a JSON-formatted string to the client. 

Usage
--

Each task has its own JSON-formatted string required. At the following there are some examples how to use each task.

<h3>Generate Pareto-front</h3>

**The request type**: POST

**URL:** /generator/pareto-front

**Body:**
```json
{
    "id": "1",
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
    "id": "1",
    "solutions": [
        {"objectives": [2, 11 ], "variables": ["0101"]},
        {"objectives": [4, 7  ], "variables": ["0101"]},
        {"objectives": [8, 5  ], "variables": ["0101"]},
        {"objectives": [13, 2 ], "variables": ["0101"]},
        {"objectives": [20, 1 ], "variables": ["0101"]},
    ]
}
```

Warning

This is not an official JMetal Product product.



