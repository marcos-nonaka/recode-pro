using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Borabora.Migrations
{
    public partial class inicial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Destino",
                columns: table => new
                {
                    DestinoId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome_destino = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    Data_ida = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    Horario_ida = table.Column<string>(type: "nvarchar(10)", maxLength: 10, nullable: false),
                    Data_volta = table.Column<string>(type: "nvarchar(15)", maxLength: 15, nullable: false),
                    Horario_volta = table.Column<string>(type: "nvarchar(10)", maxLength: 10, nullable: false),
                    Cia_aerea = table.Column<string>(type: "nvarchar(15)", maxLength: 15, nullable: false),
                    Hotel = table.Column<string>(type: "nvarchar(50)", maxLength: 50, nullable: false),
                    Observacoes = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: false),
                    Valor = table.Column<double>(type: "float", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Destino", x => x.DestinoId);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Destino");
        }
    }
}
