USE [Information]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 11/6/2020 9:58:50 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblUser]') AND type in (N'U'))
DROP TABLE [dbo].[tblUser]
GO
/****** Object:  Table [dbo].[tblItem]    Script Date: 11/6/2020 9:58:50 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tblItem]') AND type in (N'U'))
DROP TABLE [dbo].[tblItem]
GO
/****** Object:  Table [dbo].[tblItem]    Script Date: 11/6/2020 9:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblItem](
	[id] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
	[price] [int] NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 11/6/2020 9:58:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](30) NULL,
	[lastname] [nvarchar](258) NULL,
	[isAdmin] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'J12', N'Java', 100000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'J55', N'JSP', 400000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'JB', N'Java Bean', 200000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'JP', N'Japan Code Style', 220000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'JV', N'JDK', 332000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'LL', N'Code Clean', 100000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'P11', N'Can You See Me', 400000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'Se', N'Servlet', 300000, 0)
INSERT [dbo].[tblItem] ([id], [name], [price], [quantity]) VALUES (N'TC', N'TomCat', 500000, 0)
GO
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'vantoan', N'123123', N'Van Toan', 0)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'tandat112k', N'123123', N'Dat Tan', 0)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'nanana', N'123123', N'Na Na', 0)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'parameter', N'123123', N'Parameter', 0)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'tandat', N'123123', N'Tan Dat', 1)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'tandatdds', N'123123', N'tandat', 1)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'tandatz', N'123123', N'123123', 0)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'tanphu', N'123123', N'Phu', 1)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'tanphu1', N'123123', N'Tan Phu', 1)
INSERT [dbo].[tblUser] ([username], [password], [lastname], [isAdmin]) VALUES (N'thiminh', N'123123', N'Minh', 1)
GO
