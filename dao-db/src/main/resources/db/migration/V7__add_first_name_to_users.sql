ALTER TABLE "users" ADD COLUMN "first_name" varchar;
UPDATE "users" SET "first_name" = "first_names"."value" FROM "first_names" WHERE "users"."first_name_id" = "first_names"."id";
ALTER TABLE "users" ALTER COLUMN "first_name" SET NOT NULL;