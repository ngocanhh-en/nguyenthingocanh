CREATE DATABASE ThucTap;
USE ThucTap;
CREATE TABLE TBLKhoa(
	 Makhoa char(10) PRIMARY KEY,
	 Tenkhoa char(30),
	 Dienthoai char(10)
);
CREATE TABLE TBLGiangVien(
	magv int PRIMARY KEY,
	hotengv char(30),
	luong decimal(5,2),
	makhoa char(10) REFERENCES TBLKhoa
);
CREATE TABLE TBLSinhVien(
	masv int primary key,
	hotensv char(40),
	namsinh int,
	quequan char(30),
    makhoa char(10),FOREIGN KEY (makhoa) REFERENCES TBLKhoa(makhoa)
);
CREATE TABLE TBLDeTai(
	madt char(10)primary key,
	tendt char(30),
	kinhphi int,
	noithuctap char(30)
);
CREATE TABLE TBLHuongDan(
	masv int primary key,
	madt char(10),FOREIGN KEY (madt) REFERENCES TBLDeTai(madt),
	magv int, FOREIGN KEY(magv) references TBLGiangVien(magv),
	ketqua decimal(5,2)
);
INSERT INTO TBLKhoa VALUES
	('Geo','Dia ly va QLTN',3855413),
	('Math','Toan',3855411),
	('Bio','Cong nghe Sinh hoc',3855412);
INSERT INTO TBLGiangVien VALUES
	(11,'Thanh Binh',700,'Geo'),    
	(12,'Thu Huong',500,'Math'),
	(13,'Chu Vinh',650,'Geo'),
	(14,'Le Thi Ly',500,'Bio'),
	(15,'Tran Son',900,'Math');
INSERT INTO TBLSinhVien VALUES
	(1,'Le Van Son',1990,'Nghe An','Bio'),
	(2,'Nguyen Thi Mai',1990,'Thanh Hoa','Geo'),
	(3,'Bui Xuan Duc',1992,'Ha Noi','Math'),
	(4,'Nguyen Van Tung',null,'Ha Tinh','Bio'),
	(5,'Le Khanh Linh',1989,'Ha Nam','Bio'),
	(6,'Tran Khac Trong',1991,'Thanh Hoa','Geo'),
	(7,'Le Thi Van',null,'null','Math'),
	(8,'Hoang Van Duc',1992,'Nghe An','Bio');
INSERT INTO TBLDeTai VALUES
	('Dt01','GIS',100,'Nghe An'),
	('Dt02','ARC GIS',500,'Nam Dinh'),
	('Dt03','Spatial DB',100, 'Ha Tinh'),
	('Dt04','MAP',300,'Quang Binh' );
INSERT INTO TBLHuongDan VALUES
	(1,'Dt01',13,8),
	(2,'Dt03',14,0),
	(3,'Dt03',12,10),
	(5,'Dt04',14,7),
	(6,'Dt01',13,Null),
	(7,'Dt04',11,10),
	(8,'Dt03',15,6);

-- Câu 1:
SELECT GV.magv, GV.hotengv, K.tenkhoa
FROM TBLGiangVien GV join TBLKhoa K
ON GV.makhoa = K.makhoa;
-- Câu 2:
SELECT GV.magv, GV.hotengv, K.tenkhoa
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.makhoa = K.makhoa
WHERE K.Tenkhoa = 'Dia ly va QLTN';
-- Câu 3:
SELECT COUNT(SV.masv) AS SỐ_SV
FROM TBLSinhVien SV
WHERE TBLKhoa.Makhoa=SV.makhoa AND Makhoa=`Bio`;
-- Câu 4:
SELECT SV.Masv, SV.Hotensv
FROM TBLSinhVien SV JOIN TBLKhoa K
ON SV.Makhoa = K.Makhoa
WHERE K.Tenkhoa='TOAN';
-- Câu 5:
SELECT COUNT(GV.Magv) AS SỐ_GV
FROM TBLGiangVien GV join TBLKhoa K
ON GV.Makhoa = K.Makhoa
WHERE K.Tenkhoa='CONG NGHE SINH HOC';
-- Câu 6:
SELECT SV.Masv,SV.Hotensv
FROM TBLSinhVien SV 
WHERE NOT EXISTS(
	SELECT HD.Masv
	FROM TBLHuongDan HD 
	WHERE SV.Masv = HD.Masv);
-- Câu 7:
SELECT K.Makhoa,K.Tenkhoa, COUNT(K.Makhoa) AS SO_GV
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.Makhoa = K.Makhoa
GROUP BY K.Makhoa,K.Tenkhoa;
-- CÂU 8:
SELECT k.Dienthoai
FROM TBLKhoa K join TBLSinhVien SV
ON K.Makhoa = SV.Makhoa
WHERE SV.Hotensv = 'Le Van Son';
-- CÂU 9:
SELECT DT.Madt,DT.Tendt
FROM TBLGiangVien GV join TBLHuongDan HD
ON GV.Magv = HD.Magv
join TBLDeTai DT
ON DT.Madt = HD.Madt
WHERE GV.Hotengv = 'Tran Son';
-- Câu 10:
SELECT DT.Madt,DT.Tendt
FROM TBLDeTai DT
WHERE NOT EXISTS(
	SELECT HD.Madt
	FROM TBLHuongDan HD
	WHERE HD.Madt = DT.Madt);
-- Câu 11:
SELECT GV.Magv,GV.Hotengv,K.Tenkhoa
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.Makhoa = K.Makhoa
WHERE GV.Magv IN (
	SELECT HD.Magv
	FROM TBLHuongDan HD
	GROUP BY HD.Magv
	HAVING COUNT(HD.MaSV)>3);
-- Câu 12:
SELECT DT.Madt,DT.Tendt
FROM TBLDeTai DT 
WHERE DT.Kinhphi = (
	SELECT MAX(DT.Kinhphi)
	FROM TBLDeTai DT);
-- Câu 13:
SELECT DT.Madt,DT.Tendt
FROM TBLDeTai DT
WHERE DT.Madt in (
	SELECT HD.Madt
	FROM TBLHuongDan HD
	GROUP BY HD.Madt
	HAVING COUNT(HD.Madt) > 2);
-- Câu 14:
SELECT SV.Masv,SV.Hotensv,HD.KetQua
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON SV.Masv = HD.Masv
JOIN TBLKhoa K
ON K.Makhoa = SV.Makhoa
WHERE K.Tenkhoa = 'Dia ly va QLTN';
-- Câu 15:
SELECT K.Tenkhoa, COUNT(SV.Masv) AS Số_SV
FROM TBLSinhVien SV JOIN TBLKhoa K
ON SV.Makhoa = K.Makhoa
GROUP BY K.Tenkhoa;
-- Câu 16: 
SELECT *
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON HD.Masv = SV.Masv
JOIN TBLDeTai DT
ON DT.Madt = HD.Madt
WHERE SV.Quequan = DT.Noithuctap;
-- Câu 17:
SELECT *
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON HD.Masv = SV.Masv
WHERE HD.KetQua is Null;
-- Câu 18:
SELECT SV.Masv,SV.Hotensv
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON HD.Masv = SV.Masv
WHERE HD.KetQua = 0;
