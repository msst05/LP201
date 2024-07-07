using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace SERVICE_DESK.Models
{
    public class Usuario
    {
        [JsonProperty("idUsuario")]
        public int IdUsuario { get; set; }

        
        [Required(ErrorMessage = "El nombre es obligatorio")]
        [RegularExpression("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", ErrorMessage = "Coloque un nombre válido")]
        [StringLength(100, MinimumLength = 3, ErrorMessage = "El nombre debe tener al menos 3 caracteres.")]
        public string nombre { get; set; }
        [Required(ErrorMessage = "El apellido es obligatorio")]
        [RegularExpression("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", ErrorMessage = "Coloque un apellido válido")]
        [StringLength(100, MinimumLength = 3, ErrorMessage = "El apellido debe tener al menos 3 caracteres.")]
        public string apellido { get; set; }

        [Required(ErrorMessage = "El correo es obligatorio")]
        [EmailAddress(ErrorMessage = "Formato de correo no válido")]
        public string correo { get; set; }

        [Required(ErrorMessage = "El rol es obligatorio")]
        [JsonProperty("rol")]
        public string Rol { get; set; }

        [Required(ErrorMessage = "La contraseña es obligatoria")]
        [DataType(DataType.Password)]
        [JsonProperty("contraseña")]
        public string contrasena { get; set; }







    }
}