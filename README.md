# sturdy-engine
The repository contains a coding demo project as requested by flexReceipts.

# Project requirements:

## Implement Web API for Metrics
Implement a web application which allows users to create multiple metric and post values to that metric (e.g. stock price of a security). Users should be able to also request summary statistics for that metric.

Users will communicate with the web application via a Web API.

### Project Description
Your Web API should support the following actions:

  1. Create a Metric – the API should allow the user to create metrics.
  2. Post Values to a Metric - the API should allow the user to post a decimal value to a created metric. Please note that user should be able to create multiple metrics so you should be able to specify the metric in this request.
  3. Retrieve Statistics - the API should allow the user to retrieve summary statistics on ametric. Specifically:
    1. Arithmetic Mean of a values posted to metric
    2. Median of a values posted to metric
    3. Min value for metric
    4. Max value for metric

Please note that user should be able to create multiple metrics so you should be able to specify the metric in this request.

In addition to developing the API, please explain the time and space complexity of each API call for your app in big-O​ notation.

### Error Handling
All API calls should have adequate error handling.

### Data Persistence
All data maintained by the app is ephemeral i.e., it is acceptable if all data stored by app is restarted the application should clear any data stored in memory by the app.

### Project Implementation/Delivery
The following summarizes implementation and delivery requirements.

  * Programming Language – preferred languages are Java, Python, or JavaScript. You can use another language if you can provide adequate justification (e.g. reduces effort required).
  * Source Code Delivery – the source code can be delivered as either as a Git repo or in a zip archive via email.
  * Build/Deployment Instructions – you must provide instructions on how to build and deploy your software. You can assume the tester will have access to a JVM, Python interpreter, or NodeJS server, and Docker.

### Judgement Criteria
The project will be judged across three categories:
  1. Functionality
    * Whether the API well-defined.
    * The ease of use of the API.
    * The amount of bugs associated with the API.
    * The time and space complexity of your app.
  2. Code quality
    * Code should be well-structured and easy to follow.
    * The code should be well-tested i.e., unit-tests.
    * The code should only make use of third-party frameworks where prudent.
  3. Delivery
    * The application should be easy to build and deploy.
