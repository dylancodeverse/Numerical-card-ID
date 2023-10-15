using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using System.Data;
using System.Data.SqlClient; // Ou tout autre fournisseur de base de données pris en charge par Dapper
using Dapper;
using HealthApplication.Models;

namespace HealthApplication.Controllers
{
    [ApiController]
    [Route("api/health")]
    public class HealthController : ControllerBase
    {
        private readonly HealthRepository _healthRepository;

        public HealthController(HealthRepository healthRepository)
        {
            _healthRepository = healthRepository;
        }

        [HttpGet("{cardId}")]
        public IActionResult GetHealthByCardId(string cardId)
        {
            try
            {
                HealthInf health = _healthRepository.GetHealthByCardId(cardId);

                if (health != null)
                {
                    return Ok(health);
                }
                else
                {
                    return NotFound();
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }

        // Autres actions CRUD ici
    }
}