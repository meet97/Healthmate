USE [master]
GO
/****** Object:  Database [Gtu_Healthmate]    Script Date: 3/15/2018 7:30:24 PM ******/
CREATE DATABASE [Gtu_Healthmate]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Gtu_Healthmate', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Gtu_Healthmate.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Gtu_Healthmate_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Gtu_Healthmate_log.ldf' , SIZE = 3136KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Gtu_Healthmate] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Gtu_Healthmate].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Gtu_Healthmate] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET ARITHABORT OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Gtu_Healthmate] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Gtu_Healthmate] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Gtu_Healthmate] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Gtu_Healthmate] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Gtu_Healthmate] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Gtu_Healthmate] SET  MULTI_USER 
GO
ALTER DATABASE [Gtu_Healthmate] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Gtu_Healthmate] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Gtu_Healthmate] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Gtu_Healthmate] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Gtu_Healthmate]
GO
/****** Object:  Table [dbo].[appointmentdetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[appointmentdetails](
	[appointment_id] [int] IDENTITY(1,1) NOT NULL,
	[login_id] [int] NULL,
	[doctor_id] [int] NOT NULL,
	[hospital_id] [int] NOT NULL,
	[date] [date] NULL,
	[time] [time](7) NULL,
	[flag] [bit] NULL,
	[date_time] [datetime] NULL,
 CONSTRAINT [PK_appointmentdetails] PRIMARY KEY CLUSTERED 
(
	[appointment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[doctordetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[doctordetails](
	[doctor_id] [int] IDENTITY(1,1) NOT NULL,
	[hopital_id] [int] NULL,
	[login_id] [int] NULL,
	[firstname] [varchar](50) NULL,
	[middlename] [varchar](50) NULL,
	[lastname] [varchar](50) NULL,
	[speciality1] [varchar](50) NULL,
	[speciality2] [varchar](50) NULL,
	[mobile1] [varchar](50) NULL,
	[mobile2] [varchar](50) NULL,
	[flag] [bit] NULL,
	[date_time] [datetime] NULL,
 CONSTRAINT [PK_doctordetails] PRIMARY KEY CLUSTERED 
(
	[doctor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[hospitaldetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[hospitaldetails](
	[hospital_id] [int] IDENTITY(1,1) NOT NULL,
	[location_id] [int] NULL,
	[hospitalname] [varchar](50) NOT NULL,
	[mobile1] [varchar](50) NULL,
	[mobile2] [varchar](50) NULL,
	[emailid1] [varchar](50) NULL,
	[emailid2] [varchar](50) NULL,
	[flag] [bit] NULL,
	[date_time] [datetime] NULL,
 CONSTRAINT [PK_hospitaldetails] PRIMARY KEY CLUSTERED 
(
	[hospital_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[locationdetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[locationdetails](
	[location_id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](50) NULL,
	[area] [varchar](50) NULL,
	[city] [varchar](50) NULL,
	[state] [varchar](50) NULL,
	[country] [varchar](50) NULL,
	[pincode] [varchar](50) NULL,
	[flag] [bit] NULL,
	[date_time] [datetime] NULL,
 CONSTRAINT [PK_locationdetails] PRIMARY KEY CLUSTERED 
(
	[location_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[logindetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[logindetails](
	[login_id] [int] IDENTITY(1,1) NOT NULL,
	[emailid] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[role] [varchar](50) NOT NULL,
	[flag] [bit] NULL,
	[date_time] [datetime] NULL,
 CONSTRAINT [PK_logindetails] PRIMARY KEY CLUSTERED 
(
	[login_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[receptionistdetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[receptionistdetails](
	[receptionist_id] [int] IDENTITY(1,1) NOT NULL,
	[login_id] [int] NOT NULL,
	[doctor_id] [int] NOT NULL,
	[hospital_id] [int] NOT NULL,
	[firstname] [varchar](50) NULL,
	[lastname] [varchar](50) NULL,
 CONSTRAINT [PK_receptionistdetails] PRIMARY KEY CLUSTERED 
(
	[receptionist_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[userdetails]    Script Date: 3/15/2018 7:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[userdetails](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[login_id] [int] NULL,
	[location_id] [int] NULL,
	[firstname] [varchar](50) NOT NULL,
	[middlename] [varchar](50) NULL,
	[lastname] [varchar](50) NULL,
	[mobile] [varchar](50) NOT NULL,
	[flag] [bit] NULL,
	[date_time] [datetime] NULL,
 CONSTRAINT [PK_userdetails] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[appointmentdetails]  WITH CHECK ADD  CONSTRAINT [FK_doctor] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[doctordetails] ([doctor_id])
GO
ALTER TABLE [dbo].[appointmentdetails] CHECK CONSTRAINT [FK_doctor]
GO
ALTER TABLE [dbo].[appointmentdetails]  WITH CHECK ADD  CONSTRAINT [FK_hospital] FOREIGN KEY([hospital_id])
REFERENCES [dbo].[hospitaldetails] ([hospital_id])
GO
ALTER TABLE [dbo].[appointmentdetails] CHECK CONSTRAINT [FK_hospital]
GO
ALTER TABLE [dbo].[appointmentdetails]  WITH CHECK ADD  CONSTRAINT [FK_login] FOREIGN KEY([login_id])
REFERENCES [dbo].[logindetails] ([login_id])
GO
ALTER TABLE [dbo].[appointmentdetails] CHECK CONSTRAINT [FK_login]
GO
ALTER TABLE [dbo].[doctordetails]  WITH CHECK ADD  CONSTRAINT [FK_doctordetails_hospitaldetails] FOREIGN KEY([hopital_id])
REFERENCES [dbo].[hospitaldetails] ([hospital_id])
GO
ALTER TABLE [dbo].[doctordetails] CHECK CONSTRAINT [FK_doctordetails_hospitaldetails]
GO
ALTER TABLE [dbo].[doctordetails]  WITH CHECK ADD  CONSTRAINT [FK_doctordetails_logindetails] FOREIGN KEY([login_id])
REFERENCES [dbo].[logindetails] ([login_id])
GO
ALTER TABLE [dbo].[doctordetails] CHECK CONSTRAINT [FK_doctordetails_logindetails]
GO
ALTER TABLE [dbo].[hospitaldetails]  WITH CHECK ADD  CONSTRAINT [FK_hospitaldetails_hospitaldetails_locationID] FOREIGN KEY([location_id])
REFERENCES [dbo].[locationdetails] ([location_id])
GO
ALTER TABLE [dbo].[hospitaldetails] CHECK CONSTRAINT [FK_hospitaldetails_hospitaldetails_locationID]
GO
ALTER TABLE [dbo].[receptionistdetails]  WITH CHECK ADD  CONSTRAINT [FK_receptionistdetails_doctorid] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[doctordetails] ([doctor_id])
GO
ALTER TABLE [dbo].[receptionistdetails] CHECK CONSTRAINT [FK_receptionistdetails_doctorid]
GO
ALTER TABLE [dbo].[receptionistdetails]  WITH CHECK ADD  CONSTRAINT [FK_receptionistdetails_hospitalid] FOREIGN KEY([hospital_id])
REFERENCES [dbo].[hospitaldetails] ([hospital_id])
GO
ALTER TABLE [dbo].[receptionistdetails] CHECK CONSTRAINT [FK_receptionistdetails_hospitalid]
GO
ALTER TABLE [dbo].[receptionistdetails]  WITH CHECK ADD  CONSTRAINT [FK_receptionistdetails_loginid] FOREIGN KEY([login_id])
REFERENCES [dbo].[logindetails] ([login_id])
GO
ALTER TABLE [dbo].[receptionistdetails] CHECK CONSTRAINT [FK_receptionistdetails_loginid]
GO
ALTER TABLE [dbo].[userdetails]  WITH CHECK ADD  CONSTRAINT [FK_userdetails_locationdetails] FOREIGN KEY([location_id])
REFERENCES [dbo].[locationdetails] ([location_id])
GO
ALTER TABLE [dbo].[userdetails] CHECK CONSTRAINT [FK_userdetails_locationdetails]
GO
ALTER TABLE [dbo].[userdetails]  WITH CHECK ADD  CONSTRAINT [FK_userdetails_logindetails] FOREIGN KEY([login_id])
REFERENCES [dbo].[logindetails] ([login_id])
GO
ALTER TABLE [dbo].[userdetails] CHECK CONSTRAINT [FK_userdetails_logindetails]
GO
USE [master]
GO
ALTER DATABASE [Gtu_Healthmate] SET  READ_WRITE 
GO
