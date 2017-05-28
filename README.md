<img src="https://raw.githubusercontent.com/thiagodnf/jmetal-restful/master/src/main/resources/assets/logo.png" width="448"/>


**A RESTFul Web Service for JMetal Framework**

Overview
--
JMetal RESTFul was built to turn available some features available in <a href="https://github.com/jMetal/jMetal">JMetal Framework</a>. This tool uses a RESTFul server powered by <a href="http://spring.io/">Spring</a> to expose some operations that can be access through POST requests.

Features
--

JMetal RESTFul is able to do the following tasks:

- Generate Pareto-front given a set of solutions
- Calculate quality indicators given a set of solutions and a pareto-front

How this works
--
The following image shows how this tools works

<img src="https://raw.githubusercontent.com/thiagodnf/jmetal-restful/master/src/main/resources/assets/how-this-works.png" />

First, the tool receives as input a JSON-formatted string in the body of a POST request provided by a client. Next, this one converts this string into a object instance that will used to run the algorithms available in JMetal Framework. When it is done, JMetal RESTFul will return a JSON-formatted string to the client. 
