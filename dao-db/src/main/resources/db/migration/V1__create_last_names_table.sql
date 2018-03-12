CREATE TABLE "last_names" (
	"id" serial NOT NULL,
	"value" varchar NOT NULL UNIQUE
) WITH (
  OIDS=FALSE
);

ALTER TABLE "last_names" ADD CONSTRAINT "last_names_pk" PRIMARY KEY ("id");

CREATE UNIQUE INDEX "index_last_names_on_value" ON "last_names"("value");
