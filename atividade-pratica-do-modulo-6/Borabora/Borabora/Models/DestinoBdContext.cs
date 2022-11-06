using Microsoft.EntityFrameworkCore;

namespace Borabora.Models
{
    public class DestinoDbContext : DbContext
    {
        public DestinoDbContext(DbContextOptions<DestinoDbContext> options)
          : base(options)
        { }

        public DbSet<Destino> Destinos { get; set; }
    }
}