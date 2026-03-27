# API BEHAVIOUR AND END-POINTS

## Add a new notification to notification **QUEUE**

### POST /pigeon/notify

**sender_id** will remain constant for initial prototype, for later version of software the user first will
login. Which will decide the sender id of the person.

The POST accepts only 50 request per request, in case the number of requests exceed 50 the CLI 
will make sure that the data is sent at only 50 notification request at a time.

```
{   
    "user_id<LIST[50]>",
    "sender_id",
    "type(EMAIL,SMS,HYBRID)",
    "message",
    "scheduled_at",
    "created_at"
}
```

The API creates the message by fetching details of user and sender sends the message to message queue [Notification].

The replies a message with notification id of all the messages sent.

### GET /pigeon/checkstatus/{notification_id} / /pigeon/checkstatus

```
{
    "sender_id",
    "notification_id" (Optional)
}
```

Replies with status details of notification only if sender_id matches the sender id of the requested notification.


### POST /pigeon/adduser

```
{
    "user_name,
    "contact_number",
    "contact_email
}
```

returns user id

### POST /pigeon/addsender

```
{
    "organization_name,
    "contact_number",
    "contact_email
}
```

returns sender id


