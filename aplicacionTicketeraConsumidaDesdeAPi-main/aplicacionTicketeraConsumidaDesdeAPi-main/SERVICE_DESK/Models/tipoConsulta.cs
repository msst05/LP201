using System.ComponentModel.DataAnnotations;

namespace SERVICE_DESK.Models
{
    public class tipoConsulta
    {
        public int idTipoConsulta { get; set; }

        [Required(ErrorMessage = "El tipo de consulta es obligatorio")]
        [RegularExpression("^[a-zA-Z0-9 ]*$", ErrorMessage = "Coloque un tipo de consulta válido")]
        [StringLength(100, MinimumLength = 3, ErrorMessage = "El tipo de consulta debe tener al menos 3 caracteres.")]
        public string descripcion { get; set; }
    }
}
