# JDBC Image Handling (Insert & Retrieve)

This module demonstrates how to **store and retrieve images in a MySQL database using JDBC**.  
Images are handled as binary data and stored using **BLOB/LONGBLOB** types.

---

## 📌 What This Covers

- Inserting an image into MySQL using `PreparedStatement`
- Retrieving an image from MySQL and saving it back to the filesystem
- Working with binary data using `byte[]`
- Using `FileInputStream` and `FileOutputStream`
- JDBC connection and query execution flow

---

## 🗄️ Database Setup

**Database:** `mydatabase`  
**Table:** `image_table`

```sql
CREATE TABLE image_table (
    image_id INT AUTO_INCREMENT PRIMARY KEY,
    image_data LONGBLOB NOT NULL,
    upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
## Why LONGBLOB?

- Images are binary data, not text.
- `LONGBLOB` supports very large image sizes (up to 4GB).
- Images are stored internally as **Binary Large Objects (BLOB)**, which makes them safe for binary storage without data corruption.

---

## 📥 Image Insertion Flow

1. Select an image from the local filesystem.
2. Load the image using `FileInputStream`.
3. Convert the image into a `byte[]`.
4. Insert the binary data using `PreparedStatement`.
5. Store the image in the database as a `LONGBLOB`.

---

## Key JDBC Concepts Used

- `PreparedStatement`
- `setBytes()`
- Binary-safe SQL execution

---

## 📤 Image Retrieval Flow

1. Fetch image data using the primary key (`image_id`).
2. Read binary data into a `byte[]`.
3. Write binary data back to a file using `FileOutputStream`.
4. Save the extracted image to the local directory.
