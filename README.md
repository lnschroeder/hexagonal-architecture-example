# Hexagonal architecture example
This is a super simple example for the hexagonal/ports & adapters architecture.

The code contains some logical flaws - just don't care about them. This is about the architecture. 
The implementations of `addBook()` in `BookDatabase1` and `BookDatabase2` e.g. don't have the same behaviour.

## How to run
1. start `HexagonalApplication`
2. send REST requests (e.g. with [Postman](https://www.postman.com/)) locally and watch the Responses and console outputs
   1. add book: (POST) `http://localhost:8080/api/v1/book?isbn=9783161484100&title=Gesammelte Werke in deutscher Sprache&price=39.0` 
   2. get book by ISBN: (GET) `http://localhost:8080/api/v1/book/9783161484100`
   3. get all books: (GET) `http://localhost:8080/api/v1/book`

You can also just import [this collection](https://www.getpostman.com/collections/639ff937a74ed56d8a24) to postman.