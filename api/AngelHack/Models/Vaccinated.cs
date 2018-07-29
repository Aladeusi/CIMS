using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AngelHack.Models
{
    [Table("Vaccinated")]
    public class Vaccinated
    {
        public int VaccinatedID { get; set; }
        public string ChildID { get; set; }
        public int VaccineID { get; set; }
        public DateTime Date { get; set; }

        [ForeignKey("ChildID")]
        public Child Child { get; set; }
        [ForeignKey("VaccineID")]
        public Vaccine Vaccine { get; set; }
    }
}