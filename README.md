# Mongo Spring demos

This is an effort to learn the finer points/oddities of spring + mongo + REST.

I've got a local copy of Mongo running.

# To set up a user on Mongo:
open "C:\Program Files\MongoDB\Server\5.0\bin\mongo.exe" (mongo console)
Set the database, create a user:
```
db=db.getSiblingDB("jimsTestingThing")

db.createUser(
{ 
 user: "jim",
 pwd:  "password",
 roles:
 [
 { role:"readWrite",db:"jimsTestingThing"}
 ] } );

```
Now set this in application.properties
