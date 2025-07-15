
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

@Background: 
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with <username> and <password>
    When I add <productName> from Cart
    AND Checkout <productName> and submit the order
    Then I verify the <orderID> on Confirmation Page

    Examples: 
      | name                 |     password  | productName   |
      | abcd1t1t1t@gmail.com |     Jiracode3 | ZARA COAT 3   |

    