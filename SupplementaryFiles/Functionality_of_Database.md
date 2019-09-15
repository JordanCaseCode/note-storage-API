Work Flows to Determine Database Schema

Functionality:
---

### User:
* Created
    -Anyone
* Logged In
    -user
      
* Updated
  -User

* Delete
    -Admin

### Subject:
* Created
	-Only by users
* Read
	-Anyone
* Read Related Public Notes:
	-public notes only
* Update
	-Admin
* Delete
	-Admin

### Public Note:
* Created
	-Only by users
* Read
	-Anyone
* Update
	-Admin (as of now)
* Delete
	-Admin
### Private Note:
* Created
	-Only by users
* Read
	-Creator (user who made the note)
* Update
	-Creator
* Delete
	-Creator