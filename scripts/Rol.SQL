CREATE TABLE "Rol" (
	"ID" INTEGER NULL DEFAULT NULL,
	"Nombre" VARCHAR(50) NULL DEFAULT NULL::character varying,
	"Descripcion" VARCHAR(500) NULL DEFAULT NULL::character varying
)
;
COMMENT ON COLUMN "TBL_Rol"."ID" IS E'';
COMMENT ON COLUMN "TBL_Rol"."Nombre" IS E'';
COMMENT ON COLUMN "TBL_Rol"."Descripcion" IS E'';
