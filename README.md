# RentACar
Java app using Springboot JPA for CRUD operations
This App is to show some operations: Create, Read, Update and Delete with MySWL Database
I used Xampp for Database server and Postman for requests

Example JSAON body for:
Car:
{
    "brand":"dacia",
    "model":"logan",
    "color":"pink",
    "available":false,
    "fuel":"gasoline",
    "bodyType":"sedan",
    "traction":"rear",
    "airConditioner":true,
    "babySeat":true,
    "vin":"12345"
}

Bike:
{
    "brand":"Merida",
    "model":"Big Nine 200",
    "color":"pink",
    "available":false,
    "type":"MTB",
    "frontSuspension":true,
    "rearSuspension":true,
    "speeds":"1x11"
}

Truck:
{
    "brand":"Toyota",
    "model":"hilux",
    "color":"doesntmatter",
    "available":true,
    "fuel":"diesel",
    "capacity":600,
    "traction":"4x4",
    "trailer":true,
    "vin":"11111111111122"
}

Customer:
{
    "firstName":"Bond",
    "lastName":"James",
    "email":"some#@email.com",
    "driverLicence":"B",
    "phoneNumber":"007"
}

I've tried to use as many as possible OOP concepts to show how it works.
