using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Borabora.Models
{

    [Table("Destino")]
    public class Destino
    {
        [Key]
        public int DestinoId { get; set; }
        [Required(ErrorMessage = "Informe o nome do destino")]
        [StringLength(50)]
        public string Nome_destino { get; set; }
        [Required(ErrorMessage = "Informe a data de ida")]
        [StringLength(50)]
        public string Data_ida { get; set; }
        [Required(ErrorMessage = "Informe o horário de ida")]
        [StringLength(10)]
        public string Horario_ida { get; set; }
        [Required(ErrorMessage = "Informe a data de volta")]
        [StringLength(15)]
        public string Data_volta { get; set; }
        [Required(ErrorMessage = "Informe o horário de volta")]
        [StringLength(10)]
        public string Horario_volta { get; set; }
        [Required(ErrorMessage = "Informe a cia aérea")]
        [StringLength(15)]
        public string Cia_aerea { get; set; }
        [Required(ErrorMessage = "Informe o hotel")]
        [StringLength(50)]
        public string Hotel { get; set; }
        [Required(ErrorMessage = "Informe as observações")]
        [StringLength(100)]
        public string Observacoes { get; set; }
        [Required(ErrorMessage = "Informe o valor")]
        public double Valor { get; set; }
    }
}
