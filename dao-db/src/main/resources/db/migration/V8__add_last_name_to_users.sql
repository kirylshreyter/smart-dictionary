ALTER TABLE "users" ADD COLUMN "last_name" varchar;
UPDATE "users" SET "last_name" = "last_names"."value" FROM "last_names" WHERE "users"."last_name_id" = "last_names"."id";
ALTER TABLE "users" ALTER COLUMN "last_name" SET NOT NULL;