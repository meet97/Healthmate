USE [Gtu_Healthmate]
GO
SET IDENTITY_INSERT [dbo].[locationdetails] ON 

INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (12, N'85/A Hirabag Society Part-12', N'Bopal', N'Ahmedabad', N'Gujarat', N'India', N'380061', 1, CAST(0x0000A89A014396B1 AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (16, N'Near naranpura police station', N'Naranpura', N'Ahmedabad', N'Gujarat', N'India', N'380061', 1, CAST(0x0000A87801855F82 AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (17, N'Near Swastik Cross Road', N'Navrangpura', N'Ahmedabad', N'Gujarat', N'India', N'380061', 1, CAST(0x0000A8780185ADAD AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (24, N'Hirabag Society Part-1', N'Ghatlodia', N'Ahmedabad', N'Gujarat', N'India', N'380061', 1, CAST(0x0000A878018B32CF AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (26, N'85/A Hirabag society ', N'Ghatlodia', N'Ahmedabad', N'Gujarat', N'India', N'380061', 1, CAST(0x0000A87C00A927DD AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (38, N'near. Satyam Mall', N'Vastrapur', N'Ahmedabad', N'Gujarat', N'India', N'380062', 1, CAST(0x0000A88C012AE94B AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (1026, N'Opposite Arise Farm', N'Gota', N'Ahmedabad', N'Gujarat', N'India', N'380063', 1, CAST(0x0000A87C00B37452 AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (1027, N'Opposite Oriental bank', N'Bopal', N'Ahmedabad', N'Gujarat', N'India', N'380632', 1, CAST(0x0000A87C00BE1E00 AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (1028, N'near maratha mandir', NULL, N'Mumbai', N'Maharashtra', N'India', N'426356', 1, CAST(0x0000A88C0133885E AS DateTime))
INSERT [dbo].[locationdetails] ([location_id], [address], [area], [city], [state], [country], [pincode], [flag], [date_time]) VALUES (1029, N'Marol Maroshi Road', N'Andheri East', N'Mumbai', N'Maharashtra', N'India', N'400059', 1, CAST(0x0000A88C013651B8 AS DateTime))
SET IDENTITY_INSERT [dbo].[locationdetails] OFF
SET IDENTITY_INSERT [dbo].[hospitaldetails] ON 

INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (1, 12, N'Sterling Hospital', N'7016141096', N'8866258602', N'sterling@gmail.com', NULL, 1, CAST(0x0000A86E00063209 AS DateTime))
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (2, 26, N'Sal Hospital', N'9879027864', NULL, N'sal@hospital.com', NULL, 1, NULL)
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (3, 12, N'Zydus Hospital', N'9898784589', NULL, N'zydus.hospital@gmail.com', N'zydus@yahoo.in', 1, NULL)
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (4, 24, N'Civil Hospital', N'7563256965', N'8554263563', N'civilhospital@yahoo.in', NULL, 1, NULL)
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (29, 17, N'EyeCare', N'9898686893', N'9658326595', N'eyecare@gmail.com', NULL, 1, CAST(0x0000A88C012AE94B AS DateTime))
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (1018, 1026, N'Sanjivni Hospital', N'8659658965', NULL, N'sanjivni@healthcare.com', NULL, 1, CAST(0x0000A87C00B37452 AS DateTime))
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (1019, 1027, N'Chokshi Children Hospital', N'9173377350', NULL, N'vishweshchokshi@gmail.com', NULL, 1, CAST(0x0000A87C00BE1E00 AS DateTime))
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (1020, 1029, N'SevenHills Hospital', N'2267676767', N'7859658965', N'sevenhills8596@gmail.com', NULL, 1, CAST(0x0000A88C013651B8 AS DateTime))
INSERT [dbo].[hospitaldetails] ([hospital_id], [location_id], [hospitalname], [mobile1], [mobile2], [emailid1], [emailid2], [flag], [date_time]) VALUES (2020, 1027, N'Shubham Hospital', N'9856236569', NULL, N'shubham@hospital.com', NULL, 1, CAST(0x0000A88C013651B8 AS DateTime))
SET IDENTITY_INSERT [dbo].[hospitaldetails] OFF
SET IDENTITY_INSERT [dbo].[logindetails] ON 

INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (7, N'keyul31@gmail.com', N'123456789', N'user', 1, CAST(0x0000A89A014396B1 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (12, N'AnkurAgrawal29@yahoo.com', N'123456789', N'doctor', 1, CAST(0x0000A88C0130DDC7 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (13, N'Hitesh4837@gmail.com', N'123456789', N'doctor', 0, CAST(0x0000A88C0130EB26 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (14, N'jayul_kamdar85@gmail.com', N'123456789', N'doctor', 1, CAST(0x0000A88C0130DFDC AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (15, N'Rajguru965@yahoo.in', N'123456798', N'doctor', 0, CAST(0x0000A88C0130EFBE AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (16, N'Ravish_atha398@yahoo.in', N'123456789', N'doctor', 1, CAST(0x0000A88C0130E138 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (17, N'shaikhali4253@gmail.com', N'123456789', N'doctor', 1, CAST(0x0000A88C0130E303 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (18, N'admin@healthmate.com', N'healthmate', N'admin', 1, NULL)
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (37, N'keyul.31@gmail.com', N'123123123', N'user', 1, CAST(0x0000A87C00AB576E AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (38, N'ashwin199997@gmail.com', N'123456789', N'doctor', 1, CAST(0x0000A88C0130E581 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (2037, N'arpit@gmail.coo', N'123123123', N'doctor', 0, CAST(0x0000A88C0130ED7C AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (2038, N'vishweshchokshi@gail.com', N'12121212', N'doctor', 1, CAST(0x0000A88C0130E839 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (2039, N'aman1908@yopmail.com', N'123456789', N'user', 1, CAST(0x0000A88C0133885E AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (2040, N'kush.sculptsoft@gmail.com', N'123456789', N'user', 1, CAST(0x0000A88C01346834 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (2041, N'kushsculptsoft289@gmail.com', N'123456789', N'doctor', 1, CAST(0x0000A88C0135B4A5 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (3039, N's@g.com', N'123456', N'user', 1, CAST(0x0000A89D012B5F80 AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (3040, N's@gmail.com', N'12345678', N'user', 1, CAST(0x0000A89D012EE74D AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (3041, N'ss@gmail.com', N'123456', N'user', 1, CAST(0x0000A89D012F6DCF AS DateTime))
INSERT [dbo].[logindetails] ([login_id], [emailid], [password], [role], [flag], [date_time]) VALUES (4039, N'receptionist@sterling.com', N'123456789', N'receptionist', 1, CAST(0x0000A89D012F6DCF AS DateTime))
SET IDENTITY_INSERT [dbo].[logindetails] OFF
SET IDENTITY_INSERT [dbo].[doctordetails] ON 

INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (2, 1, 12, N'Dr. Ankur', N'Slll', N'Agarawal', N'Cardiology', NULL, N'8563256325', NULL, 1, CAST(0x0000A8890125F7CD AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (3, 2, 13, N'Dr. Hitesh', N'M', N'Anandkat', N'Pathology', N'MD', N'7589658596', NULL, 1, CAST(0x0000A88C012A807B AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (4, 4, 14, N'Dr. Jayul', N'Mananbhai', N'Kamdar', N'Ms, MCH', N'Paediatric Surgery', N'9658626369', N'8563256963', 1, CAST(0x0000A88C012A807B AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (5, 4, 15, N'Dr. Nishit', N'Rajguru', NULL, N'MBBS', N'Anesthesiology', N'7263256963', NULL, 1, CAST(0x0000A88C012A807B AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (6, 3, 16, N'Dr. Ravish', NULL, N'Atha', N'Dermatology', NULL, N'8563256963', NULL, 1, CAST(0x0000A88C012A807B AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (7, 4, 17, N'Dr. Shaikh', N'Ali', N'Iftekhar', N'Radiation Oncology', NULL, N'9632589654', NULL, 1, CAST(0x0000A88C012A807B AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (14, 29, 38, N'Dr. Ashwin', N'K', N'Patel', N'Medical Doctor', NULL, N'7878787878', NULL, 1, CAST(0x0000A88C012A807B AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (2014, 1018, 2037, N'Dr. Arpit', N'J', N'Patel', N'Doctor of Dental Surgery (D.D.S.)', NULL, N'9569695896', NULL, 1, CAST(0x0000A87C00B3122D AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (2015, 1019, 2038, N'Dr. Vishwesh', N'N', N'Chokshi', N'Doctor of Pharmacy (Pharm.D.)', NULL, N'7854965896', NULL, 1, CAST(0x0000A87C00BD9CA6 AS DateTime))
INSERT [dbo].[doctordetails] ([doctor_id], [hopital_id], [login_id], [firstname], [middlename], [lastname], [speciality1], [speciality2], [mobile1], [mobile2], [flag], [date_time]) VALUES (2016, 1020, 2041, N'Dr. Kush', N'M', N'Jadia', N'Anesthesiologist', NULL, N'9653269635', NULL, 1, CAST(0x0000A88C0135B4A5 AS DateTime))
SET IDENTITY_INSERT [dbo].[doctordetails] OFF
SET IDENTITY_INSERT [dbo].[appointmentdetails] ON 

INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (1, 7, 2, 1, CAST(0xC53D0B00 AS Date), CAST(0x0700A8E76F4B0000 AS Time), 0, CAST(0x0000A88D0130C53B AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (2, 7, 6, 3, CAST(0xC73D0B00 AS Date), CAST(0x0700A8E76F4B0000 AS Time), 0, CAST(0x0000A88D0130CF91 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3, 7, 6, 3, CAST(0xF63D0B00 AS Date), CAST(0x0700E80A7E8E0000 AS Time), 0, CAST(0x0000A89B0118FCAD AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (4, 7, 6, 3, CAST(0xF63D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 0, CAST(0x0000A89B0118FF0E AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (5, 7, 14, 29, CAST(0xF63D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 0, CAST(0x0000A89B0118FDFF AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (6, 7, 7, 4, CAST(0xF63D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 0, CAST(0x0000A89B0118FFEB AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (7, 7, 6, 3, CAST(0xF63D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 0, CAST(0x0000A89B011900C3 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (1007, 7, 2, 1, CAST(0xF63D0B00 AS Date), CAST(0x0700E80A7E8E0000 AS Time), 0, CAST(0x0000A89B0119017E AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (2007, 7, 6, 3, CAST(0xF63D0B00 AS Date), CAST(0x0700E80A7E8E0000 AS Time), 0, CAST(0x0000A89B01190228 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (2008, 7, 2, 1, CAST(0xF63D0B00 AS Date), CAST(0x0700E80A7E8E0000 AS Time), 0, CAST(0x0000A89B011313A8 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3007, 7, 2, 1, CAST(0xFE3D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 1, CAST(0x0000A8A30125EFD4 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3008, 2039, 2, 1, CAST(0xFE3D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 1, CAST(0x0000A8A3012641E5 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3009, 2039, 6, 3, CAST(0xFE3D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 1, CAST(0x0000A8A301265D94 AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3010, 7, 2, 1, CAST(0xFF3D0B00 AS Date), CAST(0x070050CFDF960000 AS Time), 0, CAST(0x0000A8A401390D8D AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3011, 7, 2, 1, CAST(0xFF3D0B00 AS Date), CAST(0x0700709A4A320000 AS Time), 0, CAST(0x0000A8A401391ADE AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3012, 7, 2, 1, CAST(0xFF3D0B00 AS Date), CAST(0x070010ACD1530000 AS Time), 0, CAST(0x0000A8A4013908EB AS DateTime))
INSERT [dbo].[appointmentdetails] ([appointment_id], [login_id], [doctor_id], [hospital_id], [date], [time], [flag], [date_time]) VALUES (3013, 7, 2, 1, CAST(0xFF3D0B00 AS Date), CAST(0x0700709A4A320000 AS Time), 1, CAST(0x0000A8A40136EC3C AS DateTime))
SET IDENTITY_INSERT [dbo].[appointmentdetails] OFF
SET IDENTITY_INSERT [dbo].[receptionistdetails] ON 

INSERT [dbo].[receptionistdetails] ([receptionist_id], [login_id], [doctor_id], [hospital_id], [firstname], [lastname]) VALUES (1, 4039, 2, 1, N'Sanjay', N'Pandya')
SET IDENTITY_INSERT [dbo].[receptionistdetails] OFF
SET IDENTITY_INSERT [dbo].[userdetails] ON 

INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (13, 7, 12, N'Keyul', N'Vinodbhai', N'Patel', N'8866258602', 1, CAST(0x0000A89A014396B1 AS DateTime))
INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (29, 37, 26, N'Keyul', N'Vinodbhai', N'Patel', N'8866258602', 1, CAST(0x0000A87C00A927DD AS DateTime))
INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (1029, 2039, 1028, N'Aman', N'K', N'Prajapati', N'7895641256', 1, CAST(0x0000A88C0133885E AS DateTime))
INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (1030, 2040, 12, N'Kush', NULL, N'Jadia', N'7526326596', 1, CAST(0x0000A88C01346834 AS DateTime))
INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (2029, 3039, NULL, N'Sagar', NULL, N'Suthar', N'90332313', 1, CAST(0x0000A89D012B5F80 AS DateTime))
INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (2030, 3040, NULL, N'Sagar', NULL, N'Suthar', N'1234567890', 1, CAST(0x0000A89D012EE74D AS DateTime))
INSERT [dbo].[userdetails] ([user_id], [login_id], [location_id], [firstname], [middlename], [lastname], [mobile], [flag], [date_time]) VALUES (2031, 3041, NULL, N'Sagar', NULL, N'Suthar', N'8528528528', 1, CAST(0x0000A89D012F6DCF AS DateTime))
SET IDENTITY_INSERT [dbo].[userdetails] OFF
