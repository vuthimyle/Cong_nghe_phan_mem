CREATE DATABASE IF NOT EXISTS thanhtoantragop;
USE thanhtoantragop;

-- Bảng khách hàng
CREATE TABLE tblClient (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    idCard VARCHAR(20),
    tel VARCHAR(20),
    address VARCHAR(255),
    email VARCHAR(255),
    note VARCHAR(255)
);

-- Bảng đối tác
CREATE TABLE tblPartner (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    tel VARCHAR(20)
);

-- Bảng mặt hàng
CREATE TABLE tblItem (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(255),
    unit VARCHAR(20),
    price INTEGER,
    tblPartnerid VARCHAR(20),
    FOREIGN KEY (tblPartnerid) REFERENCES tblPartner(id)
);

-- Bảng hợp đồng
CREATE TABLE tblContract (
    id VARCHAR(20) PRIMARY KEY,
    date DATE,
    loanAmount INTEGER,
    interestRate FLOAT(10),
    tblClientid VARCHAR(20),
    tblPartnerid VARCHAR(20),
    FOREIGN KEY (tblClientid) REFERENCES tblClient(id),
    FOREIGN KEY (tblPartnerid) REFERENCES tblPartner(id)
);

-- Bảng chi tiết hợp đồng
CREATE TABLE tblItemDetail (
    quantity INTEGER,
    tblContractid VARCHAR(20),
    tblItemid VARCHAR(20),
    PRIMARY KEY (tblContractid, tblItemid),
    FOREIGN KEY (tblContractid) REFERENCES tblContract(id),
    FOREIGN KEY (tblItemid) REFERENCES tblItem(id)
);

-- Bảng hóa đơn
CREATE TABLE tblBill (
    id VARCHAR(20) PRIMARY KEY,
    dueDate DATE,
    amountDue INTEGER,
    amountPaid INTEGER,
    paymentDate DATE,
    status VARCHAR(255),
    tblClientid VARCHAR(20),
    tblContractid VARCHAR(20),
    FOREIGN KEY (tblClientid) REFERENCES tblClient(id),
    FOREIGN KEY (tblContractid) REFERENCES tblContract(id)
);

-- Thêm khách hàng
INSERT INTO tblClient VALUES 
('C001', 'Nguyen Van A', '123456789', '0912345678', 'Hanoi', 'a@gmail.com', 'Khách quen'),
('C002', 'Tran Thi B', '987654321', '0987654321', 'HCM', 'b@gmail.com', 'Ưu tiên'),
('C003', 'Le Van C', '555555555', '0900000000', 'Da Nang', 'c@gmail.com', '');

-- Thêm đối tác
INSERT INTO tblPartner VALUES 
('P001', 'CTCP ABC', 'Ha Noi', '0241234567'),
('P002', 'CTCP XYZ', 'HCM', '0287654321');

-- Thêm mặt hàng (liên kết partner)
INSERT INTO tblItem VALUES 
('I001', 'Laptop Dell', 'cái', 15000000, 'P001'),
('I002', 'Máy in HP', 'cái', 3000000, 'P001'),
('I003', 'Camera Hikvision', 'cái', 2000000, 'P002'),
('I004', 'Bàn phím cơ', 'cái', 800000, 'P002');

-- Thêm hợp đồng (liên kết client & partner)
INSERT INTO tblContract VALUES 
('CT001', '2024-05-01', 20000000, 6.5, 'C001', 'P001'),
('CT002', '2024-05-10', 5000000, 7.2, 'C002', 'P002'),
('CT003', '2024-06-01', 8000000, 5.0, 'C003', 'P001');

-- Thêm chi tiết hợp đồng (liên kết hợp đồng & item)
INSERT INTO tblItemDetail VALUES
(1, 'CT001', 'I001'),
(2, 'CT001', 'I002'),
(3, 'CT002', 'I003'),
(2, 'CT003', 'I004');

-- Thêm hóa đơn (liên kết client & contract)
INSERT INTO tblBill VALUES
('B001', '2024-06-01', 5000000, 5000000, '2024-06-01', 'Đã thanh toán', 'C001', 'CT001'),
('B002', '2024-06-15', 2000000, 2000000, '2024-06-16', 'Đã thanh toán', 'C002', 'CT002'),
('B003', '2024-07-01', 3000000, 0, NULL, 'Chưa thanh toán', 'C003', 'CT003');
