Feature: Feature to test, the person from Wales get help from NHS costs or not

  Background: Flow till GP practice page
    Given The user lands on the "NHS check for help" page
    And The user clicks  "Start" button on the NHS check for help page
    And The user clicks "WALES" for "Which country do you live in?" question
    And The user clicks "Next" button

  Scenario: Get help with NHS costs- Universal Credit and your combined take-home pay was less than £935
    And The user clicks "Yes" for "Is your GP practice in Scotland or Wales?" question
    And The user clicks "Next" button
    And The user clicks "WALES" for "Which country is your dental practice in?" question
    And The user clicks "Next" button
    And The user enters DOB "11-11-1998" on the Date of birth page
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you live with a partner?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you or your partner claim any benefits or tax credits?" question
    And The user clicks "Next" button
    And The user clicks "YES" for "Do you or your partner get paid Universal Credit?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "As part of your joint Universal Credit, do you have any of these?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Did you and your partner have a combined take-home pay of £935 or less in your last Universal Credit period?" question
    And The user clicks "Next" button
    Then The user validates the NHS cost result contains "You get help with NHS costs"
    Then The user validates the available "free" treatments "NHS prescriptions - NHS dental check-ups and treatment - sight tests - NHS wigs and fabric supports"
    Then The user validates the available "money off" treatments "new glasses or contact lenses - repairing or replacing your glasses or contact lenses - travel for NHS treatment"


  Scenario Outline: Not living permanently in a care home having more than £16,000 in savings, investments or property
    And The user clicks "<GP practice>" for "Is your GP practice in Scotland or Wales?" question
    And The user clicks "Next" button
    And The user clicks "<Dental practice>" for "Which country is your dental practice in?" question
    And The user clicks "Next" button
    And The user enters DOB "<DOB>" on the Date of birth page
    And The user clicks "Next" button
    And The user clicks "No" for "Do you live with a partner?" question
    And The user clicks "Next" button
    And The user clicks "No" for "Do you claim any benefits or tax credits?" question
    And The user clicks "Next" button
    And The user clicks "<Pregnant>" for "Are you pregnant or have you given birth in the last 12 months?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you have an injury or illness caused by serving in the armed forces?" question
    And The user clicks "Next" button
    And The user clicks "<Diabetes>" for "Do you have diabetes?" question
    And The user clicks "Next" button
    And The user clicks "<Glaucoma>" for "Do you have glaucoma?" question
    And The user clicks "Next" button
    And The user clicks "No" for "Do you live permanently in a care home?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you have more than £16,000 in savings, investments or property?" question
    And The user clicks "Next" button
    Then The user validates the NHS cost result contains "You get help with NHS costs"
    Then The user validates the available "free" treatments "<Free Treatments>"
    Then The user validates the free treatments "<Descriptions>"
    Examples:
      | DOB        | GP practice | Dental practice | Pregnant | Diabetes | Glaucoma | Free Treatments                                                                   | Descriptions                                                                                                                                                                                                                                                                                                                       |
      | 11-11-1998 | Yes         | WALES           | Yes      | Yes      | Yes      | NHS prescriptions - sight tests - NHS dental check-ups - NHS dental treatment     | If your prescription is dispensed in Wales or you have an Entitlement Card - If you can show proof that you're pregnant or have given birth in the last 12 months or If you are under 25 and are registered with a dental practice in Wales - If you can show proof that you're pregnant or have given birth in the last 12 months |
      | 11-11-1998 | No          | WALES           | No       | Yes      | No       | NHS prescriptions - sight tests - NHS dental check-ups                            | If your prescription is dispensed in Wales or you have an Entitlement Card - If you are under 25 and are registered with a dental practice in Wales                                                                                                                                                                                |
      | 11-11-1988 | Yes         | WALES           | No       | No       | Yes      | NHS prescriptions - sight tests                                                   | If your prescription is dispensed in Wales or you have an Entitlement Card                                                                                                                                                                                                                                                         |
      | 11-11-1988 | No          | WALES           | No       | No       | No       | NHS prescriptions                                                                 | If your prescription is dispensed in Wales or you have an Entitlement Card                                                                                                                                                                                                                                                         |
      | 11-11-1998 | Yes         | SCOTLAND        | No       | Yes      | No       | NHS prescriptions - sight tests - NHS dental check-ups, treatment, and appliances | If your prescription is dispensed in Wales or you have an Entitlement Card - If you are registered with a dental practice in Scotland                                                                                                                                                                                              |
      | 11-11-1988 | Yes         | SCOTLAND        | No       | Yes      | No       | NHS prescriptions - sight tests                                                   | If your prescription is dispensed in Wales or you have an Entitlement Card                                                                                                                                                                                                                                                         |


  Scenario: Get help with NHS costs- get help from your local council to pay for your care home
    And The user clicks "Yes" for "Is your GP practice in Scotland or Wales?" question
    And The user clicks "Next" button
    And The user clicks "WALES" for "Which country is your dental practice in?" question
    And The user clicks "Next" button
    And The user enters DOB "11-11-1998" on the Date of birth page
    And The user clicks "Next" button
    And The user clicks "No" for "Do you live with a partner?" question
    And The user clicks "Next" button
    And The user clicks "No" for "Do you claim any benefits or tax credits?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Are you pregnant or have you given birth in the last 12 months?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you have an injury or illness caused by serving in the armed forces?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you have diabetes?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you have glaucoma?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you live permanently in a care home?" question
    And The user clicks "Next" button
    And The user clicks "Yes" for "Do you get help to pay for your care home from your local council?" question
    And The user clicks "Next" button
    Then The user validates the NHS cost result contains "You can apply for help with NHS costs"
    Then The user validates the available "free" treatments "NHS prescriptions - NHS dental check-ups and treatment - sight tests - NHS wigs and fabric supports"
    Then The user validates the available "money off" treatments "new glasses or contact lenses - repairing or replacing your glasses or contact lenses - travel for NHS treatment"


  Scenario: Get help with NHS costs- Age under 16
    And The user clicks "Yes" for "Is your GP practice in Scotland or Wales?" question
    And The user clicks "Next" button
    And The user clicks "WALES" for "Which country is your dental practice in?" question
    And The user clicks "Next" button
    And The user enters DOB "11-11-2008" on the Date of birth page
    And The user clicks "Next" button
    Then The user validates the NHS cost result contains "You get help with NHS costs"
    Then The user validates the available "free" treatments "NHS prescriptions - NHS dental check-ups and treatment - sight tests - NHS wigs and fabric supports"
    Then The user validates the available "money off" treatments "new glasses or contact lenses - repairing or replacing your glasses or contact lenses"


  Scenario: Get help with NHS costs- Age under 19 & in full-time education
    And The user clicks "Yes" for "Is your GP practice in Scotland or Wales?" question
    And The user clicks "Next" button
    And The user clicks "WALES" for "Which country is your dental practice in?" question
    And The user clicks "Next" button
    And The user enters DOB "11-11-2004" on the Date of birth page
    And The user clicks "Next" button
    And The user clicks "Yes" for "Are you in full-time education?" question
    And The user clicks "Next" button
    Then The user validates the NHS cost result contains "You get help with NHS costs"
    Then The user validates the available "free" treatments "NHS prescriptions - NHS dental check-ups and treatment - sight tests - NHS wigs and fabric supports"
    Then The user validates the available "money off" treatments "new glasses or contact lenses - repairing or replacing your glasses or contact lenses"


