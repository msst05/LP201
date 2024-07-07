using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using SERVICE_DESK.Models;
using System.Text;

namespace SERVICE_DESK.Controllers
{
    public class UsuarioController : Controller
    {

        private readonly HttpClient _httpClient;

        public UsuarioController(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient();
            _httpClient.BaseAddress = new Uri("http://localhost:8081/"); // Cambia la URL base según tu configuración
        }

        public async Task<IActionResult> ListarUsuarios()
        {
            HttpResponseMessage response = await _httpClient.GetAsync("usuario");

            if (response.IsSuccessStatusCode)
            {
                string responseData = await response.Content.ReadAsStringAsync();
                var usuario = JsonConvert.DeserializeObject<List<Usuario>>(responseData);
                ViewBag.Usuario = usuario;
            }
            else
            {
                ViewBag.Usuario = new List<Usuario>();
            }
            return View();
        }

        [HttpGet]
        public IActionResult CrearUsuario()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> CrearUsuario(Usuario usuario)
        {
            if (!ModelState.IsValid)
            {
                return View(usuario);
            }

            try
            {
                var json = JsonConvert.SerializeObject(usuario);
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                var response = await _httpClient.PostAsync("usuario", content);

                if (response.IsSuccessStatusCode)
                {
                    TempData["mensaje"] = "El usuario se ha creado correctamente.";
                    TempData["mensajeTipo"] = "success";
                    return RedirectToAction("ListarUsuarios");
                }
                else
                {
                    TempData["mensaje"] = "Error al crear el usuario: " + response.ReasonPhrase;
                    TempData["mensajeTipo"] = "error";
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
                TempData["mensajeTipo"] = "error";
            }

            return View(usuario);
        }



        [HttpGet]
        public async Task<ActionResult> BuscarUsuario(int id)
        {
            HttpResponseMessage response = await _httpClient.GetAsync($"usuario/{id}");
            if (response.IsSuccessStatusCode)
            {
                string responseData = await response.Content.ReadAsStringAsync();
                var usuario = JsonConvert.DeserializeObject<Usuario>(responseData);
                ViewBag.Usuario = usuario;
            }
            else
            {
                ViewBag.Usuario = null;
            }

            return View("ActualizarUsuario", ViewBag.Usuario);
        }

        [HttpPost]
        public async Task<IActionResult> ActualizarUsuario(Usuario usuario)
        {
            if (!ModelState.IsValid)
            {
                return View(usuario);
            }
            try
            {
                var json = JsonConvert.SerializeObject(usuario);
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                var response = await _httpClient.PutAsync("usuario", content);

                if (response.IsSuccessStatusCode)
                {
                    TempData["mensaje"] = "El usuario se ha actualizado correctamente.";
                    TempData["mensajeTipo"] = "success";
                    return RedirectToAction("ListarUsuarios");
                }
                else
                {
                    TempData["mensaje"] = "Error al actualizar el usuario: " + response.ReasonPhrase;
                    TempData["mensajeTipo"] = "error";
                    return RedirectToAction("ListarUsuarios");
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
                TempData["mensajeTipo"] = "error";
                return RedirectToAction("ListarUsuarios");
            }
        }


        [HttpPost]
        public async Task<IActionResult> EliminarUsuario(int id)
        {
            try
            {
                var response = await _httpClient.DeleteAsync($"usuario/{id}");

                if (response.IsSuccessStatusCode)
                {
                    TempData["mensaje"] = "El usuario se ha eliminado correctamente.";
                    TempData["mensajeTipo"] = "success";
                }
                else
                {
                    TempData["mensaje"] = "Error al eliminar el usuario: " + response.ReasonPhrase;
                    TempData["mensajeTipo"] = "error";
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
                TempData["mensajeTipo"] = "error";
            }

            return RedirectToAction("ListarUsuarios");
        }


    }
}
