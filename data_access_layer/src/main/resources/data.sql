insert into ROLE(ID, ROLE_NAME) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO ACCOUNT(ID, USERNAME, PASSWORD,IS_ENABLED, READER_ID) VALUES
(1, 'admin','admin', TRUE,1 ),
(2, 'user', 'user', TRUE, 2 ),
(3, 'thanh', 'thanh', TRUE, 3 ),
(4, 'duy', 'duy', TRUE, 4 );

INSERT INTO USER_ROLE(USER_ID, ROLE_ID) VALUES (1,1),(2,2),(3,2 ),(4,2);
Insert into READER_TYPE (ID, BOOK_LIMIT , PERIOD_LIMIT , TYPE_NAME  ) values
(1, 2,  7,  N'Sinh viên '),
(2, 4, 10 ,N'Giảng viên '),
(3, 7,  10,  N'Sinh viên '),
(4, 10, 10 ,N'Sinh viên ');

insert into READER(ID, READER_ADDRESS, BIRTHDAY, DATE_CREATION, DATE_MODIFIED, EMAIL, NAME, PHONENUMBER, READER_CODE, SEX, MAILBOX_ID, TYPEUSER_ID) values
(1, N'190/33 Phan Văn Trị. Phường 12. Quận Bình Thạnh.TPHCM', '2012-12-12', '2012-12-12', '2012-12-12', 'phuc210495@gmail.com', N'Huỳnh Nguyễn Châu Duy', '01262532557','K40.104.156', N'Nam' , NULL , 1 ),
(2, N'190/33 Phan Văn Trị. Phường 12. Quận Bình Thạnh.TPHCM', '1995-04-21', '2017-03-06', '2017-03-06', 'diepthanhdatlims@gmail.com', N'Diệp Thanh Đạt', '01262532557','K40.104.156', N'Nam', NULL , 1 ),
(3, N'98 Đường số 11. Phường An Lạc, Quận Bình Tân. TPHCM', '1995-11-01', '2017-03-06', '2017-03-06', 'thanhdinhkyanon@gmail.com', N'Đinh Văn Thành', '01262532567','K40.104.156', N'Nam', NULL , 1 ),
(4, N'257 Lạc Long Quân. Phường 10, Quận 11. TPHCM', '1995-11-21', '2017-03-06', '2017-03-06', 'hatranlims@gmail.com', N'Trần Thị Hà', '01262532222','K40.104.156', N'Nữ', NULL , 1 );

insert into AUTHOR (ID,  AUTHOR_NAME  ) values
(1 ,N'Tuyết Anh - Minh Thư'),
(2 ,N'ThS.Trương Thị Ngọc Phượng'),
(3 ,N'ThS.Nguyễn Minh Đạo'),
(4 ,N'ThS.Đặng Đức Hậu'),
(5 ,N'Nguyễn Nhật Ánh'),
(6 ,N'Anh Khang'),
(7 ,N'Lê Thẩm Dương'),
(8 ,N'Nguyễn Phong Việt'),
(9 ,N'TS.Vũ Gia tê'),
(10 ,N'Đoàn Văn Ban - Đoàn Văn Trung'),
(11 ,N'Nguyễn Đình Chi'),
(12 ,N'Trịnh Thanh Đoan'),
(13 ,N'ThS.Trần Hữu Quốc Thư'),
(14 ,N'Mguye64n Tô Thành'),
(15, N'Đặng Ngọc Hoàn Thành'),
(16, N'ThS.Thanh Bình'),
(17, N'Trương Thị Khánh Hà'),
(18, N'Foreign Language'),
(19, N'TS.Nguyễn Chí Long'),
(20, N'Nguyễn Tuấn Anh'),
(21, N'Tống Đình Quý');


insert into CATEGORY (ID , CATEGORY_NAME )  values
(1, N'Ngoại ngữ'),
(2, N'Tin học'),
(3, N'Toán học'),
(4, N'Văn học'),
(5, N'Tâm lý'),
(6, N'Hóa học');


insert into PUBLISHER(ID , PUBLISHER_NAME, PUBLISHER_ADDRESS, PUBLISHER_EMAIL,  PUBLISHER_PHONENUMBER )  values
(1, N'NXB Đại học Sư phạm TPHCM', N'280 An Dương Vương. Quận 5. TPHCM', 'nxbdhsp@gmail.com','389745612'),
(2, N'NXB Giáo dục', N'81 Trần Hưng Đạo - TP. Hà Nội','nxbgiaoduc@gmail.com', '387945678');


