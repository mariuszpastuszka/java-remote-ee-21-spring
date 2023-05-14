# Spring exercises

### Useful git commands

### MVC pattern
- Model
- View
- Controller

### Stack architecture based ond MVC pattern
- Controller
- Model (data + operations on data) = Service + Repository

- Controller ->
- Service ->
- Repository

### View - it's a view which user is able to play with
- html pages
- json payload

### Model data
- dto (Data Transfer Object)
- Entity

### REST Architecture/Restful API
- exposing data through html protocol
- every resource have url
- standard methods to play with those resources
- CRUD methods: Create/Read/Update/Delete
- Car as an example - our propositions
  - get all cars (url + Http verb): GET /all-cars
  - get one particular car (url + Http verb): POST /VIN; POST /bmw
  - create new car (url + Http verb): POST /add-car; POST /add-new-car
  - delete car (url + Http verb): DELETE /VIN; DELETE /delete-car
  - update car (url + Http verb): PATCH /VIN-patch; PATCH/update-car
