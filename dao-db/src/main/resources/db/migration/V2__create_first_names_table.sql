CREATE TABLE "first_names" (
	"id" serial NOT NULL,
	"value" varchar NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);

ALTER TABLE "first_names" ADD CONSTRAINT "first_names_pk" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "index_first_names_on_value" ON "first_names"("value");