insert into BOOK (ID, TITLE, QUANTITY, PRICE, BOOK_STATUS,  CATEGORY_ID, PUBLISHER_ID ,EDITION, BOOK_IMAGE ) values
(1, N'3420 Từ vựng cần biết cho Toeic', 1, 120000, N'Còn sách',1 ,2, 1, '/Image/3420-tu-vung-can-biet-cho-toeic.jpg' ),
(2, N'Lập trình Android', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/3556_Giao-trinh-Lap-trinh-Android.jpg' ),
(3, N'Lập trình WEB với ASP.NET', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/3601_Giao-trinh-lap-trinh-WEB-voi-ASP_NET.jpg' ),
(4, N'Bảy bước tới mùa hè', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/bay_buoc_toi_mua_he__nguyen_nhat_anh.jpg' ),
(5, N'Buồn làm sao buông', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/BuonLamSaoBuong.jpg' ),
(6, N'Cảm xúc là kẻ thù số một của thành công', 10, 120000, N'Còn sách',5 ,2, 1, '/Image/CamXuclaKeThuSo1CuaThanhCong.jpg' ),
(7, N'Cô gái đến từ hôm qua', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/CoGaiDenTuHomqua.jpg' ),
(8, N'Đi qua thương nhớ', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/DiQuaThuongNho.jpg' ),
(9, N'Bài tập xác suất thống kê', 10, 120000, N'Còn sách',3 ,1, 1, '/Image/BaiTapXacSuatThongKe.jpg' ),
(10, N'Đường hai ngã người thương thành lạ', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/Duong_hai_nga_Nguoi_thuong_thanh_la.jpg' ),
(11, N'Giáo trình Giải tích 1', 10, 120000, N'Còn sách',3 ,1, 1, '/Image/GiaiTich1.jpg' ),
(12, N'Giáo trình Giải tích 2', 10, 120000, N'Còn sách',3 ,1, 1, '/Image/GiaiTich2.jpg' ),
(13, N'Giáo trình Lập trình Java', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/Giáo trình ngôn ngữ lập trình Java - Đoàn Văn Ban.jpg' ),
(14, N'Hóa học Đại cương', 10, 120000, N'Còn sách',6 ,1, 1, '/Image/HoaDaiCuong.jpg' ),
(15, N'Hóa học Hữu cơ- Tập 1', 10, 120000, N'Còn sách',6 ,1, 1, '/Image/HoaHuuCo.jpg' ),
(16, N'Grannar for IELTS', 10, 120000, N'Còn sách',1 ,2, 1, '/Image/IELTS.jpg' ),
(17, N'Lập trình nâng cao trên ngôn ngữ Pascal', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/LapTrinhNangCao.jpg' ),
(18, N'Sinh ra để cô đơn', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/SinhRaLaDeCoDon.jpg' ),
(19, N'Luyện nghe Tiếng Anh', 10, 120000, N'Còn sách',1 ,2, 1, '/Image/tactics-for-listening-luyen-nghe-tieng-anh-co-ban-song-ngu-anh-viet.jpg' ),
(20, N'Giáo trình Tâm lý học phát triển', 10, 120000, N'Còn sách',5 ,2, 1, '/Image/TamLyHocPhatTrien.jpg' ),
(21, N'600 Essential Words For The Toeic', 10, 120000, N'Còn sách',1 ,2, 1, '/Image/Toeic600Word.jpg' ),
(22, N'Tôi thấy hoa vàng trên cỏ xanh', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/ToiThayHoaVangTrenCoXanh.jpg' ),
(23, N'Tô Pô Đại cương', 10, 120000, N'Còn sách',3 ,1, 1, '/Image/TOPODaiCuong.jpg' ),
(24, N'Trại hoa vàng', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/TraiHoaVang.jpg' ),
(25, N'Kỹ thuật lập trình hướng đối tượng bằng C++', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/Trang bia C++.PNG' ),
(26, N'Chuyện cổ tích dành cho người lớn', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/truyen-co-tich-danh-cho-nguoi-lon-nguyen-nhat-anh.jpg' ),
(27, N'Giáo trình xác suất thống kê', 10, 120000, N'Còn sách',3 ,2, 1, '/Image/XacSuatThongKe.jpg' ),
(28, N'Ngôn ngữ lập trình C', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/LapTrinhC.jpg' ),
(29, N'Lập trình hướng đối tượng C++', 10, 120000, N'Còn sách',2 ,2, 1, '/Image/OOP.jpg' ),
(30, N'Ngày trôi về phía cũ', 10, 120000, N'Còn sách',4 ,2, 1, '/Image/NgayTroiVePhiaCu.jpg' );

insert into BOOK_AUTHOR(BOOK_ID, AUTHOR_ID) values
(1,18),
(2,2),
(3,3),
(4,5),
(5,6),
(6,7),
(7,5),
(8,8),
(9,4),
(10,6),
(11,9),
(12,9),
(13,10),
(14,11),
(15,12),
(16,18),
(17,13),
(18,8),
(19,18),
(20,17),
(21,18),
(22,5),
(23,19),
(24,5),
(25,20),
(26,5),
(27,21),
(28,13),
(29,13),
(30,6);

Insert into BOOK_IMPORT (ID,  DATE_IMPORT, DATE_MODIFIED,  QUANTITY_IMPORT_BOOK) values
(1, '2017-03-14', '2017-03-25', 2),
(2, '2017-03-14', '2017-03-5', 2);

Insert into BOOK_BORROW (ID,  BORROW_DATE, DATE_MODIFIED,  RETURN_DATE, STATUS, READER_ID  ) values
(1, '2017-03-04', '2017-03-05', '2017-03-15', TRUE , 2),
(2, '2017-03-07', '2017-03-05', '2017-03-15', TRUE ,2);



-- sinh viên thì ko dc gia hạn ngày mượn sách nên BOOK_LIMIT=0  và  PERIOD_LIMIT=0
-- Tui lấy 2 dữ liệu đầu cho sinh viên và 2 cái cuối cho giảng viên (thời hạn gia hạn sách cho giảng viên max là 10 ngày)
-- Tui chưa rõ TYPE_NAME là gì nên chú thêm vào nhé


insert into BOOK_ORDER ( ID, DATE_MODIFIED, DATE_OF_APPROVAL, IS_APPROVAL, ORDER_DATE, TOTAL_MONEY, READER_ID) values
(1, '2017-03-04', '2017-03-05', FALSE , '2017-03-04', '120000', 1),
(2, '2017-03-05', '2017-03-06', FALSE , '2017-03-04', '120000', 1)	,
(3, '2017-03-04', '2017-03-05', FALSE , '2017-03-04', '120000', 2),
(4, '2017-03-05', '2017-03-06', FALSE , '2017-03-04', '120000', 2),
(5, '2017-03-05', '2017-03-06', FALSE , '2017-03-04', '130000', 1);

INSERT  INTO RECEIPT(ID, BOOK_ORDER_ID, CREATE_DATE, LIBRARIAN_ID, DATE_MODIFIED, RECEIPT_STATUS) VALUES
(1, 1, '2015-1-5', NULL , NULL , 'mới tạo'),
(2, 2, '2015-1-6', NULL , NULL , 'mới tạo'),
(3, 3, '2015-7-15', NULL , NULL , 'mới tạo'),
(4, 4, '2015-3-25', NULL , NULL , 'mới tạo');

INSERT  INTO  BOOK_ORDER_DETAIL(ID, BOOK_DETAIL_TITLE, BOOK_DETAIL_CATEGORY, BOOK_DETAIL_PUBLISHER, BOOK_DETAIL_AUTHOR, BOOK_DETAIL_QUANTITY) VALUES
(1, 'asdfsadf', 'asdfasd', 'asdfasf', 'asdfadf', 2),
(2, 'asdfsadf', 'asdfasd', 'asdfasf', 'asdfadf', 2),
(3, 'asdfsadf', 'asdfasd', 'asdfasf', 'asdfadf', 2),
(4, 'asdfsadf', 'asdfasd', 'asdfasf', 'asdfadf', 2),
(5, 'asdfsadf', 'asdfasd', 'asdfasf', 'asdfadf', 2);

INSERT  INTO BOOK_ORDER_AND_BOOK_ORDER_DETAIL(BOOK_ORDER_ID, BOOK_ORDER_DETAIL_ID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- ALTER TABLE RECEIPT ALTER COLUMN ID RESTART WITH 5;





