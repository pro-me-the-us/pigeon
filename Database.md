# Pigeon - Database Design

## 1. Overview

Supports:

* Sender → User mapping
* Notification storage
* Delivery tracking
* Filtering

Tech:

* Relational DB (PostgreSQL/MySQL)
* Kafka (streaming)
* Optional NoSQL (logs)

---

## 2. Tables

### Senders

* sender_id (PK, UUID)
* name
* api_key
* created_at

---

### Users

* user_id (PK, UUID)
* sender_id (FK)
* email
* phone
* device_token
* created_at

Indexes:

* sender_id
* email
* phone

---

### UserPreferences

* user_id (FK)
* channel (SMS / EMAIL / PUSH)
* enabled (boolean)

---

### Notifications

* notification_id (PK)
* sender_id (FK)
* message
* channels (JSON)
* status (queued/sent/failed)
* created_at

---

### NotificationRecipients

* id (PK)
* notification_id (FK)
* user_id (FK)
* channel
* status
* retry_count
* last_attempt_at

Indexes:

* notification_id
* user_id

---

## 3. Kafka Topics

* sms_topic
* email_topic
* push_topic

Message format:

* notification_id
* user_id
* channel
* payload

---

## 4. Data Flow

1. Sender calls API
2. Users filtered from DB
3. Notification record created
4. Recipients inserted (bulk)
5. Messages pushed to Kafka
6. Workers consume & send
7. Status updated

---

## 5. Scaling

### Sharding

* Users → by sender_id
* Notifications → by time

---

### Caching

* Redis:

    * user preferences
    * rate limiting

---

### Write Optimization

* Batch inserts
* Append-only logs

---

## 6. Design Decisions

* Kafka for decoupling & scale
* Separate recipient table avoids duplication
* Channel-based workers simplify scaling
