using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using System.Text;
using Newtonsoft.Json;
using SERVICE_DESK.Models;
using System.Net.Http;
using System.Security.Policy;

namespace SERVICE_DESK.Models;

public class TipoConsultaController : Controller
{
    private readonly HttpClient _httpClient;
    public TipoConsultaController(IHttpClientFactory httpClientFactory)
    {
        _httpClient = httpClientFactory.CreateClient();
        _httpClient.BaseAddress = new Uri("http://localhost:8081/");
    }

    public async Task<ActionResult> ListarTipoConsulta()
    {
        HttpResponseMessage response = await _httpClient.GetAsync("tipoConsulta");
        if(response.IsSuccessStatusCode)
        {
            string responseData=await response.Content.ReadAsStringAsync();
            var tipoConsulta=JsonConvert.DeserializeObject<List<tipoConsulta>>(responseData);
            ViewBag.TipoConsulta=tipoConsulta;
        }
        else 
        { 
            ViewBag.TipoConsulta=new List<tipoConsulta>();
        }
        return View();
    }
   



    [HttpGet]
    public IActionResult Crear()
    {
        return View();
    }

    [HttpPost]
    public async Task<IActionResult> CrearTipoConsulta(tipoConsulta tipoConsulta)
    {
        if (!ModelState.IsValid)
        {
            return View(tipoConsulta);
        }
        try
        {
            var json = JsonConvert.SerializeObject(tipoConsulta);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            var response = await _httpClient.PostAsync("tipoConsulta", content);

            if (response.IsSuccessStatusCode)
            {
                TempData["mensaje"] = "El tipo de consulta se ha creado correctamente.";
                TempData["mensajeTipo"] = "success";
                return RedirectToAction("ListarTipoConsulta");
            }
            else
            {
                TempData["mensaje"] = "Error al crear el tipo consulta: " + response.ReasonPhrase;
                TempData["mensajeTipo"] = "error";
            }
        }
        catch (Exception ex)
        {
            TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
            TempData["mensajeTipo"] = "error";
        }

        return View(tipoConsulta);
    }


    [HttpGet]
    public async Task<ActionResult> BuscarTipoConsulta(int id)
    {
        HttpResponseMessage response = await _httpClient.GetAsync($"tipoConsulta/{id}");
        if (response.IsSuccessStatusCode)
        {
            string responseData = await response.Content.ReadAsStringAsync();
            var tipoConsulta = JsonConvert.DeserializeObject<tipoConsulta>(responseData);
            ViewBag.TipoConsulta = tipoConsulta;
        }
        else
        {
            ViewBag.TipoConsulta = null;
        }

        return View("ActualizarTipoConsulta", ViewBag.TipoConsulta);
    }

    [HttpPost]
    public async Task<IActionResult> ActualizarTipoConsulta(tipoConsulta tipoConsulta)
    {
        if (!ModelState.IsValid)
        {
            return View(tipoConsulta);
        }
        try
        {
            var json = JsonConvert.SerializeObject(tipoConsulta);
            var content = new StringContent(json, Encoding.UTF8, "application/json");
            var response = await _httpClient.PutAsync("tipoConsulta", content);

            if (response.IsSuccessStatusCode)
            {
                TempData["mensaje"] = "El tipo de consulta se ha actualizado correctamente.";
                TempData["mensajeTipo"] = "success";
                return RedirectToAction("ListarTipoConsulta");
            }
            else
            {
                TempData["mensaje"] = "Error al altualizar el tipo consulta: " + response.ReasonPhrase;
                TempData["mensajeTipo"] = "error";
                return RedirectToAction("ListarTipoConsulta");

            }
        }
        catch (Exception ex)
        {
            TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
            TempData["mensajeTipo"] = "error";
            return RedirectToAction("ListarTipoConsulta");
        }
    }


    [HttpPost]
    public async Task<IActionResult> EliminarTipoConsulta(int id)
    {
        try
        {
            var response = await _httpClient.DeleteAsync($"tipoConsulta/{id}");

            if (response.IsSuccessStatusCode)
            {
                TempData["mensaje"] = "El tipo de consulta se ha eliminado correctamente.";
                TempData["mensajeTipo"] = "success";
            }
            else
            {
                TempData["mensaje"] = "Error al eliminar el Tipo de Consulta: " + response.ReasonPhrase;
                TempData["mensajeTipo"] = "error";
            }
        }
        catch (Exception ex)
        {
            TempData["mensaje"] = "Error al procesar la solicitud: " + ex.Message;
            TempData["mensajeTipo"] = "error";
        }

        return RedirectToAction("ListarTipoConsulta");
    }


}
