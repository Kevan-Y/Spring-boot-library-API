# JAC 555 - Assignment 2 API

## Routes

```bash
GET /api/v1/library/{libraryId}
```

```bash
PUT /api/v1/library/{libraryId}

Request Body:
{
  "address": "string",
}
```

```bash
DELETE /api/v1/library/{libraryId}
```

```bash
GET /api/v1/library
```

```bash
POST /api/v1/library

Request Body:
{
  "address": "string",
}
```

```bash
POST /api/v1/library/{libraryId}/book

Request Body:
{
  "title": "string",
  "summary": "string"
}
```

```bash
GET /api/v1/book/{bookId}
```

```bash
PUT /api/v1/book/{bookId}

Request Body:
{
  "title": "string",
   "summary": "string"
}
```

```bash
DELETE /api/v1/book/{bookId}
```

```bash
GET /api/v1/book

Optional query: title
```

## Schema

```text
Book{
 id : integer($int64)
 title : string
 summary : string
 library : Library
}
```

```text
Libray{
 id : integer($int64)
 address : string
 books : Array <Book>
}
```
