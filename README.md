**Overview**

This module applies promotional discounts to individual order items as well as the entire order
Below are the promotion discount rule mentioned for order items and order.
1.	If the user is an employee of the store, he gets a 30% discount
2.	If the user is an affiliate of the store, he gets a 10% discount
3.	If the user has been a customer for over 2 years, he gets a 5% discount.
4.	For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
5.	The percentage based discounts do not apply on groceries.
6.	A user can get only one of the percentage based discounts on a bill.
 
**Solution**
1.	The system identifies the customer type (e.g., store employee, store customer, or regular customer) based on their customer type.
2.	The duration of a customer’s account on the website is determined by their account creation date. This information is stored in the customer object.
3.	Create a POST REST endpoint in the OrderDiscountController at /promotion/apply-discount. This API accepts order items as a JSON request.
4.	Parse the JSON request to create an order object and pass it to the OrderDiscountService.
5.	The OrderDiscountService is responsible for applying all promotions and returning the order object with updated discount price details.
6.	CustomerPromotion and OrderPromotion implement the Promotion interface, which includes the applyPromotion() method.
7.	The applyPromotion() method contains the logic for applying promotional discounts.
8.	Create a list of promotions to be applied to the order.
9.	Promotions will be processed one by one, picking them from the list and applying them to the order.
10.	The same order object is passed to the second promotion (e.g., OrderPromotion) after the first promotion (e.g., CustomerPromotion) is applied.
11.	Once all promotions have been applied, the order is returned with the updated discount details.
12.	The CustomerPromotion logic identifies customer discounts based on the customer type.
13.	The customer’s duration on the website is used to determine if they have been a customer for more than two years and are eligible for a percentage-based discount.
14.	Items have categories, and those categorized as "grocery" are excluded from promotional discounts.
15.	This approach allows for easy addition of new promotions to the order by implementing the Promotion interface.


**Installtion**

1.Clone the repository https://github.com/ch-anurag/promotion-service/

2.Open the project IntelliJ and complete the project.


 <img width="935" alt="image" src="https://github.com/user-attachments/assets/8b9827fc-38f7-4d7a-b332-1919eca45c7f">




3.Run the applicaiton 


  <img width="943" alt="image" src="https://github.com/user-attachments/assets/81d99353-4938-43d6-a2d6-36324020385e">

4.Run the test cases 

   <img width="950" alt="image" src="https://github.com/user-attachments/assets/786ff459-8abc-400d-8b75-9b799400108b">

5. Test Code Coverage Report

   <img width="340" alt="image" src="https://github.com/user-attachments/assets/73960bf1-df52-48d9-80bf-a6ff7979c533">


**Tets the API**

1.Curl Command
**Request**
curl --location 'http://[hostname]:9001/promotion/apply-discount' \
--header 'Authorization: Bearer ey' \
--header 'Content-Type: application/json' \
--data '{
  "orderId": "N7878",
  "customerId": "333",
  "items": [
    {
      "productId": "P898",
      "productName": "Samsung Phone",
      "quantity": 2,
      "price": 100.00,
       "category": "electronic"
    },
    {
      "productId": "P676",
      "productName": "milk",
      "quantity": 1,
      "price": 100.00,
      "category": "grocery"
    }
  ],
  "totalAmount": 200.00,
  "orderStatus": "Pending",
  "orderDate": "2024-11-08"
}'

**Response**

{
    "orderId": "N7878",
    "customerId": "333",
    "totalAmount": 200.0,
    "orderStatus": "Pending",
    "orderDate": "2024-11-08",
    "orderDiscount": 5.0,
    "totalDiscount": 15.0,
    "totalAmountAfterDiscount": 185.0,
    "items": [
        {
            "productId": "P898",
            "productName": "Samsung Phone",
            "quantity": 2,
            "price": 100.0,
            "discount": 10.0,
            "category": "electronic"
        },
        {
            "productId": "P676",
            "productName": "milk",
            "quantity": 1,
            "price": 100.0,
            "discount": 0.0,
            "category": "grocery"
        }
    ]
}


**UML Diagram**







