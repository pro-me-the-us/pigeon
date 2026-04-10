# Pigeon - Notification System Requirements

## 1. Overview

Pigeon is a distributed notification system that allows external entities (senders) to send notifications to a group of users via multiple channels such as Email (Amazon SES), Push Notifications, and SMS.

---

## 2. Actors

### Sender

* Any service or client using Pigeon to send notifications
* Each sender owns a set of users

### User

* End recipient of notifications
* Associated with one or more senders

---

## 3. Functional Requirements (FR)

### FR1: Multi-Channel Notification

* Support:

    * Email (Amazon SES)
    * SMS
    * Push Notifications
* Allow multiple channels per request

---

### FR2: Sender → User Mapping

* Each sender has its own user base
* Notifications are scoped to sender users only

---

### FR3: Notification API

Endpoint:
POST /notifications

Request Body:

* sender_id
* channels (SMS / EMAIL / PUSH)
* message
* filters

---

### FR4: User Filtering

* Users are filtered from DB before sending
* Filters may include:

    * location
    * preferences
    * activity

---

### FR5: Kafka Queueing

* Filtered users are pushed to Kafka
* Separate topics:

    * sms_topic
    * email_topic
    * push_topic

---

### FR6: Asynchronous Processing

* Workers consume Kafka topics
* Channel-specific workers handle delivery

---

### FR7: Delivery Tracking

Statuses:

* queued
* sent
* failed
* delivered

---

### FR8: Retry Mechanism

* Failed messages retried with backoff
* Dead-letter queue for failures

---

### FR9: Idempotency

* Prevent duplicate sends
* Use idempotency key per request

---

### FR10: Logging & Analytics

* Track:

    * delivery success rate
    * failures
    * latency

---

## 4. Non-Functional Requirements (NFR)

### Scalability

* Handle millions of notifications
* Horizontal scaling via Kafka + workers

---

### High Availability

* No single point of failure

---

### Low Latency

* Near real-time for critical notifications

---

### Reliability

* At-least-once delivery

---

### Fault Tolerance

* Handle external service failures (SES/SMS)

---

### Rate Limiting

* Prevent spam per sender/user

---

### Extensibility

* Add new channels easily

---

### Security

* API key authentication
* Protect user data

---

### Observability

* Metrics: throughput, latency, failures

---

## 5. Assumptions

* Kafka is used for messaging
* SES for email
* External SMS & Push providers
