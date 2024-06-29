table customer...

    create table customer(id bigint primary key, name varchar, createdby varchar,
        created datetime, modifiedby varchar, modified datetime, version int)

SQL customer CRUD...

    INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?)
    SELECT * FROM customer WHERE id = ?
    UPDATE customer SET name = ?, modifiedBy = ?, modified = ?, version = ?
        WHERE id = ? and version = ?
    DELETE FROM customer WHERE id = ? and version = ?