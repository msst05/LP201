using System.ComponentModel.DataAnnotations;

namespace SERVICE_DESK.Models
{
    public class equipo
    {
        public int idEquipo { get; set; }

        [Required(ErrorMessage = "El equipo es obligatorio")]
        [RegularExpression("^[a-zA-Z0-9 ]*$", ErrorMessage = "Coloque un equipo válido")]
        [StringLength(100, MinimumLength = 3, ErrorMessage = "El equipo debe tener al menos 3 caracteres.")]
        public string descripcion { get; set; }
    }
}
