CREATE DATABASE BankManager
GO
USE BankManager
GO

CREATE TABLE Account
(
	id INT IDENTITY PRIMARY KEY,
	accountNumber VARCHAR(50),
	accountName NVARCHAR(50),
	phone VARCHAR(20),
	isActived TINYINT,
)
GO
CREATE TABLE Trading
(
	id BIGINT IDENTITY PRIMARY KEY,
	accountID int,
	tradeDate DATETIME DEFAULT GETDATE(),
	typeTrade VARCHAR(20),
	amount INT,
	FOREIGN KEY (accountID) REFERENCES dbo.Account(id)
)
GO

CREATE PROC Trade
	@accountID int,
	@amount int,
	@typeTrade nvarchar(20)
AS
	INSERT INTO dbo.Trading(accountID,amount,typeTrade)
	VALUES(@accountID,@amount,@typeTrade);
	SELECT @@ROWCOUNT AS result;

CREATE PROC getBalance
	@userID INT
AS
	SELECT (SUM(CASE WHEN typeTrade = 'loaded' THEN amount ELSE 0 END) + SUM(CASE WHEN typeTrade = 'receive' THEN amount ELSE 0 END) - SUM(CASE WHEN typeTrade = 'withdraw' THEN amount ELSE 0 END) - SUM(CASE WHEN typeTrade = 'transfer' THEN amount ELSE 0 END)) AS balance
	FROM dbo.Trading
	WHERE accountID = @userID

CREATE PROC getHistory
	@userID int
AS
SELECT 
	tradeDate,
	CASE
	WHEN typeTrade = 'loaded' THEN N'Nạp Tiền'
	WHEN typeTrade = 'withdraw' THEN N'Rút Tiền'
	WHEN typeTrade = 'transfer' THEN N'Chuyển Khoản'
	WHEN typeTrade = 'receive' THEN N'Nhận Chuyển Khoản'
	END AS typeTrade,
	amount
FROM Trading
WHERE accountID = @userID