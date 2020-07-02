
CREATE TABLESPACE faizal_f_06995
datafile �E:\PRAKTIKUM SEMESTER  4\basdat\Modul 1\penjualan_skincare.dbf�
size 40M;

CREATE USER faizal_febri_06995
IDENTIFIED BY faizal
DEFAULT TABLESPACE faizal_f_06995
QUOTA 40M ON faizal_f_06995;

GRANT ALL PRILEGES TO faizal_febri_06995;

conn faiza_febri_06995/faizal;

CREATE TABLE Pembeli_06995
(
Id_Pembeli INTEGER not null,
Nama_Pembeli VARCHAR2(20),
No_Telp NUMBER(12),
constraint PK_Pembeli primary key (No_Pembeli)
);

CREATE TABLE ORDER_06995
(
No_Antrian INTEGER not null,
Id_Pembeli INTEGER,
Alamat VARCHAR2(100),
Jml_Produk INTEGER,
Total INTEGER,
constraint PK_Order primary key (No_Antrian)
);

CREATE TABLE Transaksi
(
No_Transaksi INTEGER not null,
No_Antrian INTEGER,
Jenis_Transaksi VARCHAR2(10),
Harga INTEGER,
constraint PK_Transaksi primary key (ID_Transaksi)
);

CREATE TABLE Produk
(
ID_Produk INTEGER not null,
No_BPOM INTEGER,
Nama_Produk VARCHAR2(20),
Harga_Satuan INTEGER,
Stock INTEGER,
Jenis_Produk VARCHAR2(10),
constraint PK_Produk primary key (ID_Produk)
);

ALTER TABLE ORDER_06995
add constraint FK_ID_Pembeli FOREIGN KEY (ID_Pembeli)
references Pembeli(ID_Pembeli);

ALTER TABLE Transaksi
add constraint FK_No_Anntrian FOREIGN KEY (No_Antrian)
references ORDER_06995(NO_Antrian);

CREATE sequence ID_Pembeli
minvalue 1
maxvalue 1000
start with 1 
increment by 1
cache 30;

CREATE sequence No_antrian
minvalue 1
maxvalue 1000
start with 1 
increment by 1
cache 30;

CREATE sequence No_Transaksi
minvalue 1
maxvalue 1000
start with 1 
increment by 1
cache 30;

CREATE sequence ID_produk
minvalue 1
maxvalue 1000
start with 1 
increment by 1
cache 30;

CREATE VIEW LIST_PRODUK AS
SELECT * FROM PRODUK;

INSERT INTO LIST_PRODUK VALUES (12, 12, 'FACIALWASH', 34000, 40, 'SERUM');

CREATE VIEW LIST_DETAIL AS
SELECT b.NAMA_PEMBELI_06995, b.NO_TELP, a.NAMA_PRODUK, a.ALAMAT
FROM ORDER_06995 a JOIN
PEMBELI_06995 b ON
a.ID_PEMBELI = b.ID_PEMBELI;

CREATE VIEW LIST_ORDERAN AS
SELECT a.NAMA_PEMBELI_06995, b.NAMA_PRODUK, c.HARGA, a.NO_TELP
FROM PEMBELI_06995 a LEFT JOIN ORDER_06995 b
ON a.ID_PEMBELI = b.ID_PEMBELI
LEFT JOIN TRANSAKSI c
ON b.NO_ANTRIAN = c.NO_ANTRIAN
WHERE NO_TRANSAKSI <= (SELECT AVG(HARGA) FROM TRANSAKSI);

CREATE VIEW LIST_ORDERAN_2 AS
SELECT a.NO_TELP, a.ID_PEMBELI, b.NAMA_PRODUK, c.HARGA
FROM PEMBELI_06995 a RIGHT JOIN ORDER_06995 b
ON a.ID_PEMBELI = b.ID_PEMBELI
RIGHT JOIN TRANSAKSI c
ON b.NO_ANTRIAN = c.NO_ANTRIAN
WHERE NO_TRANSAKSI <= (SELECT COUNT(NO_ANTRIAN) FROM TRANSAKSI
WHERE NO_TRANSAKSI < (SELECT MAX(NO_ANTRIAN) FROM TRANSAKSI)
AND NO_ANTRIAN > (SELECT COUNT(NO_ANTRIAN) FROM TRANSAKSI));

SELECT * FROM ORDER_06995 JOIN PEMBELI_06995 ON ORDER_06995.ID_PEMBELI = PEMBELI_06995.ID_PEMBELI;

SELECT * FROM TRANSAKSI JOIN ORDER_06995 ON TRANSAKSI.NO_ANTRIAN = ORDER_06995.NO_ANTRIAN JOIN PEMBELI_06995 ON ORDER_06995.ID_PEMBELI = PEMBELI_06995.ID_PEMBELI;

COMMIT;
