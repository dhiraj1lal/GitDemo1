Feature: Validate Active Covid Count

Scenario Outline: Launching "https://www.covid19india.org/" and validate Covid Active Cases in different states
Given Launch browser and browse "https://www.covid19india.org/"
When Search <State> and find covid active cases
Then validate count of active cases

Examples:
|State		  |
|Uttar Pradesh|
|Delhi		  |
