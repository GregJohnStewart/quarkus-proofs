-- noinspection SqlNoDataSourceInspectionForFile

-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');


CREATE TABLE foo
(
	id int
);

SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;

-- CREATE PROCEDURE testOne(
-- 	@input VARCHAR(100)
-- )
-- AS
-- BEGIN
-- 	SET NOCOUNT ON;
--
-- 	BEGIN TRY
-- 	    BEGIN TRANSACTION -- having this transaction causes issues
-- 		SELECT * FROM foo;
--
-- 		COMMIT TRANSACTION
-- 	END TRY
-- 	BEGIN CATCH
-- 	    ROLLBACK TRANSACTION
-- 		SELECT * FROM foo;
--
-- 	END CATCH
--
-- END;

	CREATE PROCEDURE testTwo(
		@input VARCHAR(100)
	)
	AS
	BEGIN
		SET NOCOUNT ON;

		BEGIN TRY
			SELECT * FROM foo;

		END TRY
		BEGIN CATCH
			SELECT * FROM foo;

		END CATCH

	END;