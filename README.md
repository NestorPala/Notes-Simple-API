# Notes-Simple-API

---

## API Usage

<br>


### *GET ALL NOTES*


`GET /api/notes/get` <br>



Example Response: <br>

<code>

    [
        {
            "id": 1,
            "title": "Note 1 (UPDATED)",
            "content": "Lorem Ipsum",
            "archived": false
        },
        {
            "id": 2,
            "title": "Note 2",
            "content": "Pepe",
            "archived": false
        },
        {
            "id": 3,
            "title": "Note 3",
            "content": "AAAAAAAAAAAAAAAAAA",
            "archived": true
        }
    ]

</code>


---


### *CREATE A NOTE*


`POST /api/notes/create` <br>

Request JSON: <br>

<code>

    {
        "title": "Note 5",
        "content": "Lorem Ipsum"
    }

</code>


Example Response: <br>

<code>

    {
        "id": 5,
        "title": "Note 5",
        "content": "Lorem Ipsum",
        "archived": false
    }

</code>


---


### *EDIT A NOTE BY ID*


`PATCH /api/notes/edit/{id}` <br>

Request JSON: <br>

<code>

    {
        "title": "Note 2 (UPDATED)"
    }

</code>


Example Response: <br>

<code>

    {
        "id": 2,
        "title": "Note 2 (UPDATED)",
        "content": "Pepe",
        "archived": false
    }

</code>


---


### *DELETE A NOTE BY ID*


`DELETE /api/notes/delete/{id}` <br>



Example Response: <br>

<code>

    Note deleted successfully!

</code>


---


### *ARCHIVE A NOTE BY ID*


`PATCH /api/notes/archive/{id}` <br>



Example Response: <br>

<code>

    {
        "id": 3,
        "title": "Note 3",
        "content": "AAAAAAAAAAAAAAAAAA",
        "archived": true
    }

</code>


---


### *UNARCHIVE A NOTE BY ID*


`PATCH /api/notes/unarchive/{id}` <br>



Example Response: <br>

<code>

    {
        "id": 3,
        "title": "Note 3",
        "content": "AAAAAAAAAAAAAAAAAA",
        "archived": false
    }

</code>


---


### *GET ARCHIVED NOTES*


`GET /api/notes/archived` <br>



Example Response: <br>

<code>

    [
        {
            "id": 3,
            "title": "Note 3",
            "content": "AAAAAAAAAAAAAAAAAA",
            "archived": true
        }
    ]

</code>


---
