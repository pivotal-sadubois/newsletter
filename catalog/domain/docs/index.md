# Guestbook Application (domain/docs/index.md) 

Guestbook is a sample application that records visitors' messages and displays a cloud banner with an administrative message. The applicaiton is writen in a clasical microservice architecture where the induvidual components such as the Guestbook Portal (portal-ui) and the Portal Backend (portal-backend), User Management (user-profile) acts as an individual service with a AngularJS Frontent (user-profile-ui) and an Spring Boot basing REST API Service (user-profile-backend and with a PostgreSQL Databse acting as the Persistent data store. 

The main business logic is written in a cloud-agnostic manner using MySQL, the generic blob API, and the generic runtimevar API.

![Blockchain Workflow Diagram](https://upload.wikimedia.org/wikipedia/commons/3/3a/Blockchain_workflow.png)

A blockchain is “a distributed database that maintains a continuously growing list of ordered records, called blocks.” These blocks “are linked using cryptography. Each block contains a cryptographic hash of the previous block, a timestamp, and transaction data. A blockchain is a decentralized, distributed and public digital ledger that is used to record transactions across many computers so that the record cannot be altered retroactively without the alteration of all subsequent blocks and the consensus of the network.” -- Wikipedia, https://en.wikipedia.org/wiki/Blockchain

