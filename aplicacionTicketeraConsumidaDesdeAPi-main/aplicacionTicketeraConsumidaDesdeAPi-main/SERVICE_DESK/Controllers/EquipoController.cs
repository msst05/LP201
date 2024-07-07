using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using System.Text;
using Newtonsoft.Json;
using SERVICE_DESK.Models;
using System.Net.Http;
using System.Security.Policy;

namespace SERVICE_DESK.Controllers
{
    public class EquipoController : Controller
    {
        private readonly HttpClient _httpClient;

        public EquipoController(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient();
            _httpClient.BaseAddress = new Uri("http://localhost:8081/"); // Cambia la URL base según tu configuración
        }

       
        public async Task<IActionResult> ListarEquipos()
        {
            HttpResponseMessage response = await _httpClient.GetAsync("equipo");

            if (response.IsSuccessStatusCode)
            {
                string responseData = await response.Content.ReadAsStringAsync();
                var equipos = JsonConvert.DeserializeObject<List<equipo>>(responseData);
                ViewBag.Equipos = equipos;
            }
            else
            {
                ViewBag.Equipos = new List<equipo>();
            }
            return View();
        }

        [HttpGet]
        public IActionResult CrearEquipo()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> CrearEquipo(equipo equipo)
        {

            if (!ModelState.IsValid)
            {
                return View(equipo);
            }
            try
            {
                var json = JsonConvert.SerializeObject(equipo);
                var content = new StringContent(json, Encoding.UTF8, "application/json");

                var response = await _httpClient.PostAsync("equipo", content);

                if (response.IsSuccessStatusCode)
                {
                    TempData["mensaje"] = "El equipo se ha creado correctamente.";
                    TempData["mensajeTipo"] = "success";
                    return RedirectToAction("ListarEquipos");
                }
                else
                {
                    TempData["mensaje"] = "Error al crear el equipo: " + response.ReasonPhrase;
                    TempData["mensajeTipo"] = "error";
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
                TempData["mensajeTipo"] = "error";
            }

            return View(equipo); 
        }


        [HttpGet]
        public async Task<ActionResult> BuscarEquipo(int id)
        {
            HttpResponseMessage response = await _httpClient.GetAsync($"equipo/{id}");
            if (response.IsSuccessStatusCode)
            {
                string responseData = await response.Content.ReadAsStringAsync();
                var equipo = JsonConvert.DeserializeObject<equipo>(responseData);
                ViewBag.Equipo = equipo;
            }
            else
            {
                ViewBag.Equipo = null;
            }

            return View("ActualizarEquipo", ViewBag.Equipo);
        }

        [HttpPost]
        public async Task<IActionResult> ActualizarEquipo(equipo equipo)
        {
            if (!ModelState.IsValid)
            {
                return View(equipo);
            }
            try
            {
                var json = JsonConvert.SerializeObject(equipo);
                var content = new StringContent(json, Encoding.UTF8, "application/json");
                var response = await _httpClient.PutAsync("equipo", content);

                if (response.IsSuccessStatusCode)
                {
                    TempData["mensaje"] = "El equipo se ha actualizado correctamente.";
                    TempData["mensajeTipo"] = "success";
                    return RedirectToAction("ListarEquipos");
                }
                else
                {
                    TempData["mensaje"] = "Error al actualizar el equipo: " + response.ReasonPhrase;
                    TempData["mensajeTipo"] = "error";
                    return RedirectToAction("ListarEquipos");
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
                TempData["mensajeTipo"] = "error";
                return RedirectToAction("ListarEquipos");
            }
        }


        [HttpPost]
        public async Task<IActionResult> EliminarEquipo(int id)
        {
            try
            {
                var response = await _httpClient.DeleteAsync($"equipo/{id}");

                if (response.IsSuccessStatusCode)
                {
                    TempData["mensaje"] = "El equipo se ha eliminado correctamente.";
                    TempData["mensajeTipo"] = "success";
                }
                else
                {
                    TempData["mensaje"] = "Error al eliminar el equipo: " + response.ReasonPhrase;
                    TempData["mensajeTipo"] = "error";
                }
            }
            catch (Exception ex)
            {
                TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
                TempData["mensajeTipo"] = "error";
            }

            return RedirectToAction("ListarEquipos");
        }


      
    }

   
   
    
}

