<p align="center"><img src = "pigeon-logo.png" width="100" align = "center"></p>


# Pigeon - Scalable Notification System 

Pigeon is a distributed notification system designed to deliver messages reliably at scale. It supports multiple delivery channels and uses an event-driven architecture to ensure high throughput, low latency, and fault tolerance.

---

## Architecture Overview

<!-- Insert architecture diagram below -->

<!-- Example: ![Architecture](./assets/architecture.png) -->

---

## Overview

Pigeon enables external services (senders) to send notifications to their users through multiple channels:

* Email (Amazon SES)
* SMS
* Push Notifications

The system is built to handle large volumes of notifications while maintaining delivery reliability and system resilience.

---

## Core Concepts

### Sender

A sender is an external service that uses Pigeon to dispatch notifications. Each sender manages its own set of users and is authenticated using an API key.

### User

A user is a recipient of notifications. Users are associated with a specific sender and can receive notifications through one or more channels.

---

## Features

* Multi-channel notification delivery (SMS, Email, Push)
* Kafka-based asynchronous processing
* Database-driven user filtering
* Delivery status tracking
* Retry mechanism with exponential backoff
* Rate limiting and fault tolerance
* Horizontally scalable worker architecture

---

## System Flow

1. Sender initiates a notification request via API
2. Users are filtered from the database
3. Notification metadata is stored
4. Recipient entries are created
5. Messages are published to Kafka topics
6. Workers consume messages and deliver notifications
7. Delivery status is updated

---

## Technology Stack

* Backend: (e.g., Spring Boot / Node.js)
* Message Broker: Apache Kafka
* Database: PostgreSQL / MySQL
* Email Service: Amazon SES
* SMS Provider: External service (e.g., Twilio)
* Push Notifications: FCM / APNs
* Cache (optional): Redis

---

## API

### Send Notification

POST /notifications

Request Body:

* sender_id
* channels (SMS / EMAIL / PUSH)
* message
* filters

---

## Database Design (High-Level)

* Senders: Stores sender credentials and metadata
* Users: Stores user information mapped to senders
* Notifications: Stores notification details
* NotificationRecipients: Tracks delivery status per user

---

## Kafka Topics

* sms_topic
* email_topic
* push_topic

Each message contains:

* notification_id
* user_id
* channel
* payload

---

## Scalability

* Horizontal scaling through Kafka partitions
* Independent workers for each channel
* Batch processing for high throughput
* Data partitioning based on sender_id

---

## Reliability

* At-least-once delivery guarantee
* Retry mechanism with exponential backoff
* Dead-letter queue for failed messages

---

## Security

* API key-based authentication for senders
* Data isolation between senders
* Rate limiting to prevent abuse

---

## Future Improvements

* Notification scheduling
* In-app notifications
* User preference management interface
* Analytics and monitoring dashboard
* Priority-based delivery queues

---

[//]: # (## License)

[//]: # ()
[//]: # (MIT License)
