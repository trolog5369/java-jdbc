## Data Consistency

Let’s assume we have two accounts in the database:

- `acc123` → 1000 Rs
- `acc456` → 2000 Rs

Total database state:  
**1000 + 2000 = 3000 Rs**

Now we perform a transaction where **500 Rs** is transferred from `acc123` to `acc456`.

### Expected Transaction Result

- `acc123` (debit 500 Rs) → **500 Rs**
- `acc456` (credit 500 Rs) → **2500 Rs**

Total database state after transaction:  
**500 + 2500 = 3000 Rs**

The total amount remains unchanged. This is **data consistency**.

---

## What Is Data Consistency?

**Data consistency** means that the database remains in a valid and correct state throughout all operations.

- No ambiguity
- No partial updates
- No unexpected errors
- No change in total logical state

The database must always reflect correct business rules.

---

## When Does Data Inconsistency Occur?

Consider the same transaction:

- Transfer **500 Rs** from `acc123` to `acc456`
- Initial total state: **3000 Rs**

### Failure Scenario

1. `acc123` is debited successfully
    - New balance: **1000 − 500 = 500 Rs**
2. An error occurs **before** `acc456` is credited

Resulting balances:

- `acc123` → **500 Rs**
- `acc456` → **2000 Rs**

Total database state:  
**500 + 2000 = 2500 Rs**

The total amount has changed.  
This is **database inconsistency** and represents a system failure.

---

## Preventing Data Inconsistency (Transaction Handling)

To avoid such issues, we use **transaction handling**.

Java JDBC provides transaction control mechanisms. The two most important ones are:

1. `commit`
2. `rollback`

---

## Commit

- A transaction is started
- `acc123` is debited by 500 Rs
- `acc456` is credited by 500 Rs
- Both operations succeed
- `commit` is executed

✅ Changes are permanently saved  
✅ Transaction is completed successfully

---

## Rollback

- A transaction is started
- Data is modified from its original state
- An error or failure occurs during execution
- `rollback` is executed

❌ All changes are undone  
❌ Database is restored to its original state  
❌ No partial updates remain

---

## Conclusion

Transaction handling ensures:

- Atomicity (all or nothing)
- Data consistency
- System reliability
- Safe database operations
