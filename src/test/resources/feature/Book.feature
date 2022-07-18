Feature: Search by keyword

  Scenario: API#2 question 1,2,3
    Given Test API feature
    When Get Book
      | 99 |
      | 100 |
      | 101 |
      | 102 |
  Scenario Outline: API#1 question 1,2,4,5
    Given Test API feature
    Then Verify status code 200
    And Check the book exist "<title>"
    And Verify total size of book 200

    Examples:
    | title |
    | Book 198 |
    | Book 500 |

  Scenario Outline: API#1 question 3
    Given Test API feature
    Then Verify status code 200
    And Check the book not exist "<title>"
    And Verify total size of book 200

    Examples:
      | title |
      | Book 200 |

