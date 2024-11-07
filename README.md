This project is related to offering discounts to customers based on the total price of items, with fixed discussions regarding the discount structure

1.Clone the repository https://github.com/ch-anurag/promotion-service/

2.Open the project IntelliJ and complete the project.

<img width="928" alt="image" src="https://github.com/user-attachments/assets/1e8fc11c-50a8-4d10-9983-6c3cd30e2f17">




3.Run the applicaiton 


<img width="923" alt="image" src="https://github.com/user-attachments/assets/caeb00b2-170d-472b-acd6-d84618646850">




4.Test the api http://[hostname]:9001/promotion/item-discount?userId=333&itemId=222



5.Run the test cases 


<img width="922" alt="image" src="https://github.com/user-attachments/assets/2e061c4d-d458-4512-a717-812250cf8b7f">




6.Report will be generated for test covergae 


<img width="922" alt="image" src="https://github.com/user-attachments/assets/02e0d8b3-3107-4497-ab12-868ef4023563">











**UML Diagram**

![promotion-service-uml](https://github.com/user-attachments/assets/724971f2-5af5-4a38-ad37-09ff0c41a3d9)




**Implementation Details:**

1.Create the customer based on their type and associate the appropriate promotional discount.

2.Currently, the promotional discount is hardcoded in the code, but it can be dynamically configured from the database.

3.The excluded item categoey are hardcoded in the code, but we can maintain a listfor more exclude category and configure it through the database or a configuration file.

4.The applyCustomerDiscount() method is used to apply customer-specific discount calculations.

5.The fixed discount is calculated using the TotalAmountFixedDiscountPromotion.Discount amount and discount on the price is hardcoded but can be configured dynamically.

6.The ItemDiscountCalculatorImpl service is used to apply all discounts and calculate the discounted price.

7.Consider one item for discount calcualtion.

8.Customer and item data are created within the code in CommonServiceImpl, but this can be replaced with database-driven data as well.

