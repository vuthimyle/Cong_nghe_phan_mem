-- Tạo database
CREATE DATABASE IF NOT EXISTS thanhtoantragop;
USE thanhtoantragop;

-- Bảng khách hàng
CREATE TABLE tblClient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    idCard VARCHAR(20),
    tel VARCHAR(20),
    address VARCHAR(255),
    email VARCHAR(255),
    note VARCHAR(255)
);

-- Bảng đối tác
CREATE TABLE tblPartner (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    tel VARCHAR(20)
);

-- Bảng mặt hàng
CREATE TABLE tblItem (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    unit VARCHAR(20),
    price INT,
    tblPartnerid INT,
    FOREIGN KEY (tblPartnerid) REFERENCES tblPartner(id)
);

-- Bảng hợp đồng
CREATE TABLE tblContract (
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    loanAmount INT,
    interestRate FLOAT(10),
    tblClientid INT,
    tblPartnerid INT,
    FOREIGN KEY (tblClientid) REFERENCES tblClient(id),
    FOREIGN KEY (tblPartnerid) REFERENCES tblPartner(id)
);

-- Bảng chi tiết hợp đồng (khóa chính là (tblContractid, tblItemid))
CREATE TABLE tblItemDetail (
    quantity INT,
    tblContractid INT,
    tblItemid INT,
    PRIMARY KEY (tblContractid, tblItemid),
    FOREIGN KEY (tblContractid) REFERENCES tblContract(id),
    FOREIGN KEY (tblItemid) REFERENCES tblItem(id)
);

-- Bảng hóa đơn
CREATE TABLE tblBill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dueDate DATE,
    amountDue INT,
    amountPaid INT,
    paymentDate DATE,
    status VARCHAR(255),
    tblClientid INT,
    tblContractid INT,
    FOREIGN KEY (tblClientid) REFERENCES tblClient(id),
    FOREIGN KEY (tblContractid) REFERENCES tblContract(id)
);

-- ---------------------------------------------------
-- Dữ liệu mẫu
-- ---------------------------------------------------

-- Khách hàng
INSERT INTO tblClient (name, idCard, tel, address, email, note) VALUES
('Nguyen Van A', '123456789', '0912345678', 'Ha Noi', 'a@gmail.com', 'Khách thân thiết'),
('Tran Thi B', '987654321', '0987654321', 'HCM', 'b@gmail.com', 'Ưu tiên'),
('Le Van C', '555555555', '0900000000', 'Da Nang', 'c@gmail.com', '');

-- Đối tác
INSERT INTO tblPartner (name, address, tel) VALUES
('CTCP ABC', 'Ha Noi', '0241234567'),
('CTCP XYZ', 'HCM', '0287654321');

-- Mặt hàng
INSERT INTO tblItem (name, unit, price, tblPartnerid) VALUES
('Laptop Dell', 'cái', 15000000, 1),
('Máy in HP', 'cái', 3000000, 1),
('Camera Hikvision', 'cái', 2000000, 2),
('Bàn phím cơ', 'cái', 800000, 2);

-- Hợp đồng
INSERT INTO tblContract (date, loanAmount, interestRate, tblClientid, tblPartnerid) VALUES
('2024-05-01', 20000000, 6.5, 1, 1),
('2024-05-10', 5000000, 7.2, 2, 2),
('2024-06-01', 8000000, 5.0, 3, 1);

-- Chi tiết hợp đồng
INSERT INTO tblItemDetail (quantity, tblContractid, tblItemid) VALUES
(1, 1, 1), -- Hợp đồng 1, 1 Laptop Dell
(2, 1, 2), -- Hợp đồng 1, 2 Máy in HP
(3, 2, 3), -- Hợp đồng 2, 3 Camera Hikvision
(2, 3, 4); -- Hợp đồng 3, 2 Bàn phím cơ

-- Hóa đơn
INSERT INTO tblBill (dueDate, amountDue, amountPaid, paymentDate, status, tblClientid, tblContractid) VALUES
('2024-06-01', 5000000, 5000000, '2024-06-01', 'Đã thanh toán', 1, 1),
('2024-06-15', 2000000, 2000000, '2024-06-16', 'Đã thanh toán', 2, 2),
('2024-07-01', 3000000, 0, NULL, 'Chưa thanh toán', 3, 3);
