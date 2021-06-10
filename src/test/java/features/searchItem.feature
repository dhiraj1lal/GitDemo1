Feature: Search an item

Scenario Outline: Search an item

Given Launch "https://www.flipkart.com/"
When Search <item>
And Add to the cart
Then Verify cost of items

Examples:

|item   |
|Gel Pen|